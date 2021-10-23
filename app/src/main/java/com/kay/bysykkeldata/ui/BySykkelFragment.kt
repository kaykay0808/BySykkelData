package com.kay.bysykkeldata.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.kay.bysykkeldata.databinding.BySykkelFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class BySykkelFragment : Fragment() {

    private var _binding: BySykkelFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BySykkelViewModel by viewModel()
    private val adapter: BySykkelAdapter by lazy { BySykkelAdapter() }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = BySykkelFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getInfo()
        binding.swipeRefreshLayout.setOnRefreshListener { viewModel.getInfo() }

        //recycler view
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())

        // observe LiveData
        viewModel.liveData.observe(viewLifecycleOwner, {setupList(it)})
        viewModel.errorLiveData.observe(viewLifecycleOwner){
            if (it == null){
                // if the error is null, show the list and hide the error textview
                binding.noConnectionTv.isVisible = false
                binding.recyclerView.isVisible = true
            } else {
                // if the error is not null, show the error text view and hide the list
                binding.recyclerView.isVisible = false
                binding.noConnectionTv.isVisible = true
            }
        }
    }

    private fun setupList(data: List<BySykkelUiModel>) {
        adapter.setData(data)
        binding.swipeRefreshLayout.isRefreshing = false
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
// TODO: set the list to visible if the error is null, and set the error text view to visible if the error live data is not null
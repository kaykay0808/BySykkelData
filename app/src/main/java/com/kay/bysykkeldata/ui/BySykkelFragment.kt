package com.kay.bysykkeldata.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
    }

    private fun setupList(data: List<BySykkelUiModel>) {
        adapter.setData(data)
        binding.recyclerView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
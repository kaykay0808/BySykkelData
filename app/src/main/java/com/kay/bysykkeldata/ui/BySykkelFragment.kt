package com.kay.bysykkeldata.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kay.bysykkeldata.databinding.BySykkelFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class BySykkelFragment : Fragment() {

    private var _binding: BySykkelFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BySykkelViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = BySykkelFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
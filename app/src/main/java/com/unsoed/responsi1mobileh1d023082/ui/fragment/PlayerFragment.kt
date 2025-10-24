package com.unsoed.responsi1mobileh1d023082.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.unsoed.responsi1mobileh1d023082.databinding.FagmentPlayerBinding
import com.unsoed.responsi1mobileh1d023082.R

class PlayerFragment(
    private val name: String,
    private val birth: String,
    private val nationality: String,
    private val position: String
) : BottomSheetDialogFragment() {
    private var _binding: FagmentPlayerBinding? = null
    private val binding get() = _binding!!

    override fun getTheme(): Int = com.google.android.material.R.style.Theme_Design_BottomSheetDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FagmentPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
    }

    private fun loadData() {
        binding.tvPlayerName.text = name
        binding.tvPlayerBirth.text = birth
        binding.tvPlayerNationality.text = nationality
        binding.tvPlayerPosition.text = position
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
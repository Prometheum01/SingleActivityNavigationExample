package com.rurouni.singleactivtiyexample.view.main_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.rurouni.singleactivtiyexample.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {
    private var _binding : FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    private val args : SettingsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAndSetUserId()
    }

    private fun getAndSetUserId() {
        binding.tvUserId.text = args.userId
    }

}
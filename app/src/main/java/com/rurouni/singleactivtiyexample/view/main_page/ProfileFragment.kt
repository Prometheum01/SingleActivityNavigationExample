package com.rurouni.singleactivtiyexample.view.main_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.rurouni.singleactivtiyexample.R
import com.rurouni.singleactivtiyexample.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private var _binding : FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logout()
        toSettings()
    }

    private fun toSettings() {
        binding.buttonToSettings.setOnClickListener {
            val action =
                ProfileFragmentDirections.actionProfileFragmentToSettingsFragment("get321fd321gg132gh231")
            findNavController().navigate(action)
        }
    }

    private fun logout() {
        binding.buttonLogout.setOnClickListener {
            val action =
                ProfileFragmentDirections.actionProfileFragmentToAuthenticationNavigation()
            val navOptions =     NavOptions.Builder()
                .setPopUpTo(R.id.app_navigation, true)
                .build()
            findNavController().navigate(action, navOptions)
        }
    }
}
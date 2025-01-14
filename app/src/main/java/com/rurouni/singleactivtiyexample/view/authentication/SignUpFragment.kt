package com.rurouni.singleactivtiyexample.view.authentication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.rurouni.singleactivtiyexample.R
import com.rurouni.singleactivtiyexample.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {
    private var _binding : FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toLogin()
        toMain()
    }

    private fun toMain() {
        binding.buttonToMain.setOnClickListener {
            val action =
                SignUpFragmentDirections.actionGlobalHomeFragment()
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.signUpFragment, true)
                .build()
            findNavController().navigate(action, navOptions)
        }
    }

    private fun toLogin() {
        binding.buttonToLogin.setOnClickListener {
            val action =
                SignUpFragmentDirections.actionSignUpFragmentToLoginFragment()

            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.signUpFragment, true)
                .build()

            findNavController().navigate(action, navOptions)
        }
    }
}
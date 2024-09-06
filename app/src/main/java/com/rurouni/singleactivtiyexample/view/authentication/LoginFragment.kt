package com.rurouni.singleactivtiyexample.view.authentication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.rurouni.singleactivtiyexample.R
import com.rurouni.singleactivtiyexample.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toSignUp()
        toMain()
    }

    private fun toMain() {
        binding.buttonToMain.setOnClickListener {
            val action =
                LoginFragmentDirections.actionGlobalHomeFragment()
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.loginFragment, true)
                .build()
            findNavController().navigate(action, navOptions)
        }
    }

    private fun toSignUp() {
        binding.buttonToSignup.setOnClickListener {
            val action =
                LoginFragmentDirections.actionLoginFragmentToSignUpFragment()
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.loginFragment, true)
                .build()

            findNavController().navigate(action, navOptions)
        }
    }
}
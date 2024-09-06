package com.rurouni.singleactivtiyexample.view.main_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.rurouni.singleactivtiyexample.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return  view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toPost()
    }

    private fun toPost() {
        binding.buttonToPost.setOnClickListener {
            val action =
                HomeFragmentDirections.actionHomeFragmentToPostFragment("ed123ds23zhct3213thyf121y")
            findNavController().navigate(action)
        }
    }
}
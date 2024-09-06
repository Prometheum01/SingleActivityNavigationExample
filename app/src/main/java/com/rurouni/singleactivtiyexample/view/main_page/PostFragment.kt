package com.rurouni.singleactivtiyexample.view.main_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.rurouni.singleactivtiyexample.databinding.FragmentPostBinding

class PostFragment : Fragment() {
    private var _binding : FragmentPostBinding? = null
    private val binding get() = _binding!!

    private val args : PostFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPostBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAndSetId()
    }

    private fun getAndSetId() {
        binding.tvPostId.text = args.postId
    }

}
package com.github.sinhasamarth.quizguru.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.github.sinhasamarth.quizguru.R
import com.github.sinhasamarth.quizguru.databinding.FragmentSelectLevelBinding
import com.github.sinhasamarth.quizguru.viewModel.MainViewModel
import org.koin.android.ext.android.get

class SelectLevelFragment : Fragment() {

    private lateinit var binding: FragmentSelectLevelBinding
    private val sharedViewModel = get<MainViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSelectLevelBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.easyBtn.setOnClickListener {
            setLevel(0)
        }
        binding.medBtn.setOnClickListener {
            setLevel(1)
        }
        binding.hardBtn.setOnClickListener {
            setLevel(2)
        }
    }

    private fun setLevel(level: Int) {
        sharedViewModel.selectedLevel = level
        findNavController().navigate(R.id.action_selectLevelFragment_to_questionsFragment)
    }


}
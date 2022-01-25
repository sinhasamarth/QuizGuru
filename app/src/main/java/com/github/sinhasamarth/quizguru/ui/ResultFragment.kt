package com.github.sinhasamarth.quizguru.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.github.sinhasamarth.quizguru.R
import com.github.sinhasamarth.quizguru.databinding.FragmentResultBinding
import com.github.sinhasamarth.quizguru.viewModel.MainViewModel

class ResultFragment() : Fragment() {

    private lateinit var binding: FragmentResultBinding
    private val sharedViewModel: MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUI()
        sharedViewModel.resetCounters()
    }

    @SuppressLint("SetTextI18n")
    private fun setUI() {
        binding.main.correctQuestionCount.text =
            sharedViewModel.correctAnswerCount.toString() + "/10"
        binding.main.StreakScoreText.text = sharedViewModel.streakof.toString()
        binding.main.totalScore.text = (sharedViewModel.correctAnswerCount * 10).toString()
        binding.main.tryAgainBtn.setOnClickListener {
            findNavController()
                .navigate(R.id.action_resultFragment_to_questionsFragment2)
        }
        binding.main.homeBtn.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_categoriesFragment)
        }
        activity?.onBackPressedDispatcher?.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().navigate(R.id.action_resultFragment_to_selectLevelFragment)
            }

        })
    }

}
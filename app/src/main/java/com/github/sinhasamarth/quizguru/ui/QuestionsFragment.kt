package com.github.sinhasamarth.quizguru.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.github.sinhasamarth.quizguru.R
import com.github.sinhasamarth.quizguru.viewModel.MainViewModel

class QuestionsFragment : Fragment() {

    private val sharedViewModel: MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_questions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel.getAllQuestion()
        sharedViewModel.allQuestionList.observe(viewLifecycleOwner, {
            Log.d("HIII", it.toString())
        })
    }
}
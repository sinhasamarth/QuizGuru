package com.github.sinhasamarth.quizguru.ui

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.github.sinhasamarth.quizguru.R
import com.github.sinhasamarth.quizguru.databinding.FragmentQuestionsBinding
import com.github.sinhasamarth.quizguru.model.QuestionModel
import com.github.sinhasamarth.quizguru.model.Result
import com.github.sinhasamarth.quizguru.viewModel.MainViewModel

class QuestionsFragment : Fragment() {

    private val sharedViewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentQuestionsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuestionsBinding.inflate(layoutInflater)
        binding.parentLayout.visibility = View.INVISIBLE
        activity?.findViewById<CardView>(R.id.loadingScreen)?.visibility = View.VISIBLE
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel.getAllQuestion()
        sharedViewModel.allQuestionList.observe(viewLifecycleOwner, {
            if (it != null) {
                binding.parentLayout.visibility = View.VISIBLE
                activity?.findViewById<CardView>(R.id.loadingScreen)?.visibility = View.INVISIBLE
                setQuestion(it)
            }
        })
    }

    private fun setQuestion(
        questionData: QuestionModel,
        questionNo: Int = 0,
        prevFlag: Boolean = false
    ) {

        if (prevFlag) {
            resetDrawable()
        }
        val data = questionData.results[questionNo]
        val selectedOption = MutableLiveData(-1)
        val randomNo = (0..3).random()

        // Default UI
        setDefaultUI(questionNo)

        // Set Question
        setOptionsText(data, randomNo)

        // Observer
        selectedOption.observe(
            viewLifecycleOwner, {
                if (it != -1)
                    binding.nextBtn.visibility = View.VISIBLE
            }
        )

        binding.levelName.text = sharedViewModel.levelString.uppercase()
        binding.questionCounter.text = (questionNo + 1).toString()
        binding.questionText.text = data.question

        binding.optionOne.setOnClickListener {
            resetColor(it)
            selectedOption.postValue(0)
        }
        binding.optionTwo.setOnClickListener {
            resetColor(it)
            selectedOption.postValue(1)
        }
        binding.optionThree.setOnClickListener {
            resetColor(it)
            selectedOption.postValue(2)
        }
        binding.optionFour.setOnClickListener {
            resetColor(it)
            selectedOption.postValue(3)
        }
        binding.nextBtn.setOnClickListener {
            if (questionNo <= 8) {
                if (selectedOption.value == randomNo) {
                    sharedViewModel.correctAnswer(true)
                }
                setQuestion(questionData, questionNo + 1)
                resetDrawable()
            } else {
                findNavController().navigate(R.id.action_questionsFragment_to_resultFragment2)
            }
        }

        binding.preBtn.setOnClickListener {
            setQuestion(questionData, questionNo - 1, true)
        }

    }

    private fun setDefaultUI(questionNo: Int) {
        binding.nextBtn.visibility = View.GONE
        if (questionNo == 0) {
            binding.preBtn.visibility = View.GONE
        } else if (questionNo == 9) {
            binding.nextBtn.text = "Finish"
        } else {
            binding.preBtn.visibility = View.VISIBLE
            binding.nextBtn.text = "Next"
        }

    }


    private fun setOptionsText(
        data: Result,
        randomNo: Int,
        list: MutableList<Int> = mutableListOf(0, 1, 2, 3)
    ) {
        val textViewList = mutableListOf(
            binding.optionOneValue,
            binding.optionTwoValue,
            binding.optionThreeValue,
            binding.optionFourValue
        )

        list.remove(randomNo)

        textViewList[randomNo].text = data.correct_answer.trim()
        var counter = 0
        list.forEach {
            textViewList[it].text = data.incorrect_answers[counter++]
        }
    }

    private fun resetColor(view: View) {
        resetDrawable()
        view.background = ContextCompat.getDrawable(requireContext(), R.drawable.round_corner)
    }

    private fun resetDrawable() {
        binding.optionOne.setBackgroundColor(Color.TRANSPARENT)
        binding.optionTwo.setBackgroundColor(Color.TRANSPARENT)
        binding.optionThree.setBackgroundColor(Color.TRANSPARENT)
        binding.optionFour.setBackgroundColor(Color.TRANSPARENT)
    }
}
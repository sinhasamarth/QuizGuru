package com.github.sinhasamarth.quizguru.viewModel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.sinhasamarth.quizguru.model.CategoryModel
import com.github.sinhasamarth.quizguru.model.QuestionModel
import com.github.sinhasamarth.quizguru.model.TriviaCategory
import com.github.sinhasamarth.quizguru.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    val allCategoryList = MutableLiveData<CategoryModel>()
    var selectedCategory: TriviaCategory? = null
    var selectedLevel = 0
    val allQuestionList = MutableLiveData<QuestionModel>()
    var correctAnswerCount = 0
    var streakof = 0
    var levelString = "easy"

    fun getAllCategory() {
        GlobalScope.launch(Dispatchers.IO) {
            val getData = Repository.getAllCategory()
            withContext(Dispatchers.Main) {
                allCategoryList.postValue(getData)
            }
        }
    }

    fun setSelectedCat(position: Int) {
        selectedCategory = allCategoryList.value?.trivia_categories?.get(position)
    }

    fun getAllQuestion() {
        GlobalScope.launch {
            val level: String = when (selectedLevel) {
                0 -> "easy"
                1 -> "medium"
                2 -> "hard"
                else -> ""
            }
            levelString = level
            val data = Repository.getQuestion(selectedCategory!!.id, levelString)
            withContext(Dispatchers.Main) {
                allQuestionList.value = data
            }
        }

    }

    fun correctAnswer(boolean: Boolean) {
        if (boolean) {
            streakof++;correctAnswerCount++
        } else streakof = 0
    }

    fun resetCounters(){
        streakof = 0
        correctAnswerCount= 0
    }
}
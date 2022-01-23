package com.github.sinhasamarth.quizguru.viewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.sinhasamarth.quizguru.model.CategoryModel
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
}
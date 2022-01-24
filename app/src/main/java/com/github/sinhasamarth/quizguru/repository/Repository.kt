package com.github.sinhasamarth.quizguru.repository

import com.github.sinhasamarth.quizguru.api.RetrofitInstance
import com.github.sinhasamarth.quizguru.model.CategoryModel

object Repository {

    suspend fun getAllCategory(): CategoryModel {
        return RetrofitInstance.myApi.getAllCategory()
    }

    suspend fun getQuestion(catId: Int, level: String) =
        RetrofitInstance.myApi.getAllQuestion(catId = catId, level = level)
}
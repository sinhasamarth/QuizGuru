package com.github.sinhasamarth.quizguru.repository

import com.github.sinhasamarth.quizguru.api.RetrofitInstance
import com.github.sinhasamarth.quizguru.model.CategoryModel

class Repository(val retrofit: RetrofitInstance) {

    suspend fun getAllCategory(): CategoryModel {
        return retrofit.myApi.getAllCategory()
    }

    suspend fun getQuestion(catId: Int, level: String) =
        retrofit.myApi.getAllQuestion(catId = catId, level = level)
}
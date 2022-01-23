package com.github.sinhasamarth.quizguru.api

import com.github.sinhasamarth.quizguru.model.CategoryModel
import retrofit2.http.GET

interface AllApiRequest {

    @GET("/api_category.php")
    suspend fun getAllCategory(): CategoryModel
}
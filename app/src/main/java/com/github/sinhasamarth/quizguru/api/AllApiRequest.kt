package com.github.sinhasamarth.quizguru.api

import com.github.sinhasamarth.quizguru.model.CategoryModel
import com.github.sinhasamarth.quizguru.model.QuestionModel
import retrofit2.http.GET
import retrofit2.http.Query

interface AllApiRequest {

    @GET("/api_category.php")
    suspend fun getAllCategory(): CategoryModel

    @GET("/api.php")
    suspend fun getAllQuestion(
        @Query("amount") amount: Int = 10,
        @Query("category") catId:Int ,
        @Query("difficulty") level:String = "easy",
        @Query("type") type:String = "multiple"
    ): QuestionModel


}
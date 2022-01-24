package com.github.sinhasamarth.quizguru.model

data class QuestionModel(
    val response_code: Int,
    val results: List<Result>
)
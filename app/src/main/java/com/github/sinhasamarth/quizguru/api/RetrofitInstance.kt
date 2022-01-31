package com.github.sinhasamarth.quizguru.api

import com.github.sinhasamarth.quizguru.utils.Utils
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
     val myApi = Retrofit.Builder()
        .baseUrl(Utils.HOST_URL)
        .addConverterFactory(
            GsonConverterFactory.create()
        ).build().create(AllApiRequest::class.java)
}
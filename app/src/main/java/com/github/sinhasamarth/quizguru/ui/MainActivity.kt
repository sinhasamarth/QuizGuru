package com.github.sinhasamarth.quizguru.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.sinhasamarth.quizguru.R
import com.github.sinhasamarth.quizguru.api.RetrofitInstance
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        getApi()
    }

//    private fun getApi() {
//        GlobalScope.launch {
//            val response = RetrofitInstance.myApi.getAllCategory()
//            Log.d(
//                "RESPONSE", response.toString()
//            )
//        }

}

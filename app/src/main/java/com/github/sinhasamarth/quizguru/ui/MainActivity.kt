package com.github.sinhasamarth.quizguru.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import com.github.sinhasamarth.quizguru.R
import com.github.sinhasamarth.quizguru.api.RetrofitInstance
import com.github.sinhasamarth.quizguru.di.main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        startKoin {
            androidContext(
                this@MainActivity
            )
            modules(
                listOf(
                    main
                )
            )
        }
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

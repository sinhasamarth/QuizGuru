package com.github.sinhasamarth.quizguru.utils

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.github.sinhasamarth.quizguru.viewModel.MainViewModel

class Utils {
    companion object {
        const val HOST_URL = "https://opentdb.com/"
        fun getViewModel(context: ViewModelStoreOwner): MainViewModel {
            return ViewModelProvider(context)[MainViewModel::class.java]
        }
    }
}
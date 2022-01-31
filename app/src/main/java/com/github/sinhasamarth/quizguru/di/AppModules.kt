package com.github.sinhasamarth.quizguru.di

import com.github.sinhasamarth.quizguru.api.RetrofitInstance
import com.github.sinhasamarth.quizguru.repository.Repository
import com.github.sinhasamarth.quizguru.viewModel.MainViewModel
import org.koin.dsl.module

val main = module {
    single { Repository(get()) }
    single { MainViewModel(get()) }
    single { RetrofitInstance() }
}

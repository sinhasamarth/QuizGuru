package com.github.sinhasamarth.quizguru.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.github.sinhasamarth.quizguru.R
import com.github.sinhasamarth.quizguru.utils.Utils
import com.github.sinhasamarth.quizguru.viewModel.MainViewModel
import org.koin.android.ext.android.get

class SplashScreen : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedViewModel = get<MainViewModel>()
        sharedViewModel.allCategoryList.observe(viewLifecycleOwner) {
            if (it != null) {
                findNavController().navigate(R.id.action_splashScreen_to_categoriesFragment)
            }
        }
        sharedViewModel.getAllCategory()
    }
}
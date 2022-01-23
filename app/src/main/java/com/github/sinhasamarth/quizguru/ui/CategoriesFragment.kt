package com.github.sinhasamarth.quizguru.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.*
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.sinhasamarth.quizguru.Adapters.CategoriesAdapter
import com.github.sinhasamarth.quizguru.R
import com.github.sinhasamarth.quizguru.databinding.FragmentCategoriesBinding
import com.github.sinhasamarth.quizguru.listners.RecyclerViewListener
import com.github.sinhasamarth.quizguru.viewModel.MainViewModel

class CategoriesFragment : Fragment(), RecyclerViewListener {
    private lateinit var binding: FragmentCategoriesBinding
    private val sharedViewModel: MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoriesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecylerView()

    }


    private fun setRecylerView() {
        binding.recylerViewCat.layoutManager = LinearLayoutManager(requireContext())
        Log.d("HII", sharedViewModel.allCategoryList.value.toString())
        binding.recylerViewCat.adapter = sharedViewModel.allCategoryList.value?.let {
            CategoriesAdapter(it, this)
        }
        sharedViewModel.allCategoryList.observe(viewLifecycleOwner, {
            binding.recylerViewCat.adapter = CategoriesAdapter(it!!, this)
        })

    }

    override fun onClickItem(position: Int) {
        sharedViewModel.setSelectedCat(position)
        findNavController().navigate(R.id.action_categoriesFragment_to_selectLevelFragment)
    }
}
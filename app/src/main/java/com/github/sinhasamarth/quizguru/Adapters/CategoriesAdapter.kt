package com.github.sinhasamarth.quizguru.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.sinhasamarth.quizguru.R
import com.github.sinhasamarth.quizguru.listners.RecyclerViewListener
import com.github.sinhasamarth.quizguru.model.CategoryModel
import com.github.sinhasamarth.quizguru.model.TriviaCategory

class CategoriesAdapter(val data: CategoryModel , val listner: RecyclerViewListener ) :
    RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text = itemView.findViewById<TextView>(R.id.categoryName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            LayoutInflater
                .from(
                    parent.context
                ).inflate(
                    R.layout.catrgories_list_ui_ele,
                    parent, false
                )
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.text.text = data.trivia_categories[position].name
        holder.itemView.setOnClickListener { listner.onClickItem(position) }

    }

    override fun getItemCount() = data.trivia_categories.size
}
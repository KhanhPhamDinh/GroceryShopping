package com.example.groceryshopping.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.groceryshopping.R
import com.example.groceryshopping.data.models.SearchData

class SearchAdapter: RecyclerView.Adapter<SearchAdapter.ViewHolder>(){
    var data = listOf<SearchData>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: SearchAdapter.ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: SearchData) {
        }


        companion object {
            fun from(parent: ViewGroup): SearchAdapter.ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.custom_view_search, parent, false)
                return ViewHolder(view)
            }
        }
    }
}
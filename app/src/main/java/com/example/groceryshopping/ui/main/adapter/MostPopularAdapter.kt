package com.example.groceryshopping.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.groceryshopping.R
import com.example.groceryshopping.data.models.Movies


class MostPopularAdapter: RecyclerView.Adapter<MostPopularAdapter.ViewHolder>() {
    var data = listOf<Movies>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val lblTitleFilm: TextView = itemView.findViewById(R.id.lblTitleFilm)
        private val lblRating: TextView = itemView.findViewById(R.id.lblRating)
        private val imageFilm: ImageView = itemView.findViewById(R.id.imageFilm)
        private val imageBookmark: ImageView = itemView.findViewById(R.id.imageBoomark)
        private val ratingBar: RatingBar = itemView.findViewById(R.id.ratingBar)


        fun bind(item: Movies) {
            lblTitleFilm.text = item.fullTitle
            if(!item.imDbRating.isEmpty()) {
                lblRating.text = (item.imDbRating.toFloat() / 2).toString()
                ratingBar.rating = Math.round(item.imDbRating.toFloat()/2).toFloat()
            }else{
                lblRating.text = "0"
                ratingBar.rating = 0.toFloat()
            }
            val options: RequestOptions = RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)
            Glide.with(itemView).load(item.image).apply(options).into(imageFilm)
            imageBookmark.setImageResource(R.drawable.ic_bookmark_default)

        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.custom_view_polular_movies, parent, false)

                return ViewHolder(view)
            }
        }
    }
}


class MostPopularMoviesDiffCallback : DiffUtil.ItemCallback<Movies>() {
    override fun areItemsTheSame(oldItem: Movies, newItem: Movies): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movies, newItem: Movies): Boolean {
        return oldItem == newItem
    }
}


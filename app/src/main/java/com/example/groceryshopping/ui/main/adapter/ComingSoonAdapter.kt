package com.example.groceryshopping.ui.main.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.example.groceryshopping.R
import com.example.groceryshopping.data.models.ComingSoonMovies
import com.example.groceryshopping.data.models.Movie
import com.example.groceryshopping.data.models.MovieComing

class ComingSoonAdapter: RecyclerView.Adapter<ComingSoonAdapter.ViewHolder>() {
    var data = listOf<MovieComing>()
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
        private val lblTitleFilm: TextView = itemView.findViewById(R.id.coming_lbl_title_film)
        private val lblRating: TextView = itemView.findViewById(R.id.coming_lbl_rating)
        private val imageFilm: ImageView = itemView.findViewById(R.id.coming_poster_film)
        private val ratingBar: RatingBar = itemView.findViewById(R.id.coming_ratingBar)
        private val lblGenres: TextView = itemView.findViewById(R.id.coming_lbl_genres)
        private val lblPlot: TextView = itemView.findViewById(R.id.coming_lbl_plot)
        private val progressBar : ProgressBar = itemView.findViewById(R.id.coming_progressbar)
//
        fun bind(item: MovieComing) {
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
                .error(R.mipmap.ic_launcher_round)
            Glide.with(itemView).load(item.image).listener(object : RequestListener<Drawable>{
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    progressBar.setVisibility(View.GONE);
                    return false;
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    progressBar.setVisibility(View.GONE);
                    return false;
                }
            }).apply(options).into(imageFilm)
            lblGenres.text = item.genres
            lblPlot.text = item.plot
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.custom_view_coming_soon_movies, parent, false)

                return ViewHolder(view)
            }
        }
    }
}


class ComingSoonMoviesDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}

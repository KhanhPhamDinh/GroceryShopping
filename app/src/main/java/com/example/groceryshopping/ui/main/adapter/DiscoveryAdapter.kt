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
import com.example.groceryshopping.data.models.*

class DiscoveryAdapter: RecyclerView.Adapter<DiscoveryAdapter.ViewHolder>(){
    var typeAdapter : String = "BOXOFFICE"

    var dataBoxOffice = listOf<MovieOffice>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var dataMostPopular = listOf<Movie>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var dataComingSoon = listOf<MovieComing>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int {
        if(typeAdapter == "COMINGSOON") {
            return dataComingSoon.size
        }else if(typeAdapter == "MOSTPOPULAR"){
            return dataMostPopular.size
        }
        return dataBoxOffice.size
    }

    override fun onBindViewHolder(holder: DiscoveryAdapter.ViewHolder, position: Int) {
        if(typeAdapter == "COMINGSOON") {
            val item = dataComingSoon[position]
            holder.bindComingSoon(item)
        }
        else if(typeAdapter == "MOSTPOPULAR") {
            val item = dataMostPopular[position]
            holder.bindMostPopular(item)
        }else{
            val item = dataBoxOffice[position]
            holder.bindBoxOffice(item)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DiscoveryAdapter.ViewHolder {
        return DiscoveryAdapter.ViewHolder.from(parent)
    }


    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val lblTitleFilm: TextView = itemView.findViewById(R.id.discovery_lbl_title)
        private val lblRating: TextView = itemView.findViewById(R.id.discovery_lbl_rating)
        private val imageFilm: ImageView = itemView.findViewById(R.id.discovery_img_poster)
        private val ratingBar: RatingBar = itemView.findViewById(R.id.discovery_rating)
        private val progressBar: ProgressBar = itemView.findViewById(R.id.discovery_progressbar)

        fun bindComingSoon(item: MovieComing) {
            lblTitleFilm.text = item.fullTitle
            if(!item.imDbRating.equals("N/A") && !item.imDbRating.equals("")) {
                lblRating.text = (item.imDbRating.toFloat() / 2).toString()
                ratingBar.rating = Math.round(item.imDbRating.toFloat()/2).toFloat()
            }else{
                lblRating.text = "N/A"
                ratingBar.rating = 0.toFloat()
            }
            val options: RequestOptions = RequestOptions()
                .centerCrop()
                .error(R.mipmap.ic_launcher_round)
            Glide.with(itemView).load(item.image).listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    progressBar.setVisibility(View.GONE)
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    progressBar.setVisibility(View.GONE)
                    return false
                }
            }).apply(options).into(imageFilm)
        }

        fun bindMostPopular(item: Movie) {
            lblTitleFilm.text = item.fullTitle
            if(!item.imDbRating.equals("N/A") && !item.imDbRating.equals("")) {
                lblRating.text = (item.imDbRating.toFloat() / 2).toString()
                ratingBar.rating = Math.round(item.imDbRating.toFloat()/2).toFloat()
            }else{
                lblRating.text = "N/A"
                ratingBar.rating = 0.toFloat()
            }
            val options: RequestOptions = RequestOptions()
                .centerCrop()
                .error(R.mipmap.ic_launcher_round)
            Glide.with(itemView).load(item.image).listener(object : RequestListener<Drawable>{
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    progressBar.setVisibility(View.GONE)
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    progressBar.setVisibility(View.GONE)
                    return false
                }
            }).apply(options).into(imageFilm)
        }

        fun bindBoxOffice(item: MovieOffice) {
            lblTitleFilm.text = item.title
            lblRating.text = "N/A"
            ratingBar.rating = 0.toFloat()
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
                    progressBar.setVisibility(View.GONE)
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    progressBar.setVisibility(View.GONE)
                    return false
                }

            }).apply(options).into(imageFilm)
        }

        companion object {
            fun from(parent: ViewGroup): DiscoveryAdapter.ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.custome_view_discovery_movie, parent, false)
                return DiscoveryAdapter.ViewHolder(view)
            }
        }

    }
}

class MostDiscoveryDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}
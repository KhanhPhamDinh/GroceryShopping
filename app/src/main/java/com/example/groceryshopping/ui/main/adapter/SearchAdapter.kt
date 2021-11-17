package com.example.groceryshopping.ui.main.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
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
        private val lblId: TextView = itemView.findViewById(R.id.search_txt_id)
        private val lblResultType: TextView = itemView.findViewById(R.id.search_txt_result_type)
        private val image: ImageView = itemView.findViewById(R.id.search_img_result)
        private val lblTitle: TextView = itemView.findViewById(R.id.search_title)
        private val lblDescription: TextView = itemView.findViewById(R.id.search_description)
        private val progressBar: ProgressBar = itemView.findViewById(R.id.search_progressbar)

        fun bind(item: SearchData) {
            lblId.text = "Id: " + item.id
            lblResultType.text = "Result type: " + item.resultType
            lblTitle.text = "Title: " + item.title
            lblDescription.text = "Description: " + item.description
            progressBar.visibility = View.VISIBLE
            val options: RequestOptions = RequestOptions()
                .centerCrop()
                .error(R.mipmap.ic_launcher_round)

            Glide.with(itemView).load(item.image).listener(object: RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    progressBar.visibility = View.GONE
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    progressBar.visibility = View.GONE;
                    return false
                }
            }).apply(options).into(image)
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
package com.iosockettest.tereshkov.lunchdottest.presentation.restaurants

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.iosockettest.tereshkov.lunchdottest.R
import com.iosockettest.tereshkov.lunchdottest.data.Restaurant


class RestaurantsAdapter : RecyclerView.Adapter<RestaurantsAdapter.ViewHolder>() {

    private val dataList = mutableListOf<Restaurant>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_restaurant))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

    fun setData(data: List<Restaurant>) {
        dataList.clear()
        dataList.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var imageView = itemView.findViewById(R.id.imageView) as ImageView
        private var averageCheckTextView = itemView.findViewById(R.id.averageCheckTextView) as TextView
        private var cuisineTextView = itemView.findViewById(R.id.cuisineTextView) as TextView
        private var titleTextView = itemView.findViewById(R.id.titleTextView) as TextView

        fun bind(data: Restaurant) {
            Glide.with(imageView.context)
                    .load("$IMAGE_URL${data.imageId}")
                    .animate(android.R.anim.fade_in)
                    .into(imageView)

            averageCheckTextView.text = "${data.averageCheck} Р"
            cuisineTextView.text = "Кухня: ${data.cuisine}"
            titleTextView.text = data.title
        }
    }

    companion object {
        const val IMAGE_URL = "http://test.lunchdot.com/api/file/"
    }
}

fun ViewGroup.inflate(layoutId: Int): View {
    return LayoutInflater.from(context).inflate(layoutId, this, false)
}
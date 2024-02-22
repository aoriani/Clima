package com.io.clima.ui.master

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.io.clima.R
import com.io.clima.network.Weather

object WeatherDiffCallback : DiffUtil.ItemCallback<Weather>() {
    override fun areItemsTheSame(oldItem: Weather, newItem: Weather): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Weather, newItem: Weather): Boolean =
        oldItem == newItem
}

class WeatherListAdapter(private val clickListener: (Weather) -> Unit) :
    ListAdapter<Weather, WeatherListAdapter.WeatherViewHolder>(WeatherDiffCallback) {

    class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.list_item, parent, false)
        return WeatherViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {

    }
}
package com.example.viewpager2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view_pager.view.*

class ViewPagerAdapter(val images: List<Int>): RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHOlder>() {


    inner class ViewPagerViewHOlder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHOlder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager, parent, false)
        return ViewPagerViewHOlder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHOlder, position: Int) {
        val curImage = images[position]
        holder.itemView.weather_view_pager.setBackgroundResource(curImage)
    }

    override fun getItemCount(): Int {
        return images.size
    }
}
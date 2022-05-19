package com.example.viewpager2

import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class CityAdapter  : RecyclerView.Adapter<CityAdapter.CityViewHolder>() {


    private var cityList: ArrayList<City> = ArrayList()
    private var onClickItem: ((City) -> Unit)? = null
    private var onClickDeleteItem: ((City) -> Unit)? = null

    fun addItems(items: ArrayList<City>) {
//        this.cityList = items
//        notifyDataSetChanged()

        cityList.clear();
        cityList.addAll(items);
        this.notifyDataSetChanged();
    }

    fun setOnClickItem(callback: (City) -> Unit) {
        this.onClickItem = callback
    }

    fun setOnClickDeleteitem(callback: (City) -> Unit) {
        this.onClickDeleteItem = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CityViewHolder(inflater.inflate(R.layout.card_items_city, parent, false))

    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val user = cityList[position]
        holder.bindView(user)
        holder.itemView.setOnClickListener { onClickItem?.invoke(user) }
        holder.btnDelete.setOnClickListener { onClickDeleteItem?.invoke(user) }
    }

    override fun getItemCount(): Int {
        return cityList.size
    }

    class CityViewHolder(var view: View) : RecyclerView.ViewHolder(view) {


        private var name = view.findViewById<TextView>(R.id.tv_city_name)

        var btnDelete = view.findViewById<ImageButton>(R.id.btn_delete)

        fun bindView(city: City) {

            name.text = city.name

        }
    }
}
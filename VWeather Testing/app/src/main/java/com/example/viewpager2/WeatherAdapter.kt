package com.example.viewpager2

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_view_pager.view.*


class WeatherAdapter(var weatherList: ArrayList<Weather>, context: Context) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>(){
    var context: Context = context
    inner class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private var cityName = itemView.findViewById<TextView>(R.id.city_name_text)
        private var weatherViewPager = itemView.findViewById<ConstraintLayout>(R.id.weather_view_pager)

        fun bindView(weather: Weather) {

            cityName.text = weather.cityName




        }
    }
    fun addItems(items: ArrayList<Weather>) {
        this.weatherList = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_view_pager,
            parent,
            false
        )
        return WeatherViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val weather = weatherList[position]

        if(weatherList.size<1){
            holder.itemView.drawer_layout.setBackgroundResource(R.drawable.somewhere)
        }

        //holder.itemView.main_image.setBackgroundResource(curImage)
       else{
            holder.itemView.city_name_text.text = weather.cityName
            holder.itemView.temp.text = weather.temp
            holder.itemView.date_time.text = weather.dateTime
            holder.itemView.weather.text = weather.weathermain
            holder.itemView.time_hourly2.text = weather.time2
            holder.itemView.time_hourly3.text = weather.time3
            holder.itemView.time_hourly4.text = weather.time4
            holder.itemView.time_hourly5.text = weather.time5
            holder.itemView.time_hourly6.text = weather.time6
            holder.itemView.time_hourly7.text = weather.time7
            holder.itemView.time_hourly8.text = weather.time8
            holder.itemView.time_hourly9.text = weather.time9
            holder.itemView.time_hourly10.text = weather.time10
            holder.itemView.time_hourly11.text = weather.time11
            holder.itemView.time_hourly12.text = weather.time12
            holder.itemView.time_hourly13.text = weather.time13
            holder.itemView.time_hourly14.text = weather.time14
            holder.itemView.time_hourly15.text = weather.time15
            holder.itemView.time_hourly16.text = weather.time16
            holder.itemView.time_hourly17.text = weather.time17
            holder.itemView.time_hourly18.text = weather.time18
            holder.itemView.temp_hourly2.text = weather.temp2
            holder.itemView.temp_hourly3.text = weather.temp3
            holder.itemView.temp_hourly4.text = weather.temp4
            holder.itemView.temp_hourly5.text = weather.temp5
            holder.itemView.temp_hourly6.text = weather.temp6
            holder.itemView.temp_hourly7.text = weather.temp7
            holder.itemView.temp_hourly8.text = weather.temp8
            holder.itemView.temp_hourly9.text = weather.temp9
            holder.itemView.temp_hourly10.text = weather.temp10
            holder.itemView.temp_hourly11.text = weather.temp11
            holder.itemView.temp_hourly12.text = weather.temp12
            holder.itemView.temp_hourly13.text = weather.temp13
            holder.itemView.temp_hourly14.text = weather.temp14
            holder.itemView.temp_hourly15.text = weather.temp15
            holder.itemView.temp_hourly16.text = weather.temp16
            holder.itemView.temp_hourly17.text = weather.temp17
            holder.itemView.temp_hourly18.text = weather.temp18

//            val icon = BitmapFactory.decodeResource(
//                context.resources,
//                R.drawable.2643743
//            )


//            val filePath: String = "drawable://2643743.png"
//            val bitmap = BitmapFactory.decodeFile(filePath)
//            holder.itemView.main_weather_image!!.setImageBitmap(bitmap)




            try {
                val name = "i"+weather.image
                val id: Int =   context.resources.getIdentifier(name, "drawable", context.getPackageName())
                var drawable  = context.resources.getDrawable(id)
                holder.itemView.weather_view_pager.setBackground(drawable)
            }catch (e : Exception){

                holder.itemView.weather_view_pager.setBackgroundResource(R.drawable.somewhere)
            }



        }

    }



    override fun getItemCount(): Int {
        return weatherList.size
    }


}
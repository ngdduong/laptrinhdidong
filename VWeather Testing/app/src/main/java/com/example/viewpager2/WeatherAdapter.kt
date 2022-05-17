package com.example.viewpager2

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.github.ahmadnemati.wind.enums.TrendType
import com.github.matteobattilana.weather.PrecipType
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_view_pager.view.*
import java.text.DecimalFormat
import java.util.*


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
            holder.itemView.temp_hourly1.text = weather.temp
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
            holder.itemView.today_temp_max.text = "▲"+weather.maxTempToday
            holder.itemView.today_temp_min.text = "▼"+weather.minTempToday

            val font = Typeface.createFromAsset(context.assets, "weathericons-regular-webfont.ttf")
            holder.itemView.main_weather_icon.setTypeface(font)
            val main_weather_icon: String =holder.itemView.context.getString(getIcon(weather.icon))
            holder.itemView.main_weather_icon.text = main_weather_icon

            holder.itemView.sunrise_sunset.setTypeface(font)
            val sunrise_icon = holder.itemView.context.getString(R.string.wi_sunrise)
            val sunset_icon = holder.itemView.context.getString(R.string.wi_sunset)
            holder.itemView.sunrise_sunset.text = sunrise_icon+weather.sunrise + "   "+sunset_icon+ weather.sunset


            holder.itemView.rain_hourly1.setTypeface(font)
            holder.itemView.rain_hourly2.setTypeface(font)
            holder.itemView.rain_hourly3.setTypeface(font)
            holder.itemView.rain_hourly4.setTypeface(font)
            holder.itemView.rain_hourly5.setTypeface(font)
            holder.itemView.rain_hourly6.setTypeface(font)
            holder.itemView.rain_hourly7.setTypeface(font)
            holder.itemView.rain_hourly8.setTypeface(font)
            holder.itemView.rain_hourly9.setTypeface(font)
            holder.itemView.rain_hourly10.setTypeface(font)
            holder.itemView.rain_hourly11.setTypeface(font)
            holder.itemView.rain_hourly12.setTypeface(font)
            holder.itemView.rain_hourly13.setTypeface(font)
            holder.itemView.rain_hourly14.setTypeface(font)
            holder.itemView.rain_hourly15.setTypeface(font)
            holder.itemView.rain_hourly16.setTypeface(font)
            holder.itemView.rain_hourly17.setTypeface(font)
            holder.itemView.rain_hourly18.setTypeface(font)

            val rain_hourly_icon = holder.itemView.context.getString(R.string.wi_raindrop)

            holder.itemView.rain_hourly1.text = weather.pop1+ "%"+rain_hourly_icon
            holder.itemView.rain_hourly2.text = weather.pop2+ "%"+rain_hourly_icon
            holder.itemView.rain_hourly3.text = weather.pop3+"%"+ rain_hourly_icon
            holder.itemView.rain_hourly4.text = weather.pop4+ "%"+rain_hourly_icon
            holder.itemView.rain_hourly5.text   = weather.pop5+"%"+ rain_hourly_icon
            holder.itemView.rain_hourly6.text= weather.pop6+ "%"+rain_hourly_icon
            holder.itemView.rain_hourly7.text= weather.pop7+"%"+ rain_hourly_icon
            holder.itemView.rain_hourly8.text= weather.pop8+ "%"+rain_hourly_icon
            holder.itemView.rain_hourly9.text= weather.pop9+ "%"+rain_hourly_icon
            holder.itemView.rain_hourly10.text= weather.pop10+"%"+ rain_hourly_icon
            holder.itemView.rain_hourly11.text= weather.pop11+"%"+ rain_hourly_icon
            holder.itemView.rain_hourly12.text= weather.pop12+"%"+ rain_hourly_icon
            holder.itemView.rain_hourly13.text= weather.pop13+"%"+ rain_hourly_icon
            holder.itemView.rain_hourly14.text= weather.pop14+ "%"+rain_hourly_icon
            holder.itemView.rain_hourly15.text= weather.pop15+"%"+ rain_hourly_icon
            holder.itemView.rain_hourly16.text= weather.pop16+ "%"+rain_hourly_icon
            holder.itemView.rain_hourly17.text= weather.pop17+ "%"+rain_hourly_icon
            holder.itemView.rain_hourly18.text= weather.pop18+"%"+ rain_hourly_icon




            holder.itemView.icon_hourly1.setTypeface(font)
            holder.itemView.icon_hourly2.setTypeface(font)
            holder.itemView.icon_hourly3.setTypeface(font)
            holder.itemView.icon_hourly4.setTypeface(font)
            holder.itemView.icon_hourly5.setTypeface(font)
            holder.itemView.icon_hourly6.setTypeface(font)
            holder.itemView.icon_hourly7.setTypeface(font)
            holder.itemView.icon_hourly8.setTypeface(font)
            holder.itemView.icon_hourly9.setTypeface(font)
            holder.itemView.icon_hourly10.setTypeface(font)
            holder.itemView.icon_hourly11.setTypeface(font)
            holder.itemView.icon_hourly12.setTypeface(font)
            holder.itemView.icon_hourly13.setTypeface(font)
            holder.itemView.icon_hourly14.setTypeface(font)
            holder.itemView.icon_hourly15.setTypeface(font)
            holder.itemView.icon_hourly16.setTypeface(font)
            holder.itemView.icon_hourly17.setTypeface(font)
            holder.itemView.icon_hourly18.setTypeface(font)


            val icon_hourly1 = holder.itemView.context.getString(getIcon(weather.icon))
            val icon_hourly2 = holder.itemView.context.getString(getIcon(weather.icon2))
            val icon_hourly3 = holder.itemView.context.getString(getIcon(weather.icon3))
            val icon_hourly4 = holder.itemView.context.getString(getIcon(weather.icon4))
            val icon_hourly5 = holder.itemView.context.getString(getIcon(weather.icon5))
            val icon_hourly6 = holder.itemView.context.getString(getIcon(weather.icon6))
            val icon_hourly7 = holder.itemView.context.getString(getIcon(weather.icon7))
            val icon_hourly8 = holder.itemView.context.getString(getIcon(weather.icon8))
            val icon_hourly9 = holder.itemView.context.getString(getIcon(weather.icon9))
            val icon_hourly10 = holder.itemView.context.getString(getIcon(weather.icon10))
            val icon_hourly11 = holder.itemView.context.getString(getIcon(weather.icon11))
            val icon_hourly12 = holder.itemView.context.getString(getIcon(weather.icon12))
            val icon_hourly13 = holder.itemView.context.getString(getIcon(weather.icon13))
            val icon_hourly14 = holder.itemView.context.getString(getIcon(weather.icon14))
            val icon_hourly15 = holder.itemView.context.getString(getIcon(weather.icon15))
            val icon_hourly16 = holder.itemView.context.getString(getIcon(weather.icon16))
            val icon_hourly17 = holder.itemView.context.getString(getIcon(weather.icon17))
            val icon_hourly18 = holder.itemView.context.getString(getIcon(weather.icon18))

            holder.itemView.icon_hourly1.text = icon_hourly1
            holder.itemView.icon_hourly2.text = icon_hourly2
            holder.itemView.icon_hourly3.text = icon_hourly3
            holder.itemView.icon_hourly4.text = icon_hourly4
            holder.itemView.icon_hourly5.text = icon_hourly5
            holder.itemView.icon_hourly6.text = icon_hourly6
            holder.itemView.icon_hourly7.text = icon_hourly7
            holder.itemView.icon_hourly8.text = icon_hourly8
            holder.itemView.icon_hourly9.text = icon_hourly9
            holder.itemView.icon_hourly10.text = icon_hourly10
            holder.itemView.icon_hourly11.text = icon_hourly11
            holder.itemView.icon_hourly12.text = icon_hourly12
            holder.itemView.icon_hourly13.text = icon_hourly13
            holder.itemView.icon_hourly14.text = icon_hourly14
            holder.itemView.icon_hourly15.text = icon_hourly15
            holder.itemView.icon_hourly16.text = icon_hourly16
            holder.itemView.icon_hourly17.text = icon_hourly17
            holder.itemView.icon_hourly18.text = icon_hourly18



            holder.itemView.daily_pop1.setTypeface(font)
            holder.itemView.daily_pop2.setTypeface(font)
            holder.itemView.daily_pop3.setTypeface(font)
            holder.itemView.daily_pop4.setTypeface(font)
            holder.itemView.daily_pop5.setTypeface(font)
            holder.itemView.daily_pop6.setTypeface(font)
            holder.itemView.daily_pop7.setTypeface(font)
            holder.itemView.daily_pop8.setTypeface(font)

            holder.itemView.daily_icon1.setTypeface(font)
            holder.itemView.daily_icon2.setTypeface(font)
            holder.itemView.daily_icon3.setTypeface(font)
            holder.itemView.daily_icon4.setTypeface(font)
            holder.itemView.daily_icon5.setTypeface(font)
            holder.itemView.daily_icon6.setTypeface(font)
            holder.itemView.daily_icon7.setTypeface(font)
            holder.itemView.daily_icon8.setTypeface(font)


            holder.itemView.daily_day1.text = weather.daily_day1
            holder.itemView.daily_day2.text = weather.daily_day2
            holder.itemView.daily_day3.text = weather.daily_day3
            holder.itemView.daily_day4.text = weather.daily_day4
            holder.itemView.daily_day5.text = weather.daily_day5
            holder.itemView.daily_day6.text = weather.daily_day6
            holder.itemView.daily_day7.text = weather.daily_day7
            holder.itemView.daily_day8.text = weather.daily_day8

            holder.itemView.daily_pop1.text = weather.daily_pop1+"%"+rain_hourly_icon
            holder.itemView.daily_pop2.text = weather.daily_pop2+"%"+rain_hourly_icon
            holder.itemView.daily_pop3.text = weather.daily_pop3+"%"+rain_hourly_icon
            holder.itemView.daily_pop4.text = weather.daily_pop4+"%"+rain_hourly_icon
            holder.itemView.daily_pop5.text = weather.daily_pop5+"%"+rain_hourly_icon
            holder.itemView.daily_pop6.text = weather.daily_pop6+"%"+rain_hourly_icon
            holder.itemView.daily_pop7.text = weather.daily_pop7+"%"+rain_hourly_icon
            holder.itemView.daily_pop8.text = weather.daily_pop8+"%"+rain_hourly_icon

            holder.itemView.daily_min_max1.text = "▼"+weather.daily_mintemp1+"  "+"▲"+weather.daily_maxtemp1
            holder.itemView.daily_min_max2.text = "▼"+weather.daily_mintemp2+"  "+"▲"+weather.daily_maxtemp2
            holder.itemView.daily_min_max3.text = "▼"+weather.daily_mintemp3+"  "+"▲"+weather.daily_maxtemp3
            holder.itemView.daily_min_max4.text = "▼"+weather.daily_mintemp4+"  "+"▲"+weather.daily_maxtemp4
            holder.itemView.daily_min_max5.text = "▼"+weather.daily_mintemp5+"  "+"▲"+weather.daily_maxtemp5
            holder.itemView.daily_min_max6.text = "▼"+weather.daily_mintemp6+"  "+"▲"+weather.daily_maxtemp6
            holder.itemView.daily_min_max7.text = "▼"+weather.daily_mintemp7+"  "+"▲"+weather.daily_maxtemp7
            holder.itemView.daily_min_max8.text = "▼"+weather.daily_mintemp8+"  "+"▲"+weather.daily_maxtemp8

            holder.itemView.daily_icon1.text = holder.itemView.context.getString(getIcon(weather.daily_icon1))
            holder.itemView.daily_icon2.text = holder.itemView.context.getString(getIcon(weather.daily_icon2))
            holder.itemView.daily_icon3.text = holder.itemView.context.getString(getIcon(weather.daily_icon3))
            holder.itemView.daily_icon4.text = holder.itemView.context.getString(getIcon(weather.daily_icon4))
            holder.itemView.daily_icon5.text = holder.itemView.context.getString(getIcon(weather.daily_icon5))
            holder.itemView.daily_icon6.text = holder.itemView.context.getString(getIcon(weather.daily_icon6))
            holder.itemView.daily_icon7.text = holder.itemView.context.getString(getIcon(weather.daily_icon7))
            holder.itemView.daily_icon8.text = holder.itemView.context.getString(getIcon(weather.daily_icon8))

            if(weather.alerts_description!=""){
                holder.itemView.alerts.setContentText(weather.alerts_description)

            }
            holder.itemView.alerts.setTitleText("Alerts: " + weather.alerts)

            holder.itemView.sunView.setTimeTextColor(context.resources.getColor((R.color.timetextcolor)))
            holder.itemView.sunView.setSunColor(context.resources.getColor(R.color.suncolor))
            holder.itemView.sunView.setArcSolidColor(context.resources.getColor(R.color.clear))



            holder.itemView.windview.barometerColor = context.resources.getColor(R.color.clear)
            holder.itemView.windview.lineColor = context.resources.getColor(R.color.clear)




                holder.itemView.sunView.setStartTime(weather.sunrise)
                holder.itemView.sunView.setEndTime(weather.sunset)
                holder.itemView.sunView.setCurrentTime(weather.currentTime)

            val df = DecimalFormat("#.##",)
            var windspeed = df.format(weather.wind_speed.toDouble()*3.6)
            var wind_speed = windspeed.toString().replace(",", ".")
            //holder.itemView.windview.setPressure(20F)
            //holder.itemView.windview.setPressureUnit("in hPa")
            holder.itemView.windview.barometerText = ""
            holder.itemView.windview.setWindSpeed(wind_speed.toFloat())
            holder.itemView.windview.setWindSpeedUnit(
                "km/h " + convertDegreeToCardinalDirection(
                    weather.wind_deg.toInt()
                )
            )
            holder.itemView.windview.setTrendType(TrendType.NONE)
            holder.itemView.windview.start()

            holder.itemView.humidity_title.setTypeface(font)
            holder.itemView.humidity_title.text = context.resources.getString(R.string.wi_raindrop)+" Humidity"
            holder.itemView.humidity.setTypeface(font)
            holder.itemView.humidity.text = weather.humidity+context.resources.getString(R.string.wi_humidity)

            holder.itemView.pressure_title.setTypeface(font)
            holder.itemView.pressure_title.text = context.resources.getString(R.string.wi_barometer)+" Pressure"

            holder.itemView.visibility_title.text = context.resources.getString(R.string.fa_eye_solid)+ " Visibility"

            holder.itemView.feels_like_title.setTypeface(font)
            holder.itemView.feels_like_title.text =context.resources.getString(R.string.wi_thermometer)+" Feels like"
            holder.itemView.feels_like.text = weather.feels_like

            if(weather.visibility=="10000"){
                holder.itemView.visibility_content.text = ">"+(weather.visibility.toDouble()/1000).toString()+" km"
            }else{
                holder.itemView.visibility_content.text = (weather.visibility.toDouble()/1000).toString()+" km"
            }

            holder.itemView.pressure.text = weather.pressure
            if(weather.weathermain== "Rain" || weather.weathermain=="Drizzle" || weather.weathermain=="Thunderstorm"){
                holder.itemView.weather_view.setWeatherData(PrecipType.RAIN)
            }
            else if(weather.weathermain == "Snow"){
                holder.itemView.weather_view.setWeatherData(PrecipType.SNOW)
            }



//            val icon = BitmapFactory.decodeResource(
//                context.resources,
//                R.drawable.2643743
//            )


//            val filePath: String = "drawable://2643743.png"
//            val bitmap = BitmapFactory.decodeFile(filePath)
//            holder.itemView.main_weather_image!!.setImageBitmap(bitmap)




            try {
                val name = "i"+weather.image
                val id: Int =   context.resources.getIdentifier(
                    name,
                    "drawable",
                    context.getPackageName()
                )
                var drawable  = context.resources.getDrawable(id)
                holder.itemView.weather_view_pager.setBackground(drawable)
            }catch (e: Exception){

                holder.itemView.weather_view_pager.setBackgroundResource(R.drawable.somewhere)
            }



        }

    }



    override fun getItemCount(): Int {
        return weatherList.size
    }

    fun getIcon(icon: String): Int{
        if(icon == "01d"){
            return R.string.wi_day_sunny
        }
        if(icon == "01n"){
            return R.string.wi_night_clear
        }
        if(icon == "02d"){
            return R.string.wi_day_cloudy
        }
        if(icon == "02n"){
            return R.string.wi_night_cloudy
        }
        if(icon == "03d"){
            return R.string.wi_cloud
        }
        if(icon == "03n"){
            return R.string.wi_cloud
        }

        if(icon == "04d"){
            return R.string.wi_cloudy
        }
        if(icon == "04n"){
            return R.string.wi_cloudy
        }

        if(icon == "09d"){
            return R.string.wi_day_showers
        }
        if(icon == "09n"){
            return R.string.wi_night_showers
        }

        if(icon == "10d"){
            return R.string.wi_day_rain
        }
        if(icon == "10n"){
            return R.string.wi_night_alt_rain
        }

        if(icon == "11d"){
            return R.string.wi_day_thunderstorm
        }
        if(icon == "11n"){
            return R.string.wi_night_thunderstorm
        }

        if(icon == "13d"){
            return R.string.wi_day_snow
        }
        if(icon == "13n"){
            return R.string.wi_night_snow
        }

        if(icon == "50d"){
            return R.string.wi_day_haze
        }
        if(icon == "50n"){
            return R.string.wi_day_haze
        }
        return 0
    }
    fun convertDegreeToCardinalDirection(directionInDegrees: Int): String? {
        var cardinalDirection: String? = null
        cardinalDirection = if (directionInDegrees >= 348.75 && directionInDegrees <= 360 ||
            directionInDegrees >= 0 && directionInDegrees <= 11.25
        ) {
            "N"
        } else if (directionInDegrees >= 11.25 && directionInDegrees <= 33.75) {
            "NNE"
        } else if (directionInDegrees >= 33.75 && directionInDegrees <= 56.25) {
            "NE"
        } else if (directionInDegrees >= 56.25 && directionInDegrees <= 78.75) {
            "ENE"
        } else if (directionInDegrees >= 78.75 && directionInDegrees <= 101.25) {
            "E"
        } else if (directionInDegrees >= 101.25 && directionInDegrees <= 123.75) {
            "ESE"
        } else if (directionInDegrees >= 123.75 && directionInDegrees <= 146.25) {
            "SE"
        } else if (directionInDegrees >= 146.25 && directionInDegrees <= 168.75) {
            "SSE"
        } else if (directionInDegrees >= 168.75 && directionInDegrees <= 191.25) {
            "S"
        } else if (directionInDegrees >= 191.25 && directionInDegrees <= 213.75) {
            "SSW"
        } else if (directionInDegrees >= 213.75 && directionInDegrees <= 236.25) {
            "SW"
        } else if (directionInDegrees >= 236.25 && directionInDegrees <= 258.75) {
            "WSW"
        } else if (directionInDegrees >= 258.75 && directionInDegrees <= 281.25) {
            "W"
        } else if (directionInDegrees >= 281.25 && directionInDegrees <= 303.75) {
            "WNW"
        } else if (directionInDegrees >= 303.75 && directionInDegrees <= 326.25) {
            "NW"
        } else if (directionInDegrees >= 326.25 && directionInDegrees <= 348.75) {
            "NNW"
        } else {
            "?"
        }
        return cardinalDirection
    }

}
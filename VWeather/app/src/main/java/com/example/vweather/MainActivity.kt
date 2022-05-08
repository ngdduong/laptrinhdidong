package com.example.vweather

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import org.json.JSONObject
import java.math.RoundingMode
import java.net.URL
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    var CITY: String = "hoi an"
    val API: String = "929cd208da68cb3e225b988a345d9035"
     var lat: String = ""
    var lon: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        currentweatherTask().execute()
        hourlyweatherTask().execute()


        println("dhwquidcjuzxiczxcwhq")
    }




























    inner class currentweatherTask() : AsyncTask<String, Void, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
            /* Showing the ProgressBar, Making the main design GONE */
        }

        override fun doInBackground(vararg params: String?): String? {
            var response: String?
            try {
                response = URL("https://pro.openweathermap.org/data/2.5/weather?q=$CITY&units=metric&lang=vi&appid=$API").readText(
                    Charsets.UTF_8
                )
            } catch (e: Exception) {
                response = null
            }
            return response
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            try {
                /* Extracting JSON returns from the API */
                val jsonObj = JSONObject(result)

                val main = jsonObj.getJSONObject("main")
                val sys = jsonObj.getJSONObject("sys")
                val wind = jsonObj.getJSONObject("wind")
                val weather = jsonObj.getJSONArray("weather").getJSONObject(0)


                val updatedAt: Long = jsonObj.getLong("dt")
                val updatedAtText = "Updated at: " + SimpleDateFormat("dd/MM/yyyy HH:mm ", Locale.ENGLISH).format(Date(updatedAt * 1000))


                val temp = main.getString("temp")
                val tempMin = "Min Temp: " + main.getString("temp_min") + "°C"
                val tempMax = "Max Temp: " + main.getString("temp_max") + "°C"
                val pressure = main.getString("pressure")
                val humidity = main.getString("humidity")
                val weathermain = weather.getString("main")

                val sunrise: Long = sys.getLong("sunrise")
                val sunset: Long = sys.getLong("sunset")
                val windSpeed = wind.getString("speed")
                val weatherDescription = weather.getString("description")

                val address = jsonObj.getString("name") + ", " + sys.getString("country")

                /* Populating extracted data into our views */
                val df = DecimalFormat("##")
                df.roundingMode = RoundingMode.HALF_UP
                var tempp = temp.toDouble()
                findViewById<TextView>(R.id.temp).text = df.format(tempp) +"°C"
                findViewById<TextView>(R.id.weather).text = weathermain
                findViewById<TextView>(R.id.city_name_text).text = address
                findViewById<TextView>(R.id.date_time).text= updatedAtText
                findViewById<ImageView>(R.id.main_weather_image).setImageResource(R.drawable.clouds)
                /* Views populated, Hiding the loader, Showing the main design */


            } catch (e: Exception) {

                findViewById<TextView>(R.id.temp).visibility = View.VISIBLE
            }

        }
    }










    inner class hourlyweatherTask() : AsyncTask<String, Void, String>() {


        override fun onPreExecute() {
            super.onPreExecute()
            /* Showing the ProgressBar, Making the main design GONE */


        }

        override fun doInBackground(vararg params: String?): String? {



            var response: String?
            try {
                response = URL("https://pro.openweathermap.org/data/2.5/forecast?q=$CITY&units=metric&appid=$API").readText(
                    Charsets.UTF_8
                )
            } catch (e: Exception) {
                response = null
            }
            return response
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            try {
                val jsonObj = JSONObject(result)







                val hourly2 = jsonObj.getJSONArray("list").getJSONObject(2).getJSONObject("main")
                val hourly3 = jsonObj.getJSONArray("list").getJSONObject(3).getJSONObject("main")
                val hourly4 = jsonObj.getJSONArray("list").getJSONObject(4).getJSONObject("main")
                val hourly5 = jsonObj.getJSONArray("list").getJSONObject(5).getJSONObject("main")
                val hourly6 = jsonObj.getJSONArray("list").getJSONObject(6).getJSONObject("main")
                val hourly7 = jsonObj.getJSONArray("list").getJSONObject(7).getJSONObject("main")
                val hourly8 = jsonObj.getJSONArray("list").getJSONObject(8).getJSONObject("main")
                val hourly9 = jsonObj.getJSONArray("list").getJSONObject(9).getJSONObject("main")
                val hourly10 = jsonObj.getJSONArray("list").getJSONObject(10).getJSONObject("main")
                val hourly11 = jsonObj.getJSONArray("list").getJSONObject(11).getJSONObject("main")
                val hourly12 = jsonObj.getJSONArray("list").getJSONObject(12).getJSONObject("main")
                val hourly13= jsonObj.getJSONArray("list").getJSONObject(13).getJSONObject("main")
                val hourly14 = jsonObj.getJSONArray("list").getJSONObject(14).getJSONObject("main")
                val hourly15 = jsonObj.getJSONArray("list").getJSONObject(15).getJSONObject("main")
                val hourly16 = jsonObj.getJSONArray("list").getJSONObject(16).getJSONObject("main")
                val hourly17 = jsonObj.getJSONArray("list").getJSONObject(17).getJSONObject("main")
                val hourly18 = jsonObj.getJSONArray("list").getJSONObject(18).getJSONObject("main")

                /* Extracting JSON returns from the API */





                /* Views populated, Hiding the loader, Showing the main design */

                val temp2   =  hourly2.getString("temp")
                val temp3   =  hourly3.getString("temp")
                val temp4   =  hourly4.getString("temp")
                val temp5   =  hourly5.getString("temp")
                val temp6   =  hourly6.getString("temp")
                val temp7   =  hourly7.getString("temp")
                val temp8   =  hourly8.getString("temp")
                val temp9   =  hourly9.getString("temp")
                val temp10   =  hourly10.getString("temp")
                val temp11   =  hourly11.getString("temp")
                val temp12   =  hourly12.getString("temp")
                val temp13   =  hourly13.getString("temp")
                val temp14   =  hourly14.getString("temp")
                val temp15   =  hourly15.getString("temp")
                val temp16   =  hourly16.getString("temp")
                val temp17   =  hourly17.getString("temp")
                val temp18   =  hourly18.getString("temp")




                val df = DecimalFormat("##")
                df.roundingMode = RoundingMode.HALF_UP



                findViewById<TextView>(R.id.temp_hourly1).text=findViewById<TextView>(R.id.temp).text.toString()
                findViewById<TextView>(R.id.temp_hourly2).text=df.format(temp2.toDouble()) +"°C"
                findViewById<TextView>(R.id.temp_hourly3).text=df.format(temp3.toDouble()) +"°C"
                findViewById<TextView>(R.id.temp_hourly4).text=df.format(temp4.toDouble()) +"°C"
                findViewById<TextView>(R.id.temp_hourly5).text=df.format(temp5.toDouble()) +"°C"
                findViewById<TextView>(R.id.temp_hourly6).text=df.format(temp6.toDouble()) +"°C"
                findViewById<TextView>(R.id.temp_hourly7).text=df.format(temp7.toDouble()) +"°C"
                findViewById<TextView>(R.id.temp_hourly8).text=df.format(temp8.toDouble()) +"°C"
                findViewById<TextView>(R.id.temp_hourly9).text=df.format(temp9.toDouble()) +"°C"
                findViewById<TextView>(R.id.temp_hourly10).text=df.format(temp10.toDouble()) +"°C"
                findViewById<TextView>(R.id.temp_hourly11).text=df.format(temp11.toDouble()) +"°C"
                findViewById<TextView>(R.id.temp_hourly12).text=df.format(temp12.toDouble()) +"°C"
                findViewById<TextView>(R.id.temp_hourly13).text=df.format(temp13.toDouble()) +"°C"
                findViewById<TextView>(R.id.temp_hourly14).text=df.format(temp14.toDouble()) +"°C"
                findViewById<TextView>(R.id.temp_hourly15).text=df.format(temp15.toDouble()) +"°C"
                findViewById<TextView>(R.id.temp_hourly16).text=df.format(temp16.toDouble()) +"°C"
                findViewById<TextView>(R.id.temp_hourly17).text=df.format(temp17.toDouble()) +"°C"
                findViewById<TextView>(R.id.temp_hourly18).text=df.format(temp18.toDouble()) +"°C"







                val time_hourly2  = jsonObj.getJSONArray("list").getJSONObject(2).getString("dt_txt")
                val time_hourly3 = jsonObj.getJSONArray("list").getJSONObject(3).getString("dt_txt")
                val time_hourly4 = jsonObj.getJSONArray("list").getJSONObject(4).getString("dt_txt")
                val time_hourly5 = jsonObj.getJSONArray("list").getJSONObject(5).getString("dt_txt")
                val time_hourly6= jsonObj.getJSONArray("list").getJSONObject(6).getString("dt_txt")
                val time_hourly7 = jsonObj.getJSONArray("list").getJSONObject(7).getString("dt_txt")
                val time_hourly8 = jsonObj.getJSONArray("list").getJSONObject(8).getString("dt_txt")
                val time_hourly9 = jsonObj.getJSONArray("list").getJSONObject(9).getString("dt_txt")
                val time_hourly10 = jsonObj.getJSONArray("list").getJSONObject(10).getString("dt_txt")
                val time_hourly11 = jsonObj.getJSONArray("list").getJSONObject(11).getString("dt_txt")
                val time_hourly12 = jsonObj.getJSONArray("list").getJSONObject(12).getString("dt_txt")
                val time_hourly13= jsonObj.getJSONArray("list").getJSONObject(13).getString("dt_txt")
                val time_hourly14 = jsonObj.getJSONArray("list").getJSONObject(14).getString("dt_txt")
                val time_hourly15 = jsonObj.getJSONArray("list").getJSONObject(15).getString("dt_txt")
                val time_hourly16 = jsonObj.getJSONArray("list").getJSONObject(16).getString("dt_txt")
                val time_hourly17 = jsonObj.getJSONArray("list").getJSONObject(17).getString("dt_txt")
                val time_hourly18 = jsonObj.getJSONArray("list").getJSONObject(18).getString("dt_txt")



                val format =  SimpleDateFormat("MM-dd-yyyy HH:mm")

                val time2 = format.parse(time_hourly2)
                val time3 = format.parse(time_hourly3)
                val time4 = format.parse(time_hourly4)
                val time5 = format.parse(time_hourly5)
                val time6 = format.parse(time_hourly6)
                val time7 = format.parse(time_hourly7)
                val time8 = format.parse(time_hourly8)
                val time9 = format.parse(time_hourly9)
                val time10 = format.parse(time_hourly10)
                val time11 = format.parse(time_hourly11)
                val time12 = format.parse(time_hourly12)
                val time13 = format.parse(time_hourly13)
                val time14 = format.parse(time_hourly14)
                val time15 = format.parse(time_hourly15)
                val time16 = format.parse(time_hourly16)
                val time17 = format.parse(time_hourly17)
                val time18 = format.parse(time_hourly18)




                    findViewById<TextView>(R.id.time_hourly2).text= SimpleDateFormat("HH:mm").format(time2)
                findViewById<TextView>(R.id.time_hourly3).text= SimpleDateFormat("HH:mm").format(time3)
                findViewById<TextView>(R.id.time_hourly4).text= SimpleDateFormat("HH:mm").format(time4)
                findViewById<TextView>(R.id.time_hourly5).text= SimpleDateFormat("HH:mm").format(time5)
                findViewById<TextView>(R.id.time_hourly6).text= SimpleDateFormat("HH:mm").format(time6)
                findViewById<TextView>(R.id.time_hourly7).text= SimpleDateFormat("HH:mm").format(time7)
                findViewById<TextView>(R.id.time_hourly8).text= SimpleDateFormat("HH:mm").format(time8)
                findViewById<TextView>(R.id.time_hourly9).text= SimpleDateFormat("HH:mm").format(time9)
                findViewById<TextView>(R.id.time_hourly10).text= SimpleDateFormat("HH:mm").format(time10)
                findViewById<TextView>(R.id.time_hourly11).text= SimpleDateFormat("HH:mm").format(time11)
                findViewById<TextView>(R.id.time_hourly12).text= SimpleDateFormat("HH:mm").format(time12)
                findViewById<TextView>(R.id.time_hourly13).text= SimpleDateFormat("HH:mm").format(time13)
                findViewById<TextView>(R.id.time_hourly14).text= SimpleDateFormat("HH:mm").format(time14)
                findViewById<TextView>(R.id.time_hourly15).text= SimpleDateFormat("HH:mm").format(time15)
                findViewById<TextView>(R.id.time_hourly16).text= SimpleDateFormat("HH:mm").format(time16)
                findViewById<TextView>(R.id.time_hourly17).text= SimpleDateFormat("HH:mm").format(time17)
                findViewById<TextView>(R.id.time_hourly18).text= SimpleDateFormat("HH:mm").format(time18)
            } catch (e: Exception) {


            }

        }
    }
}
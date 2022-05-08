package com.example.viewpager2

import android.os.AsyncTask
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import org.json.JSONObject
import java.math.RoundingMode
import java.net.URL
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class API(){
    val API: String = "929cd208da68cb3e225b988a345d9035"





//    var temp: String = ""
//    var cityName: String = ""
//    var weathermain: String = ""
//    var dateTime: String = ""
//
//
//    var temp2 :String = ""
//    var temp3 :String = ""
//    var temp4 :String = ""
//    var temp5 :String = ""
//    var temp6 :String = ""
//    var temp7 :String = ""
//    var temp8 :String = ""
//    var temp9 :String = ""
//    var temp10 :String = ""
//    var temp11 :String = ""
//    var temp12 :String = ""
//    var temp13 :String = ""
//    var temp14 :String = ""
//    var temp15 :String = ""
//    var temp16 :String = ""
//    var temp17 :String = ""
//    var temp18 :String = ""
//
//
//
//    var time2: String = ""
//    var time3: String = ""
//    var time4: String = ""
//    var time5: String = ""
//    var time6: String = ""
//    var time7: String = ""
//    var time8: String = ""
//    var time9: String = ""
//    var time10: String = ""
//    var time11: String = ""
//    var time12: String = ""
//    var time13: String = ""
//    var time14: String = ""
//    var time15: String = ""
//    var time16: String = ""
//    var time17: String = ""
//    var time18: String = ""



 //    var city: String = ""



//    inner class currentweatherTask() : AsyncTask<String, Void, String>() {
//
//
//        override fun onPreExecute() {
//            super.onPreExecute()
//            /* Showing the ProgressBar, Making the main design GONE */
//
//
//        }

//        override fun doInBackground(vararg params: String?): String? {
//
//            var response1: String?
//            try {
//                response1 = URL("https://pro.openweathermap.org/data/2.5/weather?q=$city&units=metric&lang=vi&appid=$API").readText(
//                    Charsets.UTF_8
//                )
//            } catch (e: Exception) {
//                response1 = null
//            }
//            return response1
//        }
//
//        override fun onPostExecute(result: String?) {
//            super.onPostExecute(result)
//            try {
//                val jsonObj1 = JSONObject(result)
//                var weather = jsonObj1.getJSONArray("weather").getJSONObject(0)
//                val main = jsonObj1.getJSONObject("main")
//                val sys = jsonObj1.getJSONObject("sys")
//                val updatedAt: Long = jsonObj1.getLong("dt")
//                val temp_before = main.getString("temp")
//
//                val df = DecimalFormat("##")
//                df.roundingMode = RoundingMode.HALF_UP
//                 dateTime =
//                    "Updated at: " + SimpleDateFormat("dd/MM/yyyy HH:mm ", Locale.ENGLISH).format(
//                        Date(updatedAt * 1000)
//                    )
//                 temp = df.format(temp_before.toDouble())+ "°C"
//                 cityName = jsonObj1.getString("name") + ", " + sys.getString("country")
//                 weathermain = weather.getString("main")
//
//
//            } catch (e: Exception) {
//
//                //findViewById<TextView>(R.id.temp).visibility = View.VISIBLE
//            }
//
//        }
//    }
//
//
//
//
//    inner class hourlyWeatherTask() : AsyncTask<String, Void, String>() {
//
//
//        override fun onPreExecute() {
//            super.onPreExecute()
//            /* Showing the ProgressBar, Making the main design GONE */
//
//
//        }
//
//        override fun doInBackground(vararg params: String?): String? {
//            var response2: String?
//            try {
//                response2 = URL("https://pro.openweathermap.org/data/2.5/forecast?q=$city&units=metric&appid=$API").readText(
//                    Charsets.UTF_8
//                )
//            } catch (e: Exception) {
//                response2 = null
//            }
//            return response2
//        }
//
//        override fun onPostExecute(result: String?) {
//            super.onPostExecute(result)
//            try {
//                val jsonObj2 = JSONObject(result)
//                val hourly2 = jsonObj2.getJSONArray("list").getJSONObject(2).getJSONObject("main")
//                val hourly3 = jsonObj2.getJSONArray("list").getJSONObject(3).getJSONObject("main")
//                val hourly4 = jsonObj2.getJSONArray("list").getJSONObject(4).getJSONObject("main")
//                val hourly5 = jsonObj2.getJSONArray("list").getJSONObject(5).getJSONObject("main")
//                val hourly6 = jsonObj2.getJSONArray("list").getJSONObject(6).getJSONObject("main")
//                val hourly7 = jsonObj2.getJSONArray("list").getJSONObject(7).getJSONObject("main")
//                val hourly8 = jsonObj2.getJSONArray("list").getJSONObject(8).getJSONObject("main")
//                val hourly9 = jsonObj2.getJSONArray("list").getJSONObject(9).getJSONObject("main")
//                val hourly10 = jsonObj2.getJSONArray("list").getJSONObject(10).getJSONObject("main")
//                val hourly11 = jsonObj2.getJSONArray("list").getJSONObject(11).getJSONObject("main")
//                val hourly12 = jsonObj2.getJSONArray("list").getJSONObject(12).getJSONObject("main")
//                val hourly13= jsonObj2.getJSONArray("list").getJSONObject(13).getJSONObject("main")
//                val hourly14 = jsonObj2.getJSONArray("list").getJSONObject(14).getJSONObject("main")
//                val hourly15 = jsonObj2.getJSONArray("list").getJSONObject(15).getJSONObject("main")
//                val hourly16 = jsonObj2.getJSONArray("list").getJSONObject(16).getJSONObject("main")
//                val hourly17 = jsonObj2.getJSONArray("list").getJSONObject(17).getJSONObject("main")
//                val hourly18 = jsonObj2.getJSONArray("list").getJSONObject(18).getJSONObject("main")
//
//                val time_hourly2  = jsonObj2.getJSONArray("list").getJSONObject(2).getString("dt_txt")
//                val time_hourly3 = jsonObj2.getJSONArray("list").getJSONObject(3).getString("dt_txt")
//                val time_hourly4 = jsonObj2.getJSONArray("list").getJSONObject(4).getString("dt_txt")
//                val time_hourly5 = jsonObj2.getJSONArray("list").getJSONObject(5).getString("dt_txt")
//                val time_hourly6= jsonObj2.getJSONArray("list").getJSONObject(6).getString("dt_txt")
//                val time_hourly7 = jsonObj2.getJSONArray("list").getJSONObject(7).getString("dt_txt")
//                val time_hourly8 = jsonObj2.getJSONArray("list").getJSONObject(8).getString("dt_txt")
//                val time_hourly9 = jsonObj2.getJSONArray("list").getJSONObject(9).getString("dt_txt")
//                val time_hourly10 = jsonObj2.getJSONArray("list").getJSONObject(10).getString("dt_txt")
//                val time_hourly11 = jsonObj2.getJSONArray("list").getJSONObject(11).getString("dt_txt")
//                val time_hourly12 = jsonObj2.getJSONArray("list").getJSONObject(12).getString("dt_txt")
//                val time_hourly13= jsonObj2.getJSONArray("list").getJSONObject(13).getString("dt_txt")
//                val time_hourly14 = jsonObj2.getJSONArray("list").getJSONObject(14).getString("dt_txt")
//                val time_hourly15 = jsonObj2.getJSONArray("list").getJSONObject(15).getString("dt_txt")
//                val time_hourly16 = jsonObj2.getJSONArray("list").getJSONObject(16).getString("dt_txt")
//                val time_hourly17 = jsonObj2.getJSONArray("list").getJSONObject(17).getString("dt_txt")
//                val time_hourly18 = jsonObj2.getJSONArray("list").getJSONObject(18).getString("dt_txt")
//
//                temp2   =  hourly2.getString("temp")
//                 temp3   =  hourly3.getString("temp")
//                 temp4   =  hourly4.getString("temp")
//                 temp5   =  hourly5.getString("temp")
//                 temp6   =  hourly6.getString("temp")
//                 temp7   =  hourly7.getString("temp")
//                 temp8   =  hourly8.getString("temp")
//                 temp9   =  hourly9.getString("temp")
//                 temp10   =  hourly10.getString("temp")
//                 temp11   =  hourly11.getString("temp")
//                 temp12   =  hourly12.getString("temp")
//                 temp13   =  hourly13.getString("temp")
//                 temp14   =  hourly14.getString("temp")
//                 temp15   =  hourly15.getString("temp")
//                 temp16   =  hourly16.getString("temp")
//                 temp17   =  hourly17.getString("temp")
//                 temp18   =  hourly18.getString("temp")
//
//                val format =  SimpleDateFormat("MM-dd-yyyy HH:mm")
//
//                 time2 =   SimpleDateFormat("HH:mm").format(format.parse(time_hourly2))
//                 time3 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly3))
//                 time4 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly4))
//                 time5 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly5))
//                 time6 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly6))
//                 time7 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly7))
//                 time8 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly8))
//                time9 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly9))
//                 time10 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly10))
//                 time11 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly11))
//                 time12 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly12))
//                 time13 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly13))
//                 time14 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly14))
//                 time15 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly15))
//                 time16 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly16))
//                 time17 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly17))
//                 time18 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly18))
//
//
//
//            } catch (e: Exception) {
//
//                //findViewById<TextView>(R.id.temp).visibility = View.VISIBLE
//            }
//
//
//        }
//    }

//    fun getWeather(city: String): Weather{
//
//        val executor: ExecutorService = Executors.newSingleThreadExecutor()
//        val handler = Handler(Looper.getMainLooper())
//        lateinit var weatherr: Weather
//
//        executor.execute {
//            //Background work here
//            val response1: String = URL("https://pro.openweathermap.org/data/2.5/weather?q=$city&units=metric&lang=vi&appid=$API").readText(
//                Charsets.UTF_8)
//            val jsonObj1 = JSONObject(response1)
//            var weather = jsonObj1.getJSONArray("weather").getJSONObject(0)
//            val main = jsonObj1.getJSONObject("main")
//            val sys = jsonObj1.getJSONObject("sys")
//            val updatedAt: Long = jsonObj1.getLong("dt")
//            val temp_before = main.getString("temp")
//
//            val df = DecimalFormat("##")
//            df.roundingMode = RoundingMode.HALF_UP
//            val dateTime =
//                "Updated at: " + SimpleDateFormat("dd/MM/yyyy HH:mm ", Locale.ENGLISH).format(
//                    Date(updatedAt * 1000)
//                )
//            val temp = df.format(temp_before.toDouble())+ "°C"
//            val cityName = jsonObj1.getString("name") + ", " + sys.getString("country")
//            val weathermain = weather.getString("main")
//            //----------------------------
//
//            val response2 = URL("https://pro.openweathermap.org/data/2.5/forecast?q=$city&units=metric&appid=$API").readText(
//                Charsets.UTF_8)
//
//
//            val jsonObj2 = JSONObject(response2)
//            val hourly2 = jsonObj2.getJSONArray("list").getJSONObject(2).getJSONObject("main")
//            val hourly3 = jsonObj2.getJSONArray("list").getJSONObject(3).getJSONObject("main")
//            val hourly4 = jsonObj2.getJSONArray("list").getJSONObject(4).getJSONObject("main")
//            val hourly5 = jsonObj2.getJSONArray("list").getJSONObject(5).getJSONObject("main")
//            val hourly6 = jsonObj2.getJSONArray("list").getJSONObject(6).getJSONObject("main")
//            val hourly7 = jsonObj2.getJSONArray("list").getJSONObject(7).getJSONObject("main")
//            val hourly8 = jsonObj2.getJSONArray("list").getJSONObject(8).getJSONObject("main")
//            val hourly9 = jsonObj2.getJSONArray("list").getJSONObject(9).getJSONObject("main")
//            val hourly10 = jsonObj2.getJSONArray("list").getJSONObject(10).getJSONObject("main")
//            val hourly11 = jsonObj2.getJSONArray("list").getJSONObject(11).getJSONObject("main")
//            val hourly12 = jsonObj2.getJSONArray("list").getJSONObject(12).getJSONObject("main")
//            val hourly13= jsonObj2.getJSONArray("list").getJSONObject(13).getJSONObject("main")
//            val hourly14 = jsonObj2.getJSONArray("list").getJSONObject(14).getJSONObject("main")
//            val hourly15 = jsonObj2.getJSONArray("list").getJSONObject(15).getJSONObject("main")
//            val hourly16 = jsonObj2.getJSONArray("list").getJSONObject(16).getJSONObject("main")
//            val hourly17 = jsonObj2.getJSONArray("list").getJSONObject(17).getJSONObject("main")
//            val hourly18 = jsonObj2.getJSONArray("list").getJSONObject(18).getJSONObject("main")
//
//            val time_hourly2  = jsonObj2.getJSONArray("list").getJSONObject(2).getString("dt_txt")
//            val time_hourly3 = jsonObj2.getJSONArray("list").getJSONObject(3).getString("dt_txt")
//            val time_hourly4 = jsonObj2.getJSONArray("list").getJSONObject(4).getString("dt_txt")
//            val time_hourly5 = jsonObj2.getJSONArray("list").getJSONObject(5).getString("dt_txt")
//            val time_hourly6= jsonObj2.getJSONArray("list").getJSONObject(6).getString("dt_txt")
//            val time_hourly7 = jsonObj2.getJSONArray("list").getJSONObject(7).getString("dt_txt")
//            val time_hourly8 = jsonObj2.getJSONArray("list").getJSONObject(8).getString("dt_txt")
//            val time_hourly9 = jsonObj2.getJSONArray("list").getJSONObject(9).getString("dt_txt")
//            val time_hourly10 = jsonObj2.getJSONArray("list").getJSONObject(10).getString("dt_txt")
//            val time_hourly11 = jsonObj2.getJSONArray("list").getJSONObject(11).getString("dt_txt")
//            val time_hourly12 = jsonObj2.getJSONArray("list").getJSONObject(12).getString("dt_txt")
//            val time_hourly13= jsonObj2.getJSONArray("list").getJSONObject(13).getString("dt_txt")
//            val time_hourly14 = jsonObj2.getJSONArray("list").getJSONObject(14).getString("dt_txt")
//            val time_hourly15 = jsonObj2.getJSONArray("list").getJSONObject(15).getString("dt_txt")
//            val time_hourly16 = jsonObj2.getJSONArray("list").getJSONObject(16).getString("dt_txt")
//            val time_hourly17 = jsonObj2.getJSONArray("list").getJSONObject(17).getString("dt_txt")
//            val time_hourly18 = jsonObj2.getJSONArray("list").getJSONObject(18).getString("dt_txt")
//
//            val temp2   =  hourly2.getString("temp")
//            val temp3   =  hourly3.getString("temp")
//            val temp4   =  hourly4.getString("temp")
//            val temp5   =  hourly5.getString("temp")
//            val temp6   =  hourly6.getString("temp")
//            val temp7   =  hourly7.getString("temp")
//            val temp8   =  hourly8.getString("temp")
//            val temp9   =  hourly9.getString("temp")
//            val temp10   =  hourly10.getString("temp")
//            val temp11   =  hourly11.getString("temp")
//            val temp12   =  hourly12.getString("temp")
//            val temp13   =  hourly13.getString("temp")
//            val temp14   =  hourly14.getString("temp")
//            val temp15   =  hourly15.getString("temp")
//            val temp16   =  hourly16.getString("temp")
//            val temp17   =  hourly17.getString("temp")
//            val temp18   =  hourly18.getString("temp")
//
//            val format =  SimpleDateFormat("MM-dd-yyyy HH:mm")
//
//            val time2 =   SimpleDateFormat("HH:mm").format(format.parse(time_hourly2))
//            val time3 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly3))
//            val time4 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly4))
//            val time5 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly5))
//            val time6 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly6))
//            val time7 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly7))
//            val time8 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly8))
//            val time9 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly9))
//            val time10 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly10))
//            val time11 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly11))
//            val time12 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly12))
//            val time13 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly13))
//            val time14 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly14))
//            val time15 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly15))
//            val time16 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly16))
//            val time17 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly17))
//            val time18 = SimpleDateFormat("HH:mm").format(format.parse(time_hourly18))
//
//            handler.post {
//                weatherr = Weather(temp = temp, cityName =  cityName, weathermain = weathermain,dateTime = dateTime, temp2 = temp2, temp3 = temp3, temp4 = temp4, temp5 = temp5, temp6 = temp6, temp7 = temp7, temp8 = temp8, temp9 = temp9, temp10 = temp10,
//                    temp11 = temp11, temp12 = temp12, temp13 = temp13, temp14 = temp14, temp15 = temp15, temp16 = temp16, temp17 = temp17, temp18 = temp18,
//                    time2 = time2, time3 = time3, time4 = time4,time5 = time5,time6 = time6,time7 = time7,time8 = time8,time9 = time9,time10 = time10,
//                    time11 = time11,time12 = time12,time13 = time13,time14 = time14,time15 = time15,time16 = time16,time17 = time17,time18 = time18)
//            }
//
//
//        }
//        return weatherr





   // }





















//            val weatherr = Weather(
//                weathermain = weathermain,
//                temp = temp,
//                cityName = cityName,
//                dateTime = dateTime,
//                temp2 = temp2,
//                temp3 = temp3,
//                temp4 = temp4,
//                temp5 = temp5,
//                temp6 = temp6,
//                temp7 = temp7,
//                temp8 = temp8,
//                temp9 = temp9,
//                temp10 = temp10,
//                temp11 = temp11,
//                temp12 = temp12,
//                temp13 = temp13,
//                temp14 = temp14,
//                temp15 = temp15,
//                temp16 = temp16,
//                temp17 = temp17,
//                temp18 = temp18,
//                time2 = time2,
//                time3 = time3,
//                time4 = time4,
//                time5 = time5,
//                time6 = time6,
//                time7 = time7,
//                time8 = time8,
//                time9 = time9,
//                time10 = time10,
//                time11 = time11,
//                time12 = time12,
//                time13 = time13,
//                time14 = time14,
//                time15 = time15,
//                time16 = time16,
//                time17 = time17,
//                time18 = time18
//            )
//
//            return weatherr





















}
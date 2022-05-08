package com.example.viewpager2

import android.R.attr.y
import android.content.Context
import android.graphics.Color
import android.os.AsyncTask
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Menu
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.navigation.NavigationView
import jp.wasabeef.blurry.Blurry
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.math.RoundingMode
import java.net.URL
import java.text.DecimalFormat
import java.text.Normalizer
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.regex.Pattern
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    val API: String = "929cd208da68cb3e225b988a345d9035"

    var temp: String = ""
    var cityName: String = ""
    var weathermain: String = ""
    var dateTime: String = ""
    var image: String = ""

    var temp2: String = ""
    var temp3: String = ""
    var temp4: String = ""
    var temp5: String = ""
    var temp6: String = ""
    var temp7: String = ""
    var temp8: String = ""
    var temp9: String = ""
    var temp10: String = ""
    var temp11: String = ""
    var temp12: String = ""
    var temp13: String = ""
    var temp14: String = ""
    var temp15: String = ""
    var temp16: String = ""
    var temp17: String = ""
    var temp18: String = ""


    var time2: String = ""
    var time3: String = ""
    var time4: String = ""
    var time5: String = ""
    var time6: String = ""
    var time7: String = ""
    var time8: String = ""
    var time9: String = ""
    var time10: String = ""
    var time11: String = ""
    var time12: String = ""
    var time13: String = ""
    var time14: String = ""
    var time15: String = ""
    var time16: String = ""
    var time17: String = ""
    var time18: String = ""


    private lateinit var edName: EditText

    private lateinit var btnAdd: ImageButton

    lateinit var navigationView: NavigationView
    lateinit var viewpager: ViewPager2
    private lateinit var sqLiteHelper: SQLiteHelper
    private lateinit var recyclerViewCity: RecyclerView
    private lateinit var recyclerViewWeather: RecyclerView
    lateinit var Api: API

    private var adapterCity: CityAdapter? = null
    private var city: City? = null
    lateinit var weatherList: ArrayList<Weather>
    lateinit var scrollView : ScrollView
    lateinit var weather_view_pager: ConstraintLayout
    lateinit var context: Context

    lateinit var cityList: ArrayList<City>


    //lateinit var cityList: ArrayList<City>
    lateinit var ciTy: String
    lateinit var weatherr: Weather

    var wrongCity: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // viewpager = ViewPager2(this)
        sqLiteHelper = SQLiteHelper(this)
        context = this
        weatherList = ArrayList<Weather>()
        Api = API()

        //val images = listOf(R.drawable.i1580541, R.drawable.somewhere, R.drawable.i2988507)
        // var cityList: ArrayList<City> = sqLiteHelper.getAllCity()
        var cityList: ArrayList<City>

        cityList = sqLiteHelper.getAllCity()
        println("City size" + cityList.size)



        weatherList.clear()
        if(cityList.size<1){
            addFirstCity()

            val intent = intent
            finish()
            startActivity(intent)
        }else{
            println("City size" + cityList.size)
            getWeather(cityList)
        }

        //weatherList.add(weatherr)

        println(weatherList.size)















        initViewCity()
        initRecyclerViewCity()


        getCities()

        btnAdd.setOnClickListener() {
            addCity()
            btnAdd.isEnabled = false
            Handler().postDelayed({
                btnAdd.isEnabled = true
            }, 500)
        }


        adapterCity?.setOnClickItem {
            Toast.makeText(this, it.name, Toast.LENGTH_SHORT).show()
            edName.setText(it.name)

            city = it
        }
        adapterCity?.setOnClickDeleteitem {
            deleteCity(it.name)

        }


//        scrollView.viewTreeObserver.addOnScrollChangedListener {
//            Blurry.with(context)
//                .radius(10)
//                .sampling(8)
//                .color(Color.argb(66, 255, 255, 0))
//                .async()
//                .onto(navigationView);
//        }


    }


    private fun getCities() {
        cityList = sqLiteHelper.getAllCity()
        Log.e("pppp", "${cityList.size}")
        adapterCity?.addItems(cityList)
        //getWeather(cityList)
    }


    private fun addCity() {
        var addedCheck: Boolean = false
        val name = edName.text.toString()
//        val city =City  (name = name)
//                //Toast.makeText(this, "City added", Toast.LENGTH_SHORT).show()
//                //clearEditText()
//                //addCityWeather(name)
//                sqLiteHelper.insertCity(city)
//                weatherList.clear()
        val executor: ExecutorService = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())
        executor.execute {
            try {
                val response1: String =
                    URL("https://pro.openweathermap.org/data/2.5/weather?q=$name&units=metric&appid=$API").readText(
                        Charsets.UTF_8
                    )
                val jsonObj1 = JSONObject(response1)
                val cityName = jsonObj1.getString("name")
                val id = jsonObj1.getString("id")
                val city = City(name = cityName, id=id)
                sqLiteHelper.insertCity(city)
                addedCheck = true
                //clearEditText()
               // executor.shutdownNow()
            } catch (e: Exception) {
                e.printStackTrace()
                executor.shutdownNow()
            }
        }
        handler.post {
//               weatherList.clear()
//            val adapterWeather = WeatherAdapter(weatherList)
//            viewPager.adapter = adapterWeather
        }
        executor.shutdown();

        try {
            executor.awaitTermination(Long.MAX_VALUE, java.util.concurrent.TimeUnit.NANOSECONDS)
            if (addedCheck == true){
                Toast.makeText(this, "Location added!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "We do not support this location yet!", Toast.LENGTH_SHORT).show()
            }
            //weatherList.clear()
            //cityList= sqLiteHelper.getAllCity()
            //println(weatherList.size)
            cityList.clear()
            cityList = sqLiteHelper.getAllCity()
            getWeather(cityList)
            getCities()
        }
        catch (e: InterruptedException){

        }


    }

    fun addFirstCity() {
        val city = City(name = "london", id= "2643743")
        val status = sqLiteHelper.insertCity(city)
        if (status > -1) {
            getCities()
            //cityList = sqLiteHelper.getAllCity()
            //getWeather(cityList)
        } else {

        }
    }


    private fun deleteCity(name: String) {
        val builder = AlertDialog.Builder(this)
        val cityListz = sqLiteHelper.getAllCity()
        if (cityListz.size < 2) {
            Toast.makeText(this, "Minimum is 1", Toast.LENGTH_SHORT).show()
            return
        }
        if (name == null) return


        builder.setMessage("Are you sure you want to delete this location?")
        builder.setCancelable(true)
        builder.setPositiveButton("Yes") { dialog, _ ->
            sqLiteHelper.deleteCity(name)
            getCities()
            weatherList.clear()
            var cityList: ArrayList<City> = sqLiteHelper.getAllCity()
            getWeather(cityList)
            dialog.dismiss()
        }
        builder.setNegativeButton("No") { dialog, _ ->
            dialog.dismiss()
        }
        val alert = builder.create()
        alert.show()
    }

    fun autoDeleteCity(name: String) {
        sqLiteHelper.deleteCity(name)
        //getCities()
        //weatherList.clear()
        //var cityList: ArrayList<City> = sqLiteHelper.getAllCity()
        //getWeather(cityList)
    }

    private fun clearEditText() {
        edName.setText("")

        edName.requestFocus()

    }

    private fun initRecyclerViewCity() {
        recyclerViewCity.layoutManager = LinearLayoutManager(this)
        adapterCity = CityAdapter()
        recyclerViewCity.adapter = adapterCity
    }

    private fun initViewCity() {
        navigationView = findViewById(R.id.navigation_drawer)
        val hView = navigationView.getHeaderView(0)
        val menuNav: Menu = navigationView.getMenu()

        //scrollView = findViewById(R.id.horizontalScrollView)
        //val list_city = menuNav.findItem(R.id.list_city).getActionView()

        btnAdd = hView.findViewById(R.id.btn_add_city)
        edName = hView.findViewById(R.id.ed_add_city)
        recyclerViewCity = hView.findViewById(R.id.city_recyclerView)
    }
    //----------------------------------------------------


    inner class currentweatherTask() : AsyncTask<String, URL, String>() {


        override fun onPreExecute() {
            super.onPreExecute()
            /* Showing the ProgressBar, Making the main design GONE */


        }

        override fun doInBackground(vararg params: String?): String? {

            var response1: String?
            try {
                response1 =
                    URL("https://pro.openweathermap.org/data/2.5/weather?q=$city&units=metric&lang=vi&appid=$API").readText(
                        Charsets.UTF_8
                    )
            } catch (e: Exception) {
                response1 = null
            }
            return response1
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            try {
                val jsonObj1 = JSONObject(result)
                var weather = jsonObj1.getJSONArray("weather").getJSONObject(0)
                val main = jsonObj1.getJSONObject("main")
                val sys = jsonObj1.getJSONObject("sys")
                val updatedAt: Long = jsonObj1.getLong("dt")
                val temp_before = main.getString("temp")
                val timeZone = jsonObj1.getLong("timezone")
                val df = DecimalFormat("##")
                df.roundingMode = RoundingMode.HALF_UP
                dateTime =
                    "Updated at: " + SimpleDateFormat(
                        "dd/MM/yyyy HH:mm ",
                        Locale.ENGLISH
                    ).format(
                        Date((timeZone+updatedAt) * 1000)
                    )
                temp = df.format(temp_before.toDouble()) + "°C"
                cityName = jsonObj1.getString("name") + ", " + sys.getString("country")
                weathermain = weather.getString("main")


            } catch (e: Exception) {

                //findViewById<TextView>(R.id.temp).visibility = View.VISIBLE
            }

        }


    }


    fun getWeather(cityList: ArrayList<City>) {

        val executor: ExecutorService = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())
        val df = DecimalFormat("##")
        weatherList.clear()
        df.roundingMode = RoundingMode.HALF_UP
        println("City size3: " + cityList.size)
        executor.execute {

//            cityList.clear()
            this.cityList = sqLiteHelper.getAllCity()
            //Background work here
            println("City size" + cityList.size)
            for (i in 0 until cityList.size) {

                println(cityList.size)

                var city = cityList[i].name

                val response1: String =
                    URL("https://pro.openweathermap.org/data/2.5/weather?q=$city&units=metric&lang=vi&appid=$API").readText(
                        Charsets.UTF_8
                    )
                val jsonObj1 = JSONObject(response1)
                var weather = jsonObj1.getJSONArray("weather").getJSONObject(0)
                val main = jsonObj1.getJSONObject("main")
                val sys = jsonObj1.getJSONObject("sys")
                val updatedAt: Long = jsonObj1.getLong("dt")
                val temp_before = main.getString("temp")
                val timeZone = jsonObj1.getLong("timezone")
                val df = DecimalFormat("##")
                df.roundingMode = RoundingMode.HALF_UP



                val dateTime =
                    "Updated at: " + SimpleDateFormat(
                        "dd/MM/yyyy HH:mm ",
                        Locale.ENGLISH
                    ).format(
                      //  Date((timeZone+updatedAt) * 1000)
                        Date((updatedAt+timeZone-25200)*1000)
                    )

                println(updatedAt)

                val temp = df.format(temp_before.toDouble()) + "°C"
                val cityName = jsonObj1.getString("name") + ", " + sys.getString("country")
                val weathermain = weather.getString("main")
                //----------------------------

                val response2 =
                    URL("https://pro.openweathermap.org/data/2.5/forecast?q=$city&units=metric&appid=$API").readText(
                        Charsets.UTF_8
                    )


                val jsonObj2 = JSONObject(response2)
                val hourly2 =
                    jsonObj2.getJSONArray("list").getJSONObject(2).getJSONObject("main")
                val hourly3 =
                    jsonObj2.getJSONArray("list").getJSONObject(3).getJSONObject("main")
                val hourly4 =
                    jsonObj2.getJSONArray("list").getJSONObject(4).getJSONObject("main")
                val hourly5 =
                    jsonObj2.getJSONArray("list").getJSONObject(5).getJSONObject("main")
                val hourly6 =
                    jsonObj2.getJSONArray("list").getJSONObject(6).getJSONObject("main")
                val hourly7 =
                    jsonObj2.getJSONArray("list").getJSONObject(7).getJSONObject("main")
                val hourly8 =
                    jsonObj2.getJSONArray("list").getJSONObject(8).getJSONObject("main")
                val hourly9 =
                    jsonObj2.getJSONArray("list").getJSONObject(9).getJSONObject("main")
                val hourly10 =
                    jsonObj2.getJSONArray("list").getJSONObject(10).getJSONObject("main")
                val hourly11 =
                    jsonObj2.getJSONArray("list").getJSONObject(11).getJSONObject("main")
                val hourly12 =
                    jsonObj2.getJSONArray("list").getJSONObject(12).getJSONObject("main")
                val hourly13 =
                    jsonObj2.getJSONArray("list").getJSONObject(13).getJSONObject("main")
                val hourly14 =
                    jsonObj2.getJSONArray("list").getJSONObject(14).getJSONObject("main")
                val hourly15 =
                    jsonObj2.getJSONArray("list").getJSONObject(15).getJSONObject("main")
                val hourly16 =
                    jsonObj2.getJSONArray("list").getJSONObject(16).getJSONObject("main")
                val hourly17 =
                    jsonObj2.getJSONArray("list").getJSONObject(17).getJSONObject("main")
                val hourly18 =
                    jsonObj2.getJSONArray("list").getJSONObject(18).getJSONObject("main")

                val time_hourly2 =
                    jsonObj2.getJSONArray("list").getJSONObject(2).getLong("dt")
                val time_hourly3 =
                    jsonObj2.getJSONArray("list").getJSONObject(3).getLong("dt")
                val time_hourly4 =
                    jsonObj2.getJSONArray("list").getJSONObject(4).getLong("dt")
                val time_hourly5 =
                    jsonObj2.getJSONArray("list").getJSONObject(5).getLong("dt")
                val time_hourly6 =
                    jsonObj2.getJSONArray("list").getJSONObject(6).getLong("dt")
                val time_hourly7 =
                    jsonObj2.getJSONArray("list").getJSONObject(7).getLong("dt")
                val time_hourly8 =
                    jsonObj2.getJSONArray("list").getJSONObject(8).getLong("dt")
                val time_hourly9 =
                    jsonObj2.getJSONArray("list").getJSONObject(9).getLong("dt")
                val time_hourly10 =
                    jsonObj2.getJSONArray("list").getJSONObject(10).getLong("dt")
                val time_hourly11 =
                    jsonObj2.getJSONArray("list").getJSONObject(11).getLong("dt")
                val time_hourly12 =
                    jsonObj2.getJSONArray("list").getJSONObject(12).getLong("dt")
                val time_hourly13 =
                    jsonObj2.getJSONArray("list").getJSONObject(13).getLong("dt")
                val time_hourly14 =
                    jsonObj2.getJSONArray("list").getJSONObject(14).getLong("dt")
                val time_hourly15 =
                    jsonObj2.getJSONArray("list").getJSONObject(15).getLong("dt")
                val time_hourly16 =
                    jsonObj2.getJSONArray("list").getJSONObject(16).getLong("dt")
                val time_hourly17 =
                    jsonObj2.getJSONArray("list").getJSONObject(17).getLong("dt")
                val time_hourly18 =
                    jsonObj2.getJSONArray("list").getJSONObject(18).getLong("dt")



                temp2 = df.format(hourly2.getString("temp").toDouble()) + "°C"
                temp3 = df.format(hourly3.getString("temp").toDouble()) + "°C"
                temp4 = df.format(hourly4.getString("temp").toDouble()) + "°C"
                temp5 = df.format(hourly5.getString("temp").toDouble()) + "°C"
                temp6 = df.format(hourly6.getString("temp").toDouble()) + "°C"
                temp7 = df.format(hourly7.getString("temp").toDouble()) + "°C"
                temp8 = df.format(hourly8.getString("temp").toDouble()) + "°C"
                temp9 = df.format(hourly9.getString("temp").toDouble()) + "°C"
                temp10 = df.format(hourly10.getString("temp").toDouble()) + "°C"
                temp11 = df.format(hourly11.getString("temp").toDouble()) + "°C"
                temp12 = df.format(hourly12.getString("temp").toDouble()) + "°C"
                temp13 = df.format(hourly13.getString("temp").toDouble()) + "°C"
                temp14 = df.format(hourly14.getString("temp").toDouble()) + "°C"
                temp15 = df.format(hourly15.getString("temp").toDouble()) + "°C"
                temp16 = df.format(hourly16.getString("temp").toDouble()) + "°C"
                temp17 = df.format(hourly17.getString("temp").toDouble()) + "°C"
                temp18 = df.format(hourly18.getString("temp").toDouble()) + "°C"

                val format = SimpleDateFormat("MM-dd-yyyy HH:mm")

                time2 = SimpleDateFormat("HH:mm ",Locale.ENGLISH).format(Date((time_hourly2+timeZone-50400) * 1000))

                time3 = SimpleDateFormat("HH:mm ",Locale.ENGLISH).format(Date((time_hourly3+timeZone-50400) * 1000))
                time4 = SimpleDateFormat("HH:mm ",Locale.ENGLISH).format(Date((time_hourly4+timeZone-50400) * 1000))
                time5 = SimpleDateFormat("HH:mm ",Locale.ENGLISH).format(Date((time_hourly5+timeZone-50400) * 1000))
                time6 = SimpleDateFormat("HH:mm ",Locale.ENGLISH).format(Date((time_hourly6+timeZone-50400) * 1000))
                time7 = SimpleDateFormat("HH:mm ",Locale.ENGLISH).format(Date((time_hourly7+timeZone-50400) * 1000))
                time8 = SimpleDateFormat("HH:mm ",Locale.ENGLISH).format(Date((time_hourly8+timeZone-50400) * 1000))
                time9 = SimpleDateFormat("HH:mm ",Locale.ENGLISH).format(Date((time_hourly9+timeZone-50400) * 1000))
                time10 = SimpleDateFormat("HH:mm ",Locale.ENGLISH).format(Date((time_hourly10+timeZone-50400) * 1000))
                time11 = SimpleDateFormat("HH:mm ",Locale.ENGLISH).format(Date((time_hourly11+timeZone-50400) * 1000))
                time12 = SimpleDateFormat("HH:mm ",Locale.ENGLISH).format(Date((time_hourly12+timeZone-50400) * 1000))
                time13 = SimpleDateFormat("HH:mm ",Locale.ENGLISH).format(Date((time_hourly13+timeZone-50400) * 1000))
                time14 = SimpleDateFormat("HH:mm ",Locale.ENGLISH).format(Date((time_hourly14+timeZone-50400) * 1000))
                time15 = SimpleDateFormat("HH:mm ",Locale.ENGLISH).format(Date((time_hourly15+timeZone-50400) * 1000))
                time16 = SimpleDateFormat("HH:mm ",Locale.ENGLISH).format(Date((time_hourly16+timeZone-50400) * 1000))
                time17 = SimpleDateFormat("HH:mm ",Locale.ENGLISH).format(Date((time_hourly17+timeZone-50400) * 1000))
                time18 = SimpleDateFormat("HH:mm ",Locale.ENGLISH).format(Date((time_hourly18+timeZone-50400) * 1000))

                image = cityList[i].id
                println(cityList[i].name)
                println(image)


                weatherr = Weather(
                    temp = temp,
                    cityName = cityName,
                    weathermain = weathermain,
                    dateTime = dateTime,
                    image = image,
                    temp2 = temp2,
                    temp3 = temp3,
                    temp4 = temp4,
                    temp5 = temp5,
                    temp6 = temp6,
                    temp7 = temp7,
                    temp8 = temp8,
                    temp9 = temp9,
                    temp10 = temp10,
                    temp11 = temp11,
                    temp12 = temp12,
                    temp13 = temp13,
                    temp14 = temp14,
                    temp15 = temp15,
                    temp16 = temp16,
                    temp17 = temp17,
                    temp18 = temp18,
                    time2 = time2,
                    time3 = time3,
                    time4 = time4,
                    time5 = time5,
                    time6 = time6,
                    time7 = time7,
                    time8 = time8,
                    time9 = time9,
                    time10 = time10,
                    time11 = time11,
                    time12 = time12,
                    time13 = time13,
                    time14 = time14,
                    time15 = time15,
                    time16 = time16,
                    time17 = time17,
                    time18 = time18
                )
                weatherList.add(weatherr)
                sqLiteHelper.updateCity(cityList[i], cityName)

            }


            handler.post {


                context.applicationContext

                val adapterWeather = WeatherAdapter(weatherList, context)
                viewPager.adapter = adapterWeather
                println(weatherList.size)

//                val progressDialog = ProgressDialog(this@MainActivity)
//                progressDialog.setTitle("Kotlin Progress Bar")
//                progressDialog.setMessage("Application is loading, please wait")
//                progressDialog.show()
            }


        }


    }
    fun removeAccent(s: String): String {
        var temp: String = Normalizer.normalize(s, Normalizer.Form.NFD)
        val pattern: Pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+")
        temp = pattern.matcher(temp).replaceAll("")
        return temp.replace("đ".toRegex(), "d")
    }


}




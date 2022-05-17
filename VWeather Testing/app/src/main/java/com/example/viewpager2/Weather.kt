package com.example.viewpager2

class Weather {
    var weathermain: String = ""
    var temp: String = ""
    var cityName: String = ""
    var dateTime: String = ""
    var currentTime: String = ""
    var humidity: String =""
    var wind_speed: String = ""
    var wind_deg: String = ""
    var image: String = ""
    var icon: String = ""
    var feels_like: String =""
    var minTempToday: String = ""
    var maxTempToday: String = ""
    var sunrise: String = ""
    var sunset: String = ""
    var alerts: String = ""
    var alerts_description: String = ""
    var visibility: String = ""
    var pressure: String = ""
    var pop1: String = ""
    var pop2: String = ""
    var pop3: String = ""
    var pop4: String = ""
    var pop5: String = ""
    var pop6: String = ""
    var pop7: String = ""
    var pop8: String = ""
    var pop9: String = ""
    var pop10: String = ""
    var pop11: String = ""
    var pop12: String = ""
    var pop13: String = ""
    var pop14: String = ""
    var pop15: String = ""
    var pop16: String = ""
    var pop17: String = ""
    var pop18: String = ""

    var daily_icon1: String = ""
    var daily_icon2: String = ""
    var daily_icon3: String = ""
    var daily_icon4: String = ""
    var daily_icon5: String = ""
    var daily_icon6: String = ""
    var daily_icon7: String = ""
    var daily_icon8: String = ""
    var daily_pop1: String = ""
    var daily_pop2: String = ""
    var daily_pop3: String = ""
    var daily_pop4: String = ""
    var daily_pop5: String = ""
    var daily_pop6: String = ""
    var daily_pop7: String = ""
    var daily_pop8: String = ""
    var daily_mintemp1: String = ""
    var daily_mintemp2: String = ""
    var daily_mintemp3: String = ""
    var daily_mintemp4: String = ""
    var daily_mintemp5: String = ""
    var daily_mintemp6: String = ""
    var daily_mintemp7: String = ""
    var daily_mintemp8: String = ""
    var daily_maxtemp1: String = ""
    var daily_maxtemp2: String = ""
    var daily_maxtemp3: String = ""
    var daily_maxtemp4: String = ""
    var daily_maxtemp5: String = ""
    var daily_maxtemp6: String = ""
    var daily_maxtemp7: String = ""
    var daily_maxtemp8: String = ""
    var daily_day1: String = ""
    var daily_day2: String = ""
    var daily_day3: String = ""
    var daily_day4: String = ""
    var daily_day5: String = ""
    var daily_day6: String = ""
    var daily_day7: String = ""
    var daily_day8: String = ""


    var icon2: String = ""
    var icon3: String = ""
    var icon4: String = ""
    var icon5: String = ""
    var icon6: String = ""
    var icon7: String = ""
    var icon8: String = ""
    var icon9: String = ""
    var icon10: String = ""
    var icon11: String = ""
    var icon12: String = ""
    var icon13: String = ""
    var icon14: String = ""
    var icon15: String = ""
    var icon16: String = ""
    var icon17: String = ""
    var icon18: String = ""

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
    var temp14: String = ""
    var temp13: String = ""
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


    constructor(
        weathermain: String,
        temp: String,
        cityName: String,
        dateTime: String,
        humidity: String,
        minTempToday: String,
        maxTempToday: String,
        currentTime: String,
        visibility: String,
        sunrise: String,
        feels_like:String,
        sunset: String,
        wind_speed: String,
        pressure: String,
        wind_deg: String,
        icon: String,
        alerts: String,
        alerts_description: String,
        daily_icon1: String ,
        daily_icon2: String ,
         daily_icon3: String ,
         daily_icon4: String ,
       daily_icon5: String ,
         daily_icon6: String,
         daily_icon7: String,
        daily_icon8: String ,
        daily_pop1: String ,
         daily_pop2: String ,
         daily_pop3: String ,
         daily_pop4: String ,
        daily_pop5: String ,
         daily_pop6: String ,
         daily_pop7: String ,
        daily_pop8: String ,
         daily_mintemp1: String,
         daily_mintemp2: String ,
         daily_mintemp3: String ,
         daily_mintemp4: String ,
         daily_mintemp5: String ,
         daily_mintemp6: String ,
         daily_mintemp7: String ,
         daily_mintemp8: String ,
        daily_maxtemp1: String,
         daily_maxtemp2: String,
        daily_maxtemp3: String ,
         daily_maxtemp4: String ,
        daily_maxtemp5: String ,
        daily_maxtemp6: String ,
        daily_maxtemp7: String ,
         daily_maxtemp8: String,
       daily_day1: String,
      daily_day2: String ,
         daily_day3: String,
         daily_day4: String ,
         daily_day5: String,
        daily_day6: String ,
         daily_day7: String ,
        daily_day8: String ,


        icon2: String ,
       icon3: String ,
       icon4: String ,
        icon5: String ,
       icon6: String ,
       icon7: String ,
        icon8: String,
        icon9: String ,
       icon10: String ,
         icon11: String,
        icon12: String,
      icon13: String ,
        icon14: String,
         icon15: String,
         icon16: String,
        icon17: String ,
         icon18: String,

        pop1: String,
        pop2: String,
        pop3: String ,
        pop4: String ,
         pop5: String ,
        pop6: String,
        pop7: String,
        pop8: String ,
         pop9: String,
         pop10: String ,
        pop11: String ,
         pop12: String ,
        pop13: String ,
        pop14: String,
        pop15: String,
        pop16: String,
         pop17: String,
        pop18: String ,
        image: String,
        temp2: String,
        temp3: String,
        temp4: String,
        temp5: String,
        temp6: String,
        temp7: String,
        temp8: String,
        temp9: String,
        temp10: String,
        temp11: String,
        temp12: String,
        temp14: String,
        temp13: String,
        temp15: String,
        temp16: String,
        temp17: String,
        temp18: String,
        time2: String,
        time3: String,
        time4: String,
        time5: String,
        time6: String,
        time7: String,
        time8: String,
        time9: String,
        time10: String,
        time11: String,
        time12: String,
        time13: String,
        time14: String,
        time15: String,
        time16: String,
        time17: String,
        time18: String
    ) {
        this.weathermain = weathermain
        this.temp = temp
        this.cityName = cityName
        this.dateTime = dateTime
        this.icon = icon
        this.sunrise = sunrise
        this.sunset = sunset
        this.feels_like = feels_like
        this.alerts = alerts
        this.wind_speed = wind_speed
        this.wind_deg = wind_deg
        this.visibility = visibility
        this.humidity = humidity
        this.alerts_description = alerts_description
        this.pressure = pressure
        this.currentTime = currentTime
        this.daily_icon1 = daily_icon1
        this.daily_icon2 = daily_icon2
        this.daily_icon3 = daily_icon3
        this.daily_icon4 = daily_icon4
        this.daily_icon5 = daily_icon5
        this.daily_icon6 = daily_icon6
        this.daily_icon7 = daily_icon7
        this.daily_icon8 = daily_icon8
        this.daily_pop1 = daily_pop1
        this.daily_pop2 = daily_pop2
        this.daily_pop3 = daily_pop3
        this.daily_pop4 = daily_pop4
        this.daily_pop5 = daily_pop5
        this.daily_pop6 = daily_pop6
        this.daily_pop7 = daily_pop7
        this.daily_pop8 = daily_pop8
        this.daily_mintemp1 = daily_mintemp1
        this.daily_mintemp2 = daily_mintemp2
        this.daily_mintemp3 = daily_mintemp3
        this.daily_mintemp4 = daily_mintemp4
        this.daily_mintemp5 = daily_mintemp5
        this.daily_mintemp6 = daily_mintemp6
        this.daily_mintemp7 = daily_mintemp7
        this.daily_mintemp8 = daily_mintemp8
        this.daily_maxtemp1 = daily_maxtemp1
        this.daily_maxtemp2 = daily_maxtemp2
        this.daily_maxtemp3 = daily_maxtemp3
        this.daily_maxtemp4 = daily_maxtemp4
        this.daily_maxtemp5 = daily_maxtemp5
        this.daily_maxtemp6 = daily_maxtemp6
        this.daily_maxtemp7 = daily_maxtemp7
        this.daily_maxtemp8 = daily_maxtemp8
        this.daily_day1 = daily_day1
        this.daily_day2 = daily_day2
        this.daily_day3 = daily_day3
        this.daily_day4 = daily_day4
        this.daily_day5 = daily_day5
        this.daily_day6 = daily_day6
        this.daily_day7 = daily_day7
        this.daily_day8 = daily_day8

        this.icon2 = icon2
        this.icon3 = icon3
        this.icon4 = icon4
        this.icon5 = icon5
        this.icon6 = icon6
        this.icon7 = icon7
        this.icon8 = icon8
        this.icon9  = icon9
        this.icon10 = icon10
        this.icon11 = icon11
        this.icon12 = icon12
        this.icon13  = icon13
        this.icon14 = icon14
        this.icon15 = icon15
        this.icon16 = icon16
        this.icon17 = icon17
        this.icon18 = icon18
        this.temp2 = temp2
        this.temp3 = temp3
        this.temp4 = temp4
        this.temp5 = temp5
        this.temp6 = temp6
        this.temp7 = temp7
        this.temp8 = temp8
        this.temp9 = temp9
        this.temp10 = temp10
        this.temp11 = temp11
        this.temp12 = temp12
        this.temp14 = temp14
        this.temp13 = temp13
        this.temp15 = temp15
        this.temp16 = temp16
        this.temp17 = temp17
        this.temp18 = temp18
        this.time2 = time2
        this.time3 = time3
        this.time4 = time4
        this.time5 = time5
        this.time6 = time6
        this.time7 = time7
        this.time8 = time8
        this.time9 = time9
        this.time10 = time10
        this.time11 = time11
        this.time12 = time12
        this.time13 = time13
        this.time14 = time14
        this.time15 = time15
        this.time16 = time16
        this.time17 = time17
        this.time18 = time18
        this.image = image
        this.maxTempToday = maxTempToday
        this.minTempToday = minTempToday
        this.pop1 = pop1
        this.pop2 = pop2
        this.pop3 = pop3
        this.pop4 = pop4
        this.pop5 = pop5
        this.pop6 = pop6
        this.pop7 = pop7
        this.pop8 = pop8
        this.pop9 = pop9
        this.pop10 = pop10
        this.pop11 = pop11
        this.pop12 = pop12
        this.pop13 = pop13
        this.pop14 = pop14
        this.pop15 = pop15
        this.pop16 = pop16
        this.pop17 = pop17
        this.pop18 = pop18

    }
    constructor(){

    }
}
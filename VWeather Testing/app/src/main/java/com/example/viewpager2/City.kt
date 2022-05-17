package com.example.viewpager2

class City {
    var id: String =""
    var name: String = ""
    var lon: String = ""
    var lat: String = ""
    constructor(name: String ,id : String,lat: String,lon: String){
        this.name=name
        this.lat = lat
        this.lon = lon
        this.id = id
    }

}
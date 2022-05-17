package com.example.viewpager2

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.Exception

class SQLiteHelper (context: Context): SQLiteOpenHelper(context, DATABASE_NAME,null,1){
    companion object{
        private val DATABASE_NAME = "MyWeatherDB"
        private val TABLE_NAME = "Cities"
        private val COL_ID = "id"
        private val COL_NAME = "name"
        private val COL_IMAGE = "image"
        private val COL_LAT = "lat"
        private val COL_LON = "lon"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTblUser = "CREATE TABLE " + TABLE_NAME +" ("+
                COL_ID + " NVARCHAR(256),"+
                COL_NAME + " NVARCHAR(256),"+
                COL_LON + " NVARCHAR(256),"+
                COL_LAT + " NVARCHAR(256))"




        db?.execSQL(createTblUser)

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insertCity(city: City): Long{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_NAME, city.name)
        contentValues.put(COL_ID,city.id)
        contentValues.put(COL_LON, city.lon)
        contentValues.put(COL_LAT,city.lat)
        val success = db.insert(TABLE_NAME, null, contentValues)
        db.close()
        return success

    }
    fun insertCityImage(city: City,image :String): Int{
        val db = this.writableDatabase
        val contentValues = ContentValues()

        contentValues.put(COL_IMAGE,image)


        val success = db.update(TABLE_NAME, contentValues, "name="+ city.name,null)
        db.close()
        return success

    }



    @SuppressLint("Range")
    fun getAllCity(): ArrayList<City>{
        val cityList: ArrayList<City> = ArrayList()
        val selectQuery = "SELECT * FROM $TABLE_NAME"
        val db = this.readableDatabase

        val cursor: Cursor?

        try{
            cursor = db.rawQuery(selectQuery,null)
        }catch (e: Exception){
            e.printStackTrace()
            db.execSQL(selectQuery)
            return ArrayList()
        }

        var name: String
        var lat: String
        var lon: String
        var id : String
        if(cursor.moveToFirst()){
            do{
                id = cursor.getString(cursor.getColumnIndex(COL_ID))
                name = cursor.getString(cursor.getColumnIndex(COL_NAME))
                lat = cursor.getString(cursor.getColumnIndex(COL_LAT))
                lon = cursor.getString(cursor.getColumnIndex(COL_LON))
                val city = City(id = id ,name = name, lat = lat,lon=lon)
                cityList.add(city)
            }while (cursor.moveToNext())
        }
        return cityList
    }

    fun updateCity(city: City, name: String): Int{
        val db = this.writableDatabase
        val contentValues = ContentValues()

        contentValues.put(COL_NAME,name)

        //contentValues.put(COL_IMAGE,city.image)
        val success = db.update(TABLE_NAME, contentValues, "id="+ city.id,null)
        db.close()
        return success
    }

    fun deleteCity(name: String): Int{
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(COL_NAME,name)
        val success = db.delete(TABLE_NAME, "name='$name'",null)
        db.close()
        return success
    }
}
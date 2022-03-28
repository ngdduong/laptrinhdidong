package com.example.sqlitepro

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import androidx.core.content.contentValuesOf
import java.lang.Exception


class SQLiteHelper (context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null,1){
    companion object{
        private val DATABASE_NAME = "MyDB"
        private val TABLE_NAME = "Users"
        private val COL_NAME = "name"
        private val COL_AGE = "age"
        private val COL_ID = "id"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTblUser = "CREATE TABLE " + TABLE_NAME +" ("+
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COL_NAME + " VARCHAR(256)," +
                COL_AGE + " INTEGER)"
        db?.execSQL(createTblUser)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
//        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
//        onCreate(db)
    }
    fun insertUser(user: User): Long{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_NAME, user.name)
        contentValues.put(COL_AGE,user.age)

        val success = db.insert(TABLE_NAME, null, contentValues)
        db.close()
        return success

    }

    fun getAllUser(): ArrayList<User>{
        val userList: ArrayList<User> = ArrayList()
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
        var id:Int
        var name: String
        var age: Int

        if(cursor.moveToFirst()){
            do{
                id = cursor.getInt(cursor.getColumnIndex(COL_ID))
                name = cursor.getString(cursor.getColumnIndex(COL_NAME))
                age = cursor.getString(cursor.getColumnIndex(COL_AGE)).toInt()

                val user = User(id = id,name = name, age = age)
                userList.add(user)
            }while (cursor.moveToNext())
        }
        return userList
    }
    fun updateUser(user: User): Int{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_ID, user.id)
        contentValues.put(COL_NAME,user.name)
        contentValues.put(COL_AGE,user.age)

        val success = db.update(TABLE_NAME, contentValues, "id="+ user.id,null)
        db.close()
        return success
    }

    fun deleteUser(id:Int): Int{
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(COL_ID,id)
        val success = db.delete(TABLE_NAME, "id=$id",null)
        db.close()
        return success
    }
}
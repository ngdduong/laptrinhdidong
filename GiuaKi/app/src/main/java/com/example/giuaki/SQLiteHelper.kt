package com.example.giuaki

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.Exception

class SQLiteHelper (context: Context): SQLiteOpenHelper(context, DATABASE_NAME,null,1){
    companion object{
        private val DATABASE_NAME = "MyDB"
        private val TABLE_NAME = "Users"
        private val COL_NAME = "name"
        private val COL_EMAIL = "email"
        private val COL_ID = "id"
        private val COL_PHONENUMBER = "phonenumber"
        private val COL_ADDRESS = "address"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTblUser = "CREATE TABLE " + TABLE_NAME +" ("+
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COL_NAME + " NVARCHAR(256)," +
                COL_EMAIL + " VARCHAR(256),"+
                COL_PHONENUMBER + " VARCHAR(256),"+
                COL_ADDRESS + " NVARCHAR(256))"
        db?.execSQL(createTblUser)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insertUser(user: User): Long{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_NAME, user.name)
        contentValues.put(COL_EMAIL,user.email)
        contentValues.put(COL_PHONENUMBER,user.phonenumber)
        contentValues.put(COL_ADDRESS,user.address)
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
        var email:  String
        var phonenumber: String
        var address: String

        if(cursor.moveToFirst()){
            do{
                id = cursor.getInt(cursor.getColumnIndex(COL_ID))
                name = cursor.getString(cursor.getColumnIndex(COL_NAME))
                email = cursor.getString(cursor.getColumnIndex(COL_EMAIL))
                phonenumber = cursor.getString(cursor.getColumnIndex(COL_PHONENUMBER))
                address = cursor.getString(cursor.getColumnIndex(COL_ADDRESS))

                val user = User(id = id,name = name, email = email, phonenumber= phonenumber,address=address)
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
        contentValues.put(COL_EMAIL,user.email)
        contentValues.put(COL_PHONENUMBER,user.phonenumber)
        contentValues.put(COL_ADDRESS,user.address)

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
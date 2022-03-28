package com.example.sqlitepro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var edName: EditText
    private lateinit var edAge : EditText
    private lateinit var btnAdd: Button
    private lateinit var btnView: Button
    private lateinit var btnUpdate: Button

    private lateinit var sqLiteHelper: SQLiteHelper
    private lateinit var recyclerView: RecyclerView
    private var adapter: UserAdapter? = null
    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        initRecyclerView()
        sqLiteHelper = SQLiteHelper(this)

        btnAdd.setOnClickListener(){
            addUser()

        }
        btnView.setOnClickListener(){
            getUsers()
        }
        btnUpdate.setOnClickListener(){
            updateUser()
        }
        adapter?.setOnClickItem {
            Toast.makeText(this,it.name,Toast.LENGTH_SHORT).show()
            edName.setText(it.name)
            edAge.setText(it.age.toString())
            user = it
        }
        adapter?.setOnClickDeleteitem {
            deleteUser(it.id)
        }
    }
    private fun getUsers(){
        val userList = sqLiteHelper.getAllUser()
        Log.e("pppp", "${userList.size}")
        adapter?.addItems(userList)
    }
    private fun addUser(){
        val name = edName.text.toString()
        val age = edAge.text.toString()

        if(name.isEmpty() || age.isEmpty()){
            Toast.makeText(this, "Please enter required field ", Toast.LENGTH_SHORT).show()
            clearEditText()
        }else{
            val user = User(name = name, age = age.toInt())
            val status = sqLiteHelper.insertUser(user)
            if(status > -1){
                Toast.makeText(this,"User added", Toast.LENGTH_SHORT).show()
                clearEditText()
                getUsers()
            }else{
                Toast.makeText(this,"Record not saved", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun updateUser(){
        val name = edName.text.toString()
        val age = edAge.text.toString().toInt()

        if(name == user?.name && age == user?.age){
            Toast.makeText(this, "Record not changed...", Toast.LENGTH_SHORT).show()
            return
        }
        if(user == null) return

        val user = User(id = user!!.id, name = name, age = age)
        val status = sqLiteHelper.updateUser(user)
        if(status >-1){
            clearEditText()
            getUsers()
        }else{
            Toast.makeText(this,"Update failed", Toast.LENGTH_SHORT).show()
        }
    }
    private fun deleteUser(id:Int){
        if(id==null) return

        val builder = AlertDialog.Builder(this)
        builder.setMessage("Are you sure you want to delete this item?")
        builder.setCancelable(true)
        builder.setPositiveButton("Yes"){dialog, _->
            sqLiteHelper.deleteUser(id)
            getUsers()
            dialog.dismiss()
        }
        builder.setNegativeButton("No"){ dialog, _->
            dialog.dismiss()
        }
        val alert = builder.create()
        alert.show()
    }
    private fun clearEditText(){
        edName.setText("")
        edAge.setText("")
        edName.requestFocus()
    }
    private fun initRecyclerView(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = UserAdapter()
        recyclerView.adapter = adapter
    }

    private fun initView(){
        edName = findViewById(R.id.edName)
        edAge = findViewById(R.id.edAge)
        btnAdd = findViewById(R.id.btnAdd)
        btnView = findViewById(R.id.btnView)
        btnUpdate = findViewById(R.id.btnUpdate)
        recyclerView = findViewById(R.id.recyclerView)
    }
}
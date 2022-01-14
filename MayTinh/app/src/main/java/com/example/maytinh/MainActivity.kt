package com.example.maytinh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        buttoncong.setOnClickListener(){
            var num1 : Double = (editTextNum1.text.toString()).toDouble()
            var num2 :  Double = (editTextNum2.text.toString()).toDouble()
            textResult.text = (num1+num2).toString()

        }
        buttontru.setOnClickListener(){
            var num1 : Double = (editTextNum1.text.toString()).toDouble()
            var num2 :  Double = (editTextNum2.text.toString()).toDouble()
                textResult.text = (num1-num2).toString()
            }


    }
}
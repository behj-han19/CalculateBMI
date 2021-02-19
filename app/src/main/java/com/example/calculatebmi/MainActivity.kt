package com.example.calculatebmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEnter:Button = findViewById(R.id.btn_enter)

        btnEnter.setOnClickListener(){

            val enter_name = findViewById<TextView>(R.id.enter_name)

            val intent = Intent(this, BMIActivity::class.java)

            intent.putExtra("personName", enter_name.text.toString())

            startActivity(intent);
        }
    }
}
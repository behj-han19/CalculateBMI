package com.example.calculatebmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class BMIActivity : AppCompatActivity() {
    var bmiIndex: Double = 0.00

    // Instance state will store to here
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b_m_i)

        //Display name
        val getName = findViewById<TextView>(R.id.getName)

        val personName = intent?.getStringExtra("personName")

        getName.setText(personName)

        if(savedInstanceState!=null){
            bmiIndex = savedInstanceState.getDouble("bmi")

            //Restore Data and status
            val tvstatus = findViewById<TextView>(R.id.tvstatus)
            tvstatus.setText(getStatus())
        }


        val btnCal = findViewById<Button>(R.id.btn_calculate)

        btnCal.setOnClickListener(){
            // Cannot put as View as View included button, ....
            val weight = findViewById<TextView>(R.id.tfweight).text.toString()
            val height = findViewById<TextView>(R.id.tfheight).text.toString()

            bmiIndex = weight.toDouble() /(height.toDouble() * height.toDouble())

            val tvstatus = findViewById<TextView>(R.id.tvstatus)
            tvstatus.setText(getStatus())
        }
    }

    //Lifecycle avoid rotate screen data destroy
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("bmi", bmiIndex)
    }


    fun getStatus():String{
        if(bmiIndex < 18.5)
            return "UnderWeight"
        else if (bmiIndex in 18.5..24.9)
            return "Normal Weight"
        else if (bmiIndex in 25.0..29.9 )
            return "OverWeight"
        else if (bmiIndex in 30.0..34.9 )
            return "Obesity Class I"
        else if (bmiIndex in 35.0..39.9)
            return "Obesity Class II"
        else
            return "Obesity Class III"
    }
}
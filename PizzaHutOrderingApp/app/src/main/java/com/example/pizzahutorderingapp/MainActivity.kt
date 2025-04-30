package com.example.pizzahutorderingapp

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)



        val chkOlives = findViewById<CheckBox>(R.id.chkOlives)
        val chkCheese = findViewById<CheckBox>(R.id.chkCheese)
        val btnCalculate = findViewById<Button>(R.id.btnCompute)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val txtResults = findViewById<TextView>(R.id.txtResults)
        val rbSmall = findViewById<RadioButton>(R.id.rbSmall)
        val rbMedium = findViewById<RadioButton>(R.id.rbMedium)
        val rbLarge = findViewById<RadioButton>(R.id.rbLarge)
        val rbGroup = findViewById<RadioGroup>(R.id.radioGroups)


        btnClear.visibility = Button.GONE

        btnCalculate.setBackgroundColor(Color.parseColor("#FF7043"))
        btnClear.setBackgroundColor(Color.RED)


        btnCalculate.setOnClickListener {


            var total= 0.0

            if (rbSmall.isChecked)
            {
                total+= 55.99
            }
            else if(rbMedium.isChecked)
            {
                total += 89.99
            }
            else if(rbLarge.isChecked)
            {
                total+= 119.99
            }


            if (chkCheese.isChecked)
            {
                total+= 5.50
            }
            if (chkOlives.isChecked)
            {
                total+= 3.50
            }

            txtResults.text = String.format("Total Amount Due: R%.2f", total)

            btnCalculate.visibility = Button.GONE
            btnClear.visibility = Button.VISIBLE

        }


        btnClear.setOnClickListener {

            txtResults.text= " "

            chkCheese.isChecked = false
            chkOlives.isChecked = false
            rbGroup.clearCheck()

            btnClear.visibility = Button.GONE
            btnCalculate.visibility = Button.VISIBLE


        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

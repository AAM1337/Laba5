package com.example.laba5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var btn: Button
    private lateinit var price: EditText
    private lateinit var radioButton1: RadioButton
    private lateinit var radioButton2: RadioButton
    private lateinit var radioButton3: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        radioButton1=findViewById(R.id.radioButton)
        radioButton2=findViewById(R.id.radioButton2)
        radioButton3=findViewById(R.id.radioButton3)
        price=findViewById(R.id.editTextNumberDecimal)
        btn=findViewById(R.id.button)

        btn.setOnClickListener()
        {
            val intent=Intent(this,SecondActivity::class.java)
            when{
                radioButton1.isChecked->intent.putExtra("Selected_Radio","RadioButton1")
                radioButton2.isChecked->intent.putExtra("Selected_Radio","RadioButton2")
                radioButton3.isChecked->intent.putExtra("Selected_Radio","RadioButton3")
            }
            intent.putExtra("Price",price.text.toString())
            startActivity(intent)
        }

    }
}
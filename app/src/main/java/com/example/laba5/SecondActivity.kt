package com.example.laba5

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {

    private lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        val Selected_Radio = intent.getStringExtra("Selected_Radio")
        val priceValue = intent.getStringExtra("Price")?.toDoubleOrNull() ?: 0.0

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        text=findViewById(R.id.textView4)
        var result:Double=0.0
        when(Selected_Radio){
            "RadioButton1"->{
                result=priceValue*75
            }
            "RadioButton2"->{
                result=priceValue*90
            }
            "RadioButton3"->{
                result=priceValue*100
            }
        }
        text.text=result.toString()
    }
}
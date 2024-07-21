package com.example.currencyconverterapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var inputUsd: EditText
    private lateinit var outputVnd: TextView
    private lateinit var makeConvertBtn: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        inputUsd = findViewById(R.id.inputUsd)
        outputVnd = findViewById(R.id.outputVnd)
        makeConvertBtn = findViewById(R.id.makeConvertBtn)

        makeConvertBtn.setOnClickListener {
            val usdDouble = inputUsd.text.toString().toDouble()
            val vndDouble = makeConvertUsdToVnd(usdDouble)
            outputVnd.text = "$vndDouble VND"
        }
    }

    private fun makeConvertUsdToVnd(usd: Double): Double = usd * 25.315
}
package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        btnAdd.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    CalculateResult::class.java
                ).putExtra(CalculateResult.OPERATION, btnAdd.text.toString())
            )
        }

        val btnSubtract = findViewById<Button>(R.id.btnSubtract)
        btnSubtract.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    CalculateResult::class.java
                ).putExtra(CalculateResult.OPERATION, btnSubtract.text.toString())
            )
        }

        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        btnMultiply.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    CalculateResult::class.java
                ).putExtra(CalculateResult.OPERATION, btnMultiply.text.toString())
            )
        }

        val btnDivide = findViewById<Button>(R.id.btnDivide)
        btnDivide.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    CalculateResult::class.java
                ).putExtra(CalculateResult.OPERATION, btnDivide.text.toString())
            )
        }

    }
}
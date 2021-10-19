package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CalculateResult : AppCompatActivity() {

    companion object {
        const val OPERATION = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate_result)

        val getSelectedOperation = intent.getStringExtra(OPERATION).toString()

        val btnPerformCalculation = findViewById<Button>(R.id.performCalculation)
        when(getSelectedOperation){
            "Add" -> btnPerformCalculation.text = "Perform Addition"
            "Subtract" -> btnPerformCalculation.text = "Perform Subtraction"
            "Multiply" -> btnPerformCalculation.text = "Perform Multiplication"
            "Divide" -> btnPerformCalculation.text = "Perform Division"
        }
    }
}
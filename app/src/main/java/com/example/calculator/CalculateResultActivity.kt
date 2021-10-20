package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.calculator.CalculatorOperations.*

class CalculateResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate_result)

        // getSelectedOperation: variable to get the selected operation from MainActivity
        val selectedOperation = intent.getStringExtra(OPERATION_NAME).toString()

        // btnPerformCalculation: Dynamically set text on this button on the basis of operation selected
        val btnPerformCalculation = findViewById<Button>(R.id.performCalculation)

        btnPerformCalculation.text = getBtnText(selectedOperation)
    }

    // function to set the button text as to which operation has to be performed
    private fun getBtnText(operation: String) = "PERFORM $operation"
}
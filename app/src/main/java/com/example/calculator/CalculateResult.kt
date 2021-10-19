package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CalculateResult : AppCompatActivity() {

    companion object {
        // OPERATION_NAME: a constant variable for holding the selected operation by the user
        const val OPERATION_NAME = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate_result)

        // getSelectedOperation: variable to get the selected operation from MainActivity
        val getSelectedOperation = intent.getStringExtra(OPERATION_NAME).toString()

        // btnPerformCalculation: Dynamically set text on this button on the basis of operation selected
        val btnPerformCalculation = findViewById<Button>(R.id.performCalculation)

        // using when block to set text on the performCalculation(id) button in activity_calculate_result.xml
        when (getSelectedOperation) {
            CalculatorOperations.ADDITION.toString() -> btnPerformCalculation.text =
                "PERFORM " + CalculatorOperations.ADDITION.toString()
            CalculatorOperations.SUBTRACTION.toString() -> btnPerformCalculation.text =
                "PERFORM " + CalculatorOperations.SUBTRACTION.toString()
            CalculatorOperations.MULTIPLICATION.toString() -> btnPerformCalculation.text =
                "PERFORM " + CalculatorOperations.MULTIPLICATION.toString()
            CalculatorOperations.DIVISION.toString() -> btnPerformCalculation.text =
                "PERFORM " + CalculatorOperations.DIVISION.toString()
        }
    }
}
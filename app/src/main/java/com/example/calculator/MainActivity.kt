package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialising Intent
        val intent = Intent(this, CalculateResult::class.java)

        // fetching button from activity_main.xml
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        // set text on button programatically
        btnAdd.text = CalculatorOperations.ADDITION.toString()
        // add functionality for clicking the button
        btnAdd.setOnClickListener {
            startActivityForSelectedOperation(
                intent,
                CalculateResult.OPERATION_NAME,
                CalculatorOperations.ADDITION.toString()
            )
        }

        // fetching button from activity_main.xml
        val btnSubtract = findViewById<Button>(R.id.btnSubtract)
        // set text on button programatically
        btnSubtract.text = CalculatorOperations.SUBTRACTION.toString()
        // add functionality for clicking the button
        btnSubtract.setOnClickListener {
            startActivityForSelectedOperation(
                intent,
                CalculateResult.OPERATION_NAME,
                CalculatorOperations.SUBTRACTION.toString()
            )
        }

        // fetching button from activity_main.xml
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        // set text on button programatically
        btnMultiply.text = CalculatorOperations.MULTIPLICATION.toString()
        // add functionality for clicking the button
        btnMultiply.setOnClickListener {
            startActivityForSelectedOperation(
                intent,
                CalculateResult.OPERATION_NAME,
                CalculatorOperations.MULTIPLICATION.toString()
            )
        }

        // fetching button from activity_main.xml
        val btnDivide = findViewById<Button>(R.id.btnDivide)
        // set text on button programatically
        btnDivide.text = CalculatorOperations.DIVISION.toString()
        // add functionality for clicking the button
        btnDivide.setOnClickListener {
            startActivityForSelectedOperation(
                intent,
                CalculateResult.OPERATION_NAME,
                CalculatorOperations.DIVISION.toString()
            )
        }

    }

    // helper function to start next activity and modify content on the basis of selected operation
    // startActivityForSelectedOperation function takes three arguments - intent, operationToBePerformed, and btnText
    fun startActivityForSelectedOperation(
        intent: Intent,
        operationToBePerformed: String,
        btnText: String
    ) {
        // startActivity function to start the activity
        startActivity(intent.putExtra(operationToBePerformed, btnText))
    }
}
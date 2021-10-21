package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.calculator.CalculatorOperations.*

// Activity to input two numbers and perform calculation upon clicking a button
class CalculateResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate_result)

        // getSelectedOperation: variable to get the selected operation from MainActivity
        val selectedOperation = intent.getStringExtra(OPERATION_NAME).toString()

        // btnPerformCalculation: Dynamically set text on this button on the basis of operation selected
        val btnPerformCalculation = findViewById<Button>(R.id.performCalculation)

        // set the text on button according to operation selected
        btnPerformCalculation.text = getBtnText(selectedOperation)

        // fetch values from EditText and perform calculation on button click
        btnPerformCalculation.setOnClickListener {
            val firstNumber = findViewById<EditText>(R.id.firstNumber).text.toString().toInt()
            val secondNumber = findViewById<EditText>(R.id.secondNumber).text.toString().toInt()
            findViewById<TextView>(R.id.displayResult).text =
                getCalculatedResult(selectedOperation, firstNumber, secondNumber)
        }
    }

    // function to set the button text as to which operation has to be performed
    private inline fun getBtnText(operation: String) = "PERFORM $operation"

    /*  function to calculate the final result based on operation selected
        takes three arguments - operation, firstNumber, secondNumber
        default values for two numbers given as zero
    */
    private fun getCalculatedResult(
        operation: String,
        firstNumber: Int = 0,
        secondNumber: Int = 0
    ): String {

        // variable to store the final result value initialized by zero
        var resultValue = 0

        // when block to perform the specified operation
        when (operation) {
            ADDITION.operation -> resultValue = firstNumber + secondNumber
            SUBTRACTION.operation -> resultValue = firstNumber - secondNumber
            MULTIPLICATION.operation -> resultValue = firstNumber * secondNumber
            DIVISION.operation -> try {             // exception handling for division by zero
                resultValue = firstNumber / secondNumber
            } catch (e: ArithmeticException) {
                return "Division is not possible"
            }
        }

        // returning the result string that consists of operation name and calculated result
        return "$operation is $resultValue"
    }

}
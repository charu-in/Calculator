package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.calculator.CalculatorOperations.*

// Activity consists of four buttons to perform four different types of arithmetic operations (Addition, Subtraction, Multiplication, and Division)
class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // fetching button from activity_main.xml
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        // set text on button programatically
        btnAdd.text = ADDITION.toString()
        // add functionality for clicking the button
        btnAdd.setOnClickListener(this)

        // fetching button from activity_main.xml
        val btnSubtract = findViewById<Button>(R.id.btnSubtract)
        // set text on button programatically
        btnSubtract.text = SUBTRACTION.toString()
        // add functionality for clicking the button
        btnSubtract.setOnClickListener(this)

        // fetching button from activity_main.xml
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        // set text on button programatically
        btnMultiply.text = MULTIPLICATION.toString()
        // add functionality for clicking the button
        btnMultiply.setOnClickListener(this)

        // fetching button from activity_main.xml
        val btnDivide = findViewById<Button>(R.id.btnDivide)
        // set text on button programatically
        btnDivide.text = DIVISION.toString()
        // add functionality for clicking the button
        btnDivide.setOnClickListener(this)

    }

    // overriding onClick method to provide functionality for all four buttons at once
    override fun onClick(btnOperation: View) {

        // Initialising Intent
        val intent = Intent(this, CalculateResultActivity::class.java)

        // when block to navigate to next activity according to the operation selected
        when (btnOperation.id) {  // button id is passed as a parameter to check for operation selected
            R.id.btnAdd -> startActivityForSelectedOperation(
                intent,
                OPERATION_NAME,
                ADDITION.operation
            )
            R.id.btnSubtract -> startActivityForSelectedOperation(
                intent,
                OPERATION_NAME,
                SUBTRACTION.operation
            )
            R.id.btnMultiply -> startActivityForSelectedOperation(
                intent,
                OPERATION_NAME,
                MULTIPLICATION.operation
            )
            R.id.btnDivide -> startActivityForSelectedOperation(
                intent,
                OPERATION_NAME,
                DIVISION.operation
            )
        }
    }

    /* helper function to start next activity and modify content on the basis of selected operation
       startActivityForSelectedOperation function takes three arguments - intent, operationToBePerformed, and btnText
    */
    private fun startActivityForSelectedOperation(
        intent: Intent,
        operationToBePerformed: String,
        btnText: String
    ) {
        // startActivity function to start the activity
        startActivity(intent.putExtra(operationToBePerformed, btnText))
    }
}
package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import com.example.calculator.fragments.OperationsFragment

// Activity consists of four buttons to perform four different types of arithmetic operations (Addition, Subtraction, Multiplication, and Division)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // checking if activity has an extra fragment container, set isDualPaneActivity value to true
        val calculateFromInput = findViewById<FrameLayout>(R.id.calculateFromInput)
        isDualPaneActivity = calculateFromInput?.visibility == View.VISIBLE

    }
}
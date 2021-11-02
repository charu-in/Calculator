package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculator.fragments.OperationsFragment

// Activity consists of four buttons to perform four different types of arithmetic operations (Addition, Subtraction, Multiplication, and Division)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // setting a fragment in frame layout as soon as activity is launched
        supportFragmentManager.beginTransaction().add(R.id.mainFragmentContainer, OperationsFragment()).commit()

    }
}
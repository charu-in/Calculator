package com.example.calculator.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.calculator.CalculatorOperations
import com.example.calculator.OPERATION_NAME
import com.example.calculator.R

/**
 * Fragment to take two numbers as input from user and perform the specified operation
 * Operation name is fetched from a bundle from OperationsFragment
 * Result of calculation is viewed in a TextView
 */
class ResultFragment : Fragment(R.layout.fragment_result) {

    // setting the view of ResultFragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_result, container, false)

        // set the text of button in accordance with value of OPERATION_NAME value from bundle
        view.findViewById<Button>(R.id.performCalculation).text =
            "PERFORM " + this.arguments?.get(OPERATION_NAME).toString()

        // rendering the fragment view
        return view
    }

    // setting functionality of views
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // fetch values from EditText and perform calculation on button click
        view.findViewById<Button>(R.id.performCalculation).setOnClickListener {
            val firstNumber = view.findViewById<EditText>(R.id.firstNumber).text.toString().toInt()
            val secondNumber =
                view.findViewById<EditText>(R.id.secondNumber).text.toString().toInt()

            // set result on a TextView of this fragment
            view.findViewById<TextView>(R.id.displayResult).text =
                getCalculatedResult(
                    this.arguments?.get(OPERATION_NAME).toString(),
                    firstNumber,
                    secondNumber
                )
        }
    }

    /**
     *  function to calculate the final result based on operation selected
     *  takes three arguments - operation, firstNumber, secondNumber
     *  default values for two numbers given as zero
     */
    private fun getCalculatedResult(
        operation: String,
        firstNumber: Int = 0,
        secondNumber: Int = 0
    ): String {

        /**
         * when block to perform the specified operation
         * resultValue variable to store the result of chosen operation
         */
        val resultValue = when (operation) {
            CalculatorOperations.ADDITION.operation -> firstNumber + secondNumber
            CalculatorOperations.SUBTRACTION.operation -> firstNumber - secondNumber
            CalculatorOperations.MULTIPLICATION.operation -> firstNumber * secondNumber
            CalculatorOperations.DIVISION.operation -> try {   // exception handling for division by zero
                firstNumber / secondNumber
            } catch (e: ArithmeticException) {
                return "Division is not possible"
            }
            else -> 0
        }

        // returning the result string that consists of operation name and calculated result
        return "$operation is $resultValue"
    }
}
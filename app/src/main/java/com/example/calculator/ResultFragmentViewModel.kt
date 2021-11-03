package com.example.calculator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultFragmentViewModel: ViewModel() {

    // create live data for storing result of calculation
    val resultData: MutableLiveData<String> = MutableLiveData()

    /**
     *  function to calculate the final result based on operation selected
     *  takes three arguments - operation, firstNumber, secondNumber
     *  default values for two numbers given as zero
     */
    fun getCalculatedResult(
        operation: String,
        firstNumber: Int = 0,
        secondNumber: Int = 0
    ) {

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
                resultData.postValue( "Division is not possible")
            }
            else -> 0
        }

        // setting value for live data
        resultData.postValue("$operation is $resultValue")
    }
}
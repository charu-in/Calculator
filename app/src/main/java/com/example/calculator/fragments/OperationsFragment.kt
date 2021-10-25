package com.example.calculator.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.calculator.CalculatorOperations.*
import com.example.calculator.OPERATION_NAME
import com.example.calculator.R

// Fragment to display the available operations for calculator app (addition, subtraction, multiplication, and division)
class OperationsFragment : Fragment(R.layout.fragment_operations), View.OnClickListener {

    // setting the view of OperationFragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_operations, container, false)

        // fetching button from activity_main.xml and setting the text for addition operation
        view.findViewById<Button>(R.id.btnAdd).text = ADDITION.toString()

        // fetching button from activity_main.xml and setting the text for subtraction operation
        view.findViewById<Button>(R.id.btnSubtract).text = SUBTRACTION.toString()

        // fetching button from activity_main.xml and setting the text for multiplication operation
        view.findViewById<Button>(R.id.btnMultiply).text = MULTIPLICATION.toString()

        // fetching button from activity_main.xml and setting the text for division operation
        view.findViewById<Button>(R.id.btnDivide).text = DIVISION.toString()

        // rendering the fragment view
        return view
    }

    // setting functionality of views
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // on-click functionality for clicking the add button
        view.findViewById<Button>(R.id.btnAdd).setOnClickListener(this)

        // on-click functionality for clicking the subtract button
        view.findViewById<Button>(R.id.btnSubtract).setOnClickListener(this)

        // on-click functionality for clicking the multiply button
        view.findViewById<Button>(R.id.btnMultiply).setOnClickListener(this)

        // on-click functionality for clicking the division button
        view.findViewById<Button>(R.id.btnDivide).setOnClickListener(this)
    }

    // overriding onClick method to provide functionality for all four buttons at once
    override fun onClick(btnOperation: View) {

        // when block to navigate to next activity according to the operation selected
        when (btnOperation.id) {  // button id is passed as a parameter to check for operation selected
            R.id.btnAdd -> startActivityForSelectedOperation(
                ADDITION.operation
            )
            R.id.btnSubtract -> startActivityForSelectedOperation(
                SUBTRACTION.operation
            )
            R.id.btnMultiply -> startActivityForSelectedOperation(
                MULTIPLICATION.operation
            )
            R.id.btnDivide -> startActivityForSelectedOperation(
                DIVISION.operation
            )
        }
    }

    /**
     * helper function to start next activity and modify content on the basis of selected operation
     * startActivityForSelectedOperation function takes three arguments - intent, operationToBePerformed, and btnText
     */
    private fun startActivityForSelectedOperation(
        btnText: String
    ) {
        // initialise a bundle
        val bundle = Bundle()

        // set the operation name value considering which button is clicked
        bundle.putString(OPERATION_NAME, btnText)

        // making a fragment instance of a new fragment called ResultFragment
        val fragment = ResultFragment()

        // setting the arguments of new fragment to current bundle that holds the name of operation to be performed
        fragment.arguments = bundle

        // use apply operator for fragmentTransaction
        fragmentManager?.beginTransaction()?.apply {
            this.replace(
                R.id.mainFragmentContainer,
                fragment
            )      // view this fragment in the fragment container on the activity
            this.addToBackStack("operationsFragment")       // add fragment to back stack when back button is pressed on the device
            this.commit()
        }
    }
}
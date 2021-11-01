package com.example.calculator.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.calculator.CalculatorOperations.*
import com.example.calculator.OPERATION_NAME
import com.example.calculator.R
import com.example.calculator.isDualPaneActivity

// Fragment to display the available operations for calculator app (addition, subtraction, multiplication, and division)
class OperationsFragment : Fragment(R.layout.fragment_operations), View.OnClickListener {

    // initialize NavController
    lateinit var navController: NavController

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
        navController = Navigation.findNavController(view)

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

        // when block to get the operation selected
        val operationSelected = when (btnOperation.id) {  // button id is passed as a parameter to check for operation selected
            R.id.btnAdd ->
                ADDITION.operation
            R.id.btnSubtract ->
                SUBTRACTION.operation
            R.id.btnMultiply ->
                MULTIPLICATION.operation
            R.id.btnDivide ->
                DIVISION.operation
            else -> "None"
        }

        // pass the operation name as an argument to the action on navigation to ResultFragment
        val action = OperationsFragmentDirections.actionOperationsFragmentToResultFragment(operationSelected)
        navController?.navigate(action)
    }

    /**
     * helper function to start next activity and modify content on the basis of selected operation
     * startActivityForSelectedOperation function takes one arguments -  btnText
     */
    private fun startActivityForSelectedOperation(
        btnText: String
    ) {
        // initialise a bundle
        val bundle = Bundle()

        // set the operation name value considering which button is clicked
        bundle.putString(OPERATION_NAME, btnText)

        // making a fragment instance of a new fragment called ResultFragment
        val fragment = ResultFragment().apply {
            arguments = bundle      // setting the arguments of new fragment to current bundle that holds the name of operation to be performed
        }

        // use apply operator for fragmentTransaction
        fragmentManager?.beginTransaction()?.apply {
            replace(
                // check if dual panes are involved for tab view
                if (isDualPaneActivity) R.id.calculateFromInput else R.id.mainFragmentContainer,
                fragment
            )      // view this fragment in the fragment container on the activity
            if(!isDualPaneActivity) addToBackStack("operationsFragment")       // add fragment to back stack when back button is pressed on the device
            commit()
        }
    }
}
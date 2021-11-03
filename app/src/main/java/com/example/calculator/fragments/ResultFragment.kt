package com.example.calculator.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.calculator.R
import com.example.calculator.ResultFragmentViewModel

/**
 * Fragment to take two numbers as input from user and perform the specified operation
 * Operation name is fetched from a bundle from OperationsFragment
 * Result of calculation is viewed in a TextView
 */
class ResultFragment : Fragment(R.layout.fragment_result) {

    // initialize arguments to be received from OperationsFragment
    val args: ResultFragmentArgs by navArgs()

    lateinit var resultFragmentViewModel: ResultFragmentViewModel

    // setting the view of ResultFragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_result, container, false)

        // create member variable for ResultFragmentViewModel
        resultFragmentViewModel = ViewModelProvider(this)[ResultFragmentViewModel::class.java]

        // set the text of button in accordance with value of OPERATION_NAME value from bundle
        view.findViewById<Button>(R.id.performCalculation).text =
            "PERFORM " + args.operationSelected

        // rendering the fragment view
        return view
    }

    // setting functionality of views
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners(view)
        subscribeObservers(view)
    }

    /**
     * set the on-click functionality for performCalculation button
     *
     * @param view
     */
    private fun initListeners(view: View) {
        // fetch values from EditText and perform calculation on button click
        view.findViewById<Button>(R.id.performCalculation).setOnClickListener {
            val firstNumber = view.findViewById<EditText>(R.id.firstNumber).text.toString().toInt()
            val secondNumber =
                view.findViewById<EditText>(R.id.secondNumber).text.toString().toInt()

            // set result on a TextView of this fragment
            resultFragmentViewModel.getCalculatedResult(
                    args.operationSelected,
                    firstNumber,
                    secondNumber
                )
        }
    }

    /**
     * subscribing the observers, the updated value will be reflected from ResultFragmentViewModel
     * creating a channel between the observable(resultData) and the observer(ResultFragment)
     *
     * @param view
     */
    private fun subscribeObservers(view: View) {
        // viewLifecycleOwner takes into account the lifecycle owner of a viewModel
        resultFragmentViewModel.resultData.observe(viewLifecycleOwner, { result ->
            result?.let { validResult ->
                // set the text on TextView even after fragment goes through lifecycle changes
                view.findViewById<TextView>(R.id.displayResult).text = validResult
            }
        })
    }
}
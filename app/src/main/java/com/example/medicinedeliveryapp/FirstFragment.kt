package com.example.medicinedeliveryapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    var showCountTextView: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        val fragmentFirstLayout: View = inflater.inflate(R.layout.fragment_first, container, false)
        // Get the count text view
        // Get the count text view
        showCountTextView = fragmentFirstLayout.findViewById(R.id.textview_first)

        return fragmentFirstLayout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.random_button).setOnClickListener(View.OnClickListener {
            val currentCount = showCountTextView!!.text.toString().toInt()
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount)
            NavHostFragment.findNavController(this@FirstFragment).navigate(action)
        })

        view.findViewById<Button>(R.id.toast_button).setOnClickListener(View.OnClickListener {
            val myToast = Toast.makeText(activity, "Hello toast!", Toast.LENGTH_SHORT)
            myToast.show()
        })

        view.findViewById<Button>(R.id.count_button)
            .setOnClickListener(View.OnClickListener { view -> countMe(view) })
    }

    private fun countMe(view: View) {
        // Get the value of the text view
        val countString: String = showCountTextView?.getText().toString()
        // Convert value to a number and increment it
        var count = countString.toInt()
        count++
        // Display the new value in the text view.
        showCountTextView?.setText(count.toString())
    }
}
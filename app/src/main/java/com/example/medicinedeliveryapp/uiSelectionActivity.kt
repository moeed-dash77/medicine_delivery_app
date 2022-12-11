package com.example.medicinedeliveryapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class uiSelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ui_selection)

        var button_pharm: Button = findViewById(R.id.action_uipharmaceutical)
        var button_consum: Button = findViewById(R.id.action_uiconsumer)

        //eventHandler for pharmaceutical button
        button_pharm.setOnClickListener ( object : View.OnClickListener {
            override fun onClick(view: View?) {
                // Code here executes on main thread after user presses button
                startActivity(Intent(this@uiSelectionActivity, PharmaceuticalActivity::class.java))
            }
        })

        //eventHandler for consumer button
        button_consum.setOnClickListener( object : View.OnClickListener {
            override fun onClick(view: View?){
                startActivity(Intent(this@uiSelectionActivity, PharmaceuticalActivity::class.java))
            }
        })

    }

}
package com.example.medicinedeliveryapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity(){
    companion object{
        private const val SPLASH_SCREEN_TIMEOUT = 2000
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.splash_activity)

        val fadeOut: Animation = AlphaAnimation(1.toFloat(), 0.toFloat())
        fadeOut.interpolator = AccelerateInterpolator()
        fadeOut.startOffset = 500
        fadeOut.duration = 1800
        val image = findViewById<ImageView>(R.id.imageView)
        image.animation = fadeOut
        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, uiSelectionActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_SCREEN_TIMEOUT.toLong())

    }



}
package com.example.notes_app.presentation  // use your actual package name

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.appsv.notesappwithnodejs.R
import com.example.notes_app.presentation.main_activity.MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set your custom layout
        setContentView(R.layout.activity_splash)

        // Delay and move to MainActivity
        window.decorView.postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 1500) // Delay in milliseconds (1.5 seconds)
    }
}

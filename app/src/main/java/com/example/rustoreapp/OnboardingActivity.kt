package com.example.rustoreapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class OnboardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val prefs = getSharedPreferences("app", MODE_PRIVATE)
        if (prefs.getBoolean("onboarding_shown", false)) {
            startActivity(Intent(this, ShowcaseActivity::class.java))
            finish()
            return
        }

        setContentView(R.layout.activity_onboarding)

        findViewById<Button>(R.id.btnStart).setOnClickListener {
            prefs.edit().putBoolean("onboarding_shown", true).apply()
            startActivity(Intent(this, ShowcaseActivity::class.java))
            finish()
        }
    }
}
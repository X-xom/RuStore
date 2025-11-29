package com.example.rustoreapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class ScreenshotsActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: ScreenshotAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screenshots)

        val screenshots = intent.getIntArrayExtra("screenshots") ?: intArrayOf()
        val currentPosition = intent.getIntExtra("current_position", 0)

        viewPager = findViewById(R.id.viewPager)
        adapter = ScreenshotAdapter(screenshots.toList())
        viewPager.adapter = adapter
        viewPager.currentItem = currentPosition

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            finish()
        }
    }
}
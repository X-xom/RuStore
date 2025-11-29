package com.example.rustoreapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class AppDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_detail)

        val app = intent.getSerializableExtra("app") as AppModel

        val iconView = findViewById<ImageView>(R.id.ivAppIcon)
        iconView.setImageResource(app.iconResId)

        findViewById<TextView>(R.id.tvAppName).text = app.name
        findViewById<TextView>(R.id.tvDeveloper).text = "Разработчик: ${app.developer}"
        findViewById<TextView>(R.id.tvCategory).text = "Категория: ${app.category}"
        findViewById<TextView>(R.id.tvAgeRating).text = "Рейтинг: ${app.ageRating}"
        findViewById<TextView>(R.id.tvDescription).text = app.fullDescription

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            finish()
        }

        // Горизонтальный список скриншотов
        val screenshotsLayout = findViewById<LinearLayout>(R.id.screenshotsLayout)
        screenshotsLayout.removeAllViews()

        app.screenshotsResIds.forEachIndexed { index, screenshotResId ->
            val imageView = ImageView(this).apply {
                setImageResource(screenshotResId)
                // Подбираем размер чтобы скриншоты полностью помещались
                layoutParams = LinearLayout.LayoutParams(250, 400).apply {
                    marginEnd = 16
                }
                scaleType = ImageView.ScaleType.FIT_CENTER // Изменили на FIT_CENTER
                adjustViewBounds = true // Сохраняем пропорции

                setOnClickListener {
                    val intent = Intent(this@AppDetailActivity, ScreenshotsActivity::class.java)
                    intent.putExtra("screenshots", app.screenshotsResIds.toIntArray())
                    intent.putExtra("current_position", index)
                    startActivity(intent)
                }
            }
            screenshotsLayout.addView(imageView)
        }
    }
}
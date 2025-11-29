package com.example.rustoreapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ShowcaseActivity : AppCompatActivity() {

    private val apps = listOf(
        AppModel(
            "СберБанк",
            "Сбербанк России",
            "Банковские услуги и платежи",
            "Полный контроль над вашими финансами. Переводы, платежи, кредиты и инвестиции в одном приложении.",
            "Финансы",
            "6+",
            R.drawable.icon_sber,
            listOf(R.drawable.screenshot1, R.drawable.screenshot2, R.drawable.screenshot3)
        ),
        AppModel(
            "Госуслуги",
            "Минцифры России",
            "Государственные услуги онлайн",
            "Получение государственных и муниципальных услуг в электронной форме.",
            "Государственные",
            "0+",
            R.drawable.icon_gosuslugi,
            listOf(R.drawable.screenshot4, R.drawable.screenshot5, R.drawable.screenshot6)
        ),
        AppModel(
            "Яндекс Метро",
            "Яндекс",
            "Карта метро и построение маршрутов",
            "Приложение для построения маршрутов в метро с расчетом времени и стоимости поездки.",
            "Транспорт",
            "0+",
            R.drawable.icon_metro,
            listOf(R.drawable.screenshot7, R.drawable.screenshot8, R.drawable.screenshot9)
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showcase)

        val listView = findViewById<ListView>(R.id.appsList)
        listView.adapter = AppAdapter(this, apps)

        listView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, AppDetailActivity::class.java)
            intent.putExtra("app", apps[position])
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnCategories).setOnClickListener {
            val categories = arrayOf("Финансы", "Инструменты", "Игры", "Государственные", "Транспорт")
            android.app.AlertDialog.Builder(this)
                .setTitle("Категории")
                .setItems(categories) { _, _ -> }
                .show()
        }
    }
}
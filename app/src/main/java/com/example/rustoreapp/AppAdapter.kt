package com.example.rustoreapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class AppAdapter(
    private val context: android.content.Context,
    private val apps: List<AppModel>
) : ArrayAdapter<AppModel>(context, R.layout.item_app, apps) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_app, parent, false)

        val app = apps[position]

        val iconView = view.findViewById<ImageView>(R.id.ivAppIcon)
        val nameView = view.findViewById<TextView>(R.id.tvAppName)
        val descView = view.findViewById<TextView>(R.id.tvAppDescription)
        val categoryView = view.findViewById<TextView>(R.id.tvAppCategory)

        iconView.setImageResource(app.iconResId)
        nameView.text = app.name
        descView.text = app.description
        categoryView.text = app.category

        return view
    }
}
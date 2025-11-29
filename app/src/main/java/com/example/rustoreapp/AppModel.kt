package com.example.rustoreapp

import java.io.Serializable

data class AppModel(
    val name: String,
    val developer: String,
    val description: String,
    val fullDescription: String,
    val category: String,
    val ageRating: String,
    val iconResId: Int,
    val screenshotsResIds: List<Int>
) : Serializable
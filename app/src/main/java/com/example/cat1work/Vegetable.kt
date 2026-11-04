package com.example.cat1work

import java.io.Serializable

data class Vegetable(
    val id: Int,
    val name: String,
    val category: String,
    val price: String,
    val imageResId: Int,
    val description: String
) : Serializable
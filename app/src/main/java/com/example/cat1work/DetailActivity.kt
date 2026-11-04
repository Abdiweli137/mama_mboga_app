package com.example.cat1work

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val toolbar = findViewById<Toolbar>(R.id.toolbarDetail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        @Suppress("DEPRECATION")
        val vegetable = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("EXTRA_VEGETABLE", Vegetable::class.java)
        } else {
            intent.getSerializableExtra("EXTRA_VEGETABLE") as? Vegetable
        }

        if (vegetable == null) {
            Toast.makeText(this, "Product details unavailable", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        val ivDetailImage = findViewById<ImageView>(R.id.ivDetailImage)
        val tvDetailName = findViewById<TextView>(R.id.tvDetailName)
        val tvDetailPrice = findViewById<TextView>(R.id.tvDetailPrice)
        val tvDetailDescription = findViewById<TextView>(R.id.tvDetailDescription)

        ivDetailImage.setImageResource(vegetable.imageResId)
        tvDetailName.text = vegetable.name
        tvDetailPrice.text = vegetable.price
        tvDetailDescription.text = vegetable.description
    }
}
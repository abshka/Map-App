package com.abshka.mapapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonOpenMap: Button = findViewById(R.id.buttonOpenMap)

        buttonOpenMap.setOnClickListener {
            val address = "Санкт-Петербург, Авангардная улица, 16"
            val geoUriString = "geo:0,0?q=${Uri.encode(address)}"
            val geoUri = Uri.parse(geoUriString)
            val mapIntent = Intent(Intent.ACTION_VIEW, geoUri)

            if (mapIntent.resolveActivity(packageManager) != null) {
                val chooser = Intent.createChooser(mapIntent, "Выберите приложение для открытия карты")
                startActivity(chooser)
                Log.d("MainActivity", "Map intent started")
            } else {
                Log.e("MainActivity", "No application can handle map intent")
            }
        }
    }
}
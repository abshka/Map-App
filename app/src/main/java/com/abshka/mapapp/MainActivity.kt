package com.abshka.mapapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonOpenMap: Button = findViewById(R.id.buttonOpenMap)

        buttonOpenMap.setOnClickListener {
            val geoUriString = "geo:0,0?q=Санкт-Петербург, Авангардная улица, 16"
            val geoUri = Uri.parse(geoUriString)
            val mapIntent = Intent(Intent.ACTION_VIEW, geoUri)

            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(mapIntent)
            }
        }
    }
}
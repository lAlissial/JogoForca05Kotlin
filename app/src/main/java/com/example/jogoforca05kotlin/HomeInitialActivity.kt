package com.example.jogoforca05kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class HomeInitialActivity : AppCompatActivity() {
    private lateinit var btStart: Button
    private lateinit var ivHangmansNoose: ImageView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_initial2)

        this.btStart = findViewById(R.id.btStart)
        this.ivHangmansNoose = findViewById(R.id.ivHangmansNoose)

    }
}
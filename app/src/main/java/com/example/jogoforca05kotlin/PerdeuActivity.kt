package com.example.jogoforca05kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class PerdeuActivity : AppCompatActivity() {
    private lateinit var tvPerdeu: TextView
    private lateinit var ivDeath: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perdeu)

        this.tvPerdeu = findViewById(R.id.tvPerdeu)
        this.ivDeath = findViewById(R.id.ivDeath)
    }
}
package com.example.jogoforca05kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class PerdeuActivity : AppCompatActivity() {
    private lateinit var tvPerdeu: TextView
    private lateinit var ivDeath: ImageView
    private lateinit var btTryNovamente: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perdeu)

        this.tvPerdeu = findViewById(R.id.tvPerdeu)
        this.ivDeath = findViewById(R.id.ivDeath)
        this.btTryNovamente = findViewById(R.id.btTryNovamente)

        this.btTryNovamente.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            if (intent.resolveActivity(packageManager) != null ){
                startActivity(intent)
            }
        }
    }

}
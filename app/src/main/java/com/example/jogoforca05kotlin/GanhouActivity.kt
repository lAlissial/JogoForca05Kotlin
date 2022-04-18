package com.example.jogoforca05kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class GanhouActivity : AppCompatActivity() {
    private lateinit var tvGanhou: TextView
    private lateinit var btTentarAgain: Button
    private lateinit var ivEstrelaOne: ImageView
    private lateinit var ivEstrelaTwo: ImageView
    private lateinit var ivEstrelaThree: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ganhou)

        this.tvGanhou = findViewById(R.id.tvGanhou)
        this.ivEstrelaOne = findViewById(R.id.ivEstrelaOne)
        this.ivEstrelaTwo = findViewById(R.id.ivEstrelaTwo)
        this.ivEstrelaThree = findViewById(R.id.ivEstrelaThree)
        this.btTentarAgain = findViewById(R.id.btTentarAgain)


        this.btTentarAgain.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            if (intent.resolveActivity(packageManager) != null ){
                startActivity(intent)
            }
        }
    }




}
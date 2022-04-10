package com.example.jogoforca05kotlin

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var banco: Banco
    private lateinit var jogo: JogoForca05

    private lateinit var tvLayout: TextView
    private lateinit var tvDica: TextView
    private lateinit var tvLetrasJaUtilizadas: TextView
    private lateinit var tvQtdeLetras: TextView
    private lateinit var tvResultado: TextView
    private lateinit var etLetra: EditText
    private lateinit var btJogar: Button
    private lateinit var ivImgForca: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.banco = Banco()
        this.jogo = JogoForca05(this.banco.palavra(),this.banco.dica())

        this.jogo.iniciar()

        this.tvLayout = findViewById(R.id.tvLayout)
        this.tvDica = findViewById(R.id.tvDica)
        this.tvLetrasJaUtilizadas = findViewById(R.id.tvLetrasJaUtilizadas)
        this.tvQtdeLetras = findViewById(R.id.tvQtdeLetras)
        this.etLetra = findViewById(R.id.etLetra)
        this.btJogar = findViewById(R.id.btJogar)
        this.ivImgForca = findViewById(R.id.ivImgForca)
        this.tvResultado = findViewById(R.id.tvResultado)

        this.tvLayout.text = this.jogo.getPalavra().toList().toString().replace("[","").replace("]","").replace(",", " ")
        this.tvDica.text= this.jogo.getDica()
        this.tvLetrasJaUtilizadas.text = this.jogo.getLetrasErradas()
        this.tvQtdeLetras.text = "${this.jogo.getPalavra().length} letras"

        this@MainActivity.ivImgForca.setImageResource(getResources().getIdentifier("hangman01" , "drawable", getPackageName()))

        this.btJogar.setOnClickListener(ClicaBotao())

    }
    inner class ClicaBotao: View.OnClickListener{
        override fun onClick(p0: View?){
            var letra: String
            var penalidade: String
            var res: Resources
            var resID : Number
            var intent: Intent

            letra = this@MainActivity.etLetra.text.toString()

            if (letra.length == 1){
                try {
                    if (jogo.adivinhou(letra)) {
                        this@MainActivity.tvLayout.text = this@MainActivity.jogo.getPalavra().toList().toString().replace("[","").replace("]","").replace(",", " ")

                    } else {
                        res = getResources()
                        penalidade = "hangman0${this@MainActivity.jogo.getErros()+1}"
                        resID= res.getIdentifier(penalidade , "drawable", getPackageName())
                        this@MainActivity.ivImgForca.setImageResource(resID)
                        this@MainActivity.tvLetrasJaUtilizadas.text = this@MainActivity.jogo.getLetrasErradas()
                    }
                } catch (e: Exception) {
                    Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this@MainActivity, "Jogada inválida", Toast.LENGTH_SHORT).show()
            }

            if(jogo.terminou()){
                this@MainActivity.tvLayout.text = this@MainActivity.jogo.getPalavra().toList().toString().replace("[", "").replace("]", "").replace(",", " ")
                this@MainActivity.tvResultado.text = this@MainActivity.jogo.getResultado()
                this@MainActivity.btJogar.isEnabled = false

                if (jogo.getResultado().uppercase().contains("GANHOU")) {
                    intent = Intent(this@MainActivity, GanhouActivity::class.java)
                } else {
                    intent = Intent(this@MainActivity, PerdeuActivity::class.java)
                }
                if (intent.resolveActivity(packageManager) != null ){
                    startActivity(intent)
                }

            }

            this@MainActivity.etLetra.getText().clear()

        }
    }
}
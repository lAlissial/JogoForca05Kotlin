package com.example.jogoforca05kotlin

class JogoForca05(palavra_a_ser_usada: String, dica_da_palavra_a_ser_usada: String) {
    private var dica:String = String()                                                              // dica escolhida
    private var palavra:String = String()                                                           // a palavra escolhida
    private var acertos = 0                                                                         // total de acertos do jogo
    private var erros = 0                                                                           // total de erros do jogo
    private var traco_palavra:StringBuffer = StringBuffer()                                         // guarda as letras descobertas na posição certa
    private var aux_palavra:String? = String()                                                      // guarda as letras que AINDA NÃO foram descobertas da palavra sorteada
    private var guarda_letras_erradas:StringBuffer = StringBuffer()                                 // guardas letras erradas digitadas pelo usuario
    private var letras_distintas = mutableListOf<Char>()                                            // guarda as letras distintas da palavra
    private var penalidades: MutableList<String>

    init{
        this.palavra = palavra_a_ser_usada.trim().uppercase()
        this.dica = dica_da_palavra_a_ser_usada.uppercase()
        this.penalidades = mutableListOf("cabeça","tronco","braço","braço","perna", "perna")
    }

    fun iniciar() {
        for (e in 0 until this.palavra.length) {
            this.traco_palavra.append("_")
        }
        this.aux_palavra = "${this.palavra}"

        this.letras_distintas = this.palavra.toList().distinct() as MutableList<Char>
    }

    @Throws(Exception::class)
    fun adivinhou(letr: String): Boolean {
        var letra = letr.uppercase()
        var padraozito = "[A-Z]".toRegex()

        if (!padraozito.matches(letra)) {
            throw Exception("Digite UMA LETRA!")
        }
        if (this.traco_palavra.toString().contains(letra)) {
            throw Exception("Digite uma letra ainda não informada")
        }
        if (terminou()) {
            throw Exception("Jogo já terminou inicie novamente!")
        }
        if (this.guarda_letras_erradas.toString().contains(letra)) {
            throw Exception("Letra já foi escrita anteriormente")
        }
        if (this.palavra.contains(letra)) {
            for (k in 0 until this.aux_palavra!!.length) {
                if (letra == this.aux_palavra!!.substring(k, k + 1)) {
                    this.acertos++
                    this.traco_palavra = this.traco_palavra.replace(k, k + 1, letra)
                }
            }
            this.aux_palavra = this.aux_palavra!!.replace(letra, "~")
        } else {
            this.erros++
            this.guarda_letras_erradas.append("${letra}-")
        }
        return this.palavra.contains(letra)
    }

    fun terminou(): Boolean {
        return this.acertos == this.palavra.length || this.erros == 6
    }

    fun getPalavra(): String {
        return this.traco_palavra.toString()
    }

    fun getDica(): String {
        return this.dica
    }

    fun getPenalidade():String {
        return this.penalidades[this.erros - 1]
    }

    fun getAcertos():Int {
        return this.acertos
    }

    fun getErros():Int {
        return this.erros
    }

    fun getResultado():String {
        return if (this.acertos == this.palavra.length) {
            "GANHOU O JOGO!"
        } else {
            "VOCÊ FOI ENFORCADO"
        }
    }

    fun getLetrasErradas(): String {
        return guarda_letras_erradas.toString()
    }

    fun getLetrasDistintas(): MutableList<Char> {
        return letras_distintas
    }
}
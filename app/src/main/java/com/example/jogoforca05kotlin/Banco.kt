package com.example.jogoforca05kotlin

class Banco {
    var dicionario_palavras: LinkedHashMap<String, String> = linkedMapOf()
    var guarda_resu_sorteio: String = String()

    init{
        this.preparaDicionario()
        this.sorteia()
    }

    private fun preparaDicionario(){
        this.dicionario_palavras.put("COLA","Gruda as coisas")
        this.dicionario_palavras.put("OBJETO","É uma instância da classe")
        this.dicionario_palavras.put("LIVRARIA","Tem muitos livros")
        this.dicionario_palavras.put("PUDIM","Sobremesa")
        this.dicionario_palavras.put("NAVE","Veiculo também utilizado por aliens")
    }

    fun sorteia(){
        this.guarda_resu_sorteio = this.dicionario_palavras.keys.random()
    }

    fun palavra(): String {
        return this.guarda_resu_sorteio
    }

    fun dica(): String {
        return this.dicionario_palavras.getValue(guarda_resu_sorteio)
    }
}
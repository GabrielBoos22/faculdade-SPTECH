package org.example

class Tributo {
    var tributaveis: MutableList<Tributavel> = mutableListOf()

    fun adicionaTributavel(tributavel: Tributavel){
        tributaveis.add(tributavel)
    }

    fun calculaTotalTributo(){
        var soma = 0.0
        tributaveis.forEach {
            soma += it.getValorTributo()
        }
        println("soma: " + soma)
    }

    fun exibeTodos(){
        tributaveis.forEach {
            println(it)
        }
        println()
    }
}
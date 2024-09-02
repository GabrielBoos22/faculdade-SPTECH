package org.example

class Carrinho {
    var vendaveis: MutableList<Vendavel> = mutableListOf()

    fun adicionaTributavel(vendavel: Vendavel){
        vendaveis.add(vendavel)
    }

    fun calculaTotalTributo(){
        var soma = 0.0
        vendaveis.forEach {
            soma += it.getValorVenda()
        }
        println("soma: " + soma)
    }

    fun exibeTodos(){
        vendaveis.forEach {
            println(it)
        }
        println()
    }
}
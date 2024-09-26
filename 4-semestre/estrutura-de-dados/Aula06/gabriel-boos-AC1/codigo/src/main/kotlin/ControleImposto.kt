package org.example

class ControleImposto {
    private val listaImposto = mutableListOf<Imposto>()

    fun adicionarObjeto(imposto: Imposto) {
        listaImposto.add(imposto)
    }

    fun exibirObjeto() {
        listaImposto.forEach { println(it) }
        println()
    }

    fun calcularTotalImposto(): Double {
        return listaImposto.sumOf { it.getValorImposto() }
    }
}
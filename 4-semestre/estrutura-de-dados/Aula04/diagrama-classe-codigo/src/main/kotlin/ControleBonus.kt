package org.example

class ControleBonus {
    private val bonificaveis = mutableListOf<Bonificavel>()

    fun adicionarBonificavel(bonificavel: Bonificavel) {
        bonificaveis.add(bonificavel)
    }

    fun exibirBonificaveis() {
        bonificaveis.forEach { println(it) }
    }

    fun calcularTotalBonus(): Double {
        return bonificaveis.sumOf { it.getValorBonus() }
    }
}
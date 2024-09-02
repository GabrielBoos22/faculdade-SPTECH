package org.example

class Servico(
    val descricao: String,
    val codigo: Double,
    val quantHoras:Int,
    val valorHora: Double
): Vendavel {
    override fun getValorVenda(): Double {
        return valorHora * quantHoras
    }
    override fun toString(): String {
        return "Servico($descricao, $codigo, $quantHoras, $valorHora)"
    }
}
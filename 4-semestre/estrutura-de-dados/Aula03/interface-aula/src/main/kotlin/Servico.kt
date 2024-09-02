package org.example

class Servico(
    val descricao: String,
    val preco: Double
): Tributavel {
    override fun getValorTributo(): Double {
        return preco * 0.12
    }
    override fun toString(): String {
        return "Servico($descricao, $preco)"
    }
}
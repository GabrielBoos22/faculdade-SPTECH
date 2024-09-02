package org.example

class Dvd(
    codigo: Int,
    precoCusto: Double,
    val nome: String,
    val gravadora: String
): Produto(codigo, precoCusto) {
    override fun getValorVenda(): Double {
        return precoCusto + 0.20 * precoCusto
    }
    override fun toString(): String {
        return "Dvd(codigo = $codigo, precoCusto = $precoCusto, nome = $nome, gravadora = $gravadora)"
    }
}
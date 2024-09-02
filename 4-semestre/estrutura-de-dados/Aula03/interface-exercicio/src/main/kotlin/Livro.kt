package org.example

class Livro(
    codigo: Int,
    precoCusto: Double,
    val nome: String,
    val autor: String,
    val isbn: String
): Produto(codigo, precoCusto) {
    override fun getValorVenda(): Double {
        return precoCusto + 0.10 * precoCusto
    }
    override fun toString(): String {
        return "Livro(codigo = $codigo, precoCusto = $precoCusto, nome = $nome, autor = $autor, isbn = $isbn)"
    }
}
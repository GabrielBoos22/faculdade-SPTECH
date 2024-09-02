package org.example

class Perfume(
    codigo: Int,
    descricao: String,
    preco: Double,
    val fragancia: Double
): Produto(codigo, descricao, preco) {
    override fun getValorTributo(): Double {
        return preco * 0.27
    }
    override fun toString(): String {
        return "Perfume(codigo = $codigo, descricao = $descricao, preco = $preco, fragancia = $fragancia)"
    }
}
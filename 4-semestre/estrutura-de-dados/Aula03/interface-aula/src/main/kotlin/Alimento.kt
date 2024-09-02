package org.example

class Alimento(
    codigo: Int,
    descricao: String,
    preco: Double,
    val quantVitamina: Double
): Produto(codigo, descricao, preco) {
    override fun getValorTributo(): Double {
        return preco * 0.15
    }
    override fun toString(): String {
        return "Alimento(codigo = $codigo, descricao = $descricao, preco = $preco, quantVitamina = $quantVitamina)"
    }
}
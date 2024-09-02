package org.example

abstract class Produto(
    val codigo: Int,
    val descricao: String,
    val preco: Double
): Tributavel {

    override fun toString(): String {
        return "Produto(codigo= $codigo, $descricao, $preco)"
    }
}
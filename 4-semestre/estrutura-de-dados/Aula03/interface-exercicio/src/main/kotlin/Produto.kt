package org.example

abstract class Produto(
    val codigo: Int,
    val precoCusto: Double
): Vendavel {

    override fun toString(): String {
        return "Produto(codigo= $codigo, precoCusto $precoCusto)"
    }
}
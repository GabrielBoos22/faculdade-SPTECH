package org.example

abstract class Brinquedo(
    val codigo: Int,
    val nome: String
): Imposto{
    abstract fun getRenda(): Double

    override fun toString(): String {
        return "Codigo: $codigo, Nome: $nome, Imposto: ${getValorImposto()}"
    }
}
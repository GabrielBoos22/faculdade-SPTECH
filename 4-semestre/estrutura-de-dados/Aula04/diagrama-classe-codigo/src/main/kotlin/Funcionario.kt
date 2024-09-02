package org.example

abstract class Funcionario(
    val cpf: String,
    val nome: String
) {
    abstract fun calculaSalario(): Double

    override fun toString(): String {
        return "CPF: $cpf, Nome: $nome"
    }
}
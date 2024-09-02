package org.example

abstract class Funcionario(
    var cpf: String,
    var nome: String
) {

    abstract fun calcSalario(): Double

    override fun toString(): String {
        return "Funcionário: nome=$nome, cpf=$cpf"
    }

}
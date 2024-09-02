package org.example

abstract class Aluno(
    var ra: String,
    var nome: String,
    var nota1: Double,
    var nota2: Double
) {

    abstract fun calculaMedia(): Double

    override fun toString(): String {
        return "Funcionário: nome=$nome, cpf=$ra, nota1=$nota1, nota2=$nota2"
    }

}
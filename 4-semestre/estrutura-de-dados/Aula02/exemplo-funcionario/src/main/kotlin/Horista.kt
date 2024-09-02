package org.example

class Horista(
    cpf: String,
    nome: String,
    val qtdHora: Int,
    val valorHora: Double
) : Funcionario(cpf, nome){

    override fun calcSalario(): Double {
        return qtdHora * valorHora
    }
    override fun toString(): String {
        return super.toString() + ", salario: ${calcSalario()}"
    }
}
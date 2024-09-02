package org.example

class Engenheiro(
    cpf: String,
    nome: String,
    val salario: Double
) : Funcionario (cpf, nome){
    override fun calcSalario(): Double {
        return salario
    }

    override fun toString(): String {
        return super.toString() + ", salario: $salario"
    }

}
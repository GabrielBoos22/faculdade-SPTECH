package org.example

class Secretaria(
    cpf: String,
    nome: String,
    private val salario: Double,
    private val extra: Double
) : Funcionario(cpf, nome) {

    override fun calculaSalario(): Double {
        return salario + extra
    }

    override fun toString(): String {
        return "${super.toString()}, Salário: ${calculaSalario()}"
    }
}
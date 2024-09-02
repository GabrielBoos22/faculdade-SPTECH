package org.example

class Vendedor(
    cpf: String,
    nome: String,
    val vendas: Double,
    val taxa: Double
) : Funcionario (cpf, nome){
    override fun calcSalario(): Double {
        return vendas * taxa
    }

    override fun toString(): String {
        return super.toString() + ", salario: ${calcSalario()}"
    }

}
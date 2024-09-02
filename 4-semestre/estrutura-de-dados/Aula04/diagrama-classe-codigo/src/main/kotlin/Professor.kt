package org.example

class Professor(
    cpf: String,
    nome: String,
    private val quantidadeAulasPorSemana: Int,
    private val valorHoraAula: Double
) : Funcionario(cpf, nome), Bonificavel {

    override fun calculaSalario(): Double {
        return quantidadeAulasPorSemana * valorHoraAula * 4.5
    }

    override fun getValorBonus(): Double {
        return 0.15 * calculaSalario()
    }

    override fun toString(): String {
        return "${super.toString()}, Salário: ${calculaSalario()}, Bônus: ${getValorBonus()}"
    }
}
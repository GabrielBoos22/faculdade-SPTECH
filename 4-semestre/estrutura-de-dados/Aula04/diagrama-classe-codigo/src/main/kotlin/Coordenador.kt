package org.example

class Coordenador(
    cpf: String,
    nome: String,
    private val quantidadeHorasCoordenacaoPorSemana: Int,
    private val valorHoraCoordenacao: Double,
    private val quantidadeCursosCoordena: Int
) : Funcionario(cpf, nome), Bonificavel {

    override fun calculaSalario(): Double {
        return (quantidadeHorasCoordenacaoPorSemana * valorHoraCoordenacao * 4.5) + (quantidadeCursosCoordena * 500)
    }

    override fun getValorBonus(): Double {
        return 0.20 * calculaSalario()
    }

    override fun toString(): String {
        return "${super.toString()}, Salário: ${calculaSalario()}, Bônus: ${getValorBonus()}"
    }
}
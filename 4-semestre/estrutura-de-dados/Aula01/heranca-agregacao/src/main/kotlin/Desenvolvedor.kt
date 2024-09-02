package org.example

open class Desenvolvedor(
    val nome: String,
    val qtdHorasTrabalhadas: Int,
    val valorHoraTrabalhada: Double) {

    open fun getSalario(): Double{
        return qtdHorasTrabalhadas * valorHoraTrabalhada
    }

    override fun toString(): String {
        return "Desenvolvedor(nome='$nome', qtdHorasTrabalhadas=$qtdHorasTrabalhadas, " +
                "valorHoraTrabalhada=$valorHoraTrabalhada, salario=${getSalario()})"
    }
}
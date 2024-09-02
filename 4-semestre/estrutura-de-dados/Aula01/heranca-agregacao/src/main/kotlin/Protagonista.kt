package org.example

class Protagonista(
    nome: String,
    qtdHorasTrabalhadasProtagonista: Int,
    valorHoraTrabalhadaProtagonista: Double
) : Ator(nome, qtdHorasTrabalhadasProtagonista, valorHoraTrabalhadaProtagonista) {

    override fun getSalario(): Double{
       return super.getSalario() + (this.qtdHorasTrabalhadas * this.valorHoraTrabalhada)
    }

    override fun toString(): String {
        return super.toString()
    }
}
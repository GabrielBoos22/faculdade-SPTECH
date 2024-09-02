package org.example

class DesenvolvedorMobile(
    nome: String,
    qtdHorasTrabalhadasMobile: Int,
    valorHoraTrabalhadaMobile: Double
) : Desenvolvedor(nome, qtdHorasTrabalhadasMobile, valorHoraTrabalhadaMobile) {

    override fun getSalario(): Double{
       return super.getSalario() + (this.qtdHorasTrabalhadas * this.valorHoraTrabalhada)
    }

    override fun toString(): String {
        return super.toString()
    }
}
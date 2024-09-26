package org.example

class BrinquedoAlugado(
    codigo: Int,
    nome: String,
    val qtdHoraAlugada: Int,
    val valorHora: Double
) : Brinquedo(codigo, nome) {

    override fun getRenda(): Double {
        return qtdHoraAlugada * valorHora
    }

    override fun getValorImposto(): Double {
        return getRenda() * 0.13
    }

    override fun toString(): String {
        return "${super.toString()}, qtdHoraAlugada: ${qtdHoraAlugada}, valorHora: ${valorHora}, Renda:${getRenda()}}"
    }
}
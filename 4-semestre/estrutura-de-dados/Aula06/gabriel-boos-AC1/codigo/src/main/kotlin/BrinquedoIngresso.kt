package org.example

class BrinquedoIngresso(
    codigo: Int,
    nome: String,
    val valorIngresso: Double,
    val qtdIngressoVendido: Int
) : Brinquedo(codigo, nome) {

    override fun getRenda(): Double {
        return valorIngresso * qtdIngressoVendido
    }

    override fun getValorImposto(): Double {
        return getRenda() * 0.18
    }

    override fun toString(): String {
        return "${super.toString()}, valorIngresso: ${valorIngresso}, qtdIngressoVendido: ${qtdIngressoVendido}, Renda:${getRenda()}"
    }
}
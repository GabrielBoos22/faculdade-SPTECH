package org.example

class Socio(
    val nome: String,
    private val honorario: Double
) : Imposto {

    override fun getValorImposto(): Double {
        return honorario * 0.24
    }

    override fun toString(): String {
        return "Imposto:${getValorImposto()}, Nome: ${nome}, Honorario: ${honorario}"
    }
}
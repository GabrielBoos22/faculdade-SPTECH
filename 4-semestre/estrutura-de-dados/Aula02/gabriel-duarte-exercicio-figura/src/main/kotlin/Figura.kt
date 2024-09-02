package org.example

abstract class Figura(
    var cor: String,
    var expessura: Int
) {

    abstract fun calculaArea(): Double

    override fun toString(): String {
        return "Figura: cor=$cor, expessura=$expessura"
    }

}
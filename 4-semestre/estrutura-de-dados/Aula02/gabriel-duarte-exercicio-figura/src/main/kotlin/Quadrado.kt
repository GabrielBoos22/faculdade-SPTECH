package org.example

class Quadrado(
    cor: String,
    expessura: Int,
    val lado: Double
) : Figura (cor, expessura){
    override fun calculaArea(): Double {
        return lado * lado
    }

    override fun toString(): String {
        return super.toString() + ", lado: $lado, área: ${calculaArea()}"
    }

}
package org.example

class Triangulo(
    cor: String,
    expessura: Int,
    val base: Double,
    val altura: Double
) : Figura (cor, expessura){
    override fun calculaArea(): Double {
        return (base * altura)/2
    }

    override fun toString(): String {
        return super.toString() + ", lado: $base, área: ${calculaArea()}"
    }

}
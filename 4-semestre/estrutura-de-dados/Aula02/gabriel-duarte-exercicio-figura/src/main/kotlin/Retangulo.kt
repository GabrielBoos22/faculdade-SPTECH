package org.example

class Retangulo(
    cor: String,
    expessura: Int,
    val base: Double,
    val altura: Double
) : Figura (cor, expessura){
    override fun calculaArea(): Double {
        return base * altura
    }

    override fun toString(): String {
        return super.toString() + ", base: $base, área: ${calculaArea()}"
    }

}
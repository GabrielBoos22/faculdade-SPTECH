package org.example

class Circulo(
    cor: String,
    expessura: Int,
    val raio: Double
) : Figura (cor, expessura){
    override fun calculaArea(): Double {
        return Math.PI * raio * raio
    }

    override fun toString(): String {
        return super.toString() + ", raio: $raio, área: ${calculaArea()}"
    }

}
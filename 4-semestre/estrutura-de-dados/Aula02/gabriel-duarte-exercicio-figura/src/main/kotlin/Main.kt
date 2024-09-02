package org.example

import java.awt.Image
import kotlin.math.exp

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val figuras = mutableListOf(
        Quadrado(cor = "Verde", expessura = 20, lado = 5.0),
        Circulo(cor = "Roxo", expessura = 10, raio = 5.0),
        Retangulo(cor = "Rosa", expessura = 1, altura = 5.0, base = 7.5),
        Triangulo(cor = "Azul", expessura = 50, altura = 10.0, base = 7.5)
    )

    val imagem = Imagem()
    adiciona(figuras, imagem)

    imagem.exibeFiguras()
    imagem.exibeSomaArea()
    imagem.exibeFiguraAreaMaior20()
    imagem.exibeQuadrado()
}

fun adiciona(figuras: List<Figura>, imagem: Imagem){
    figuras.forEach {
        imagem.adicionaFigura(it)
        it.toString()
    }
}
package org.example

class Imagem {

    var figuras = mutableListOf<Figura>()

    fun adicionaFigura(figura: Figura) {
        figuras.add(figura)
    }

    fun exibeFiguras(){
        figuras.forEach {
            println(it)
        }
        println()
    }

    fun exibeSomaArea(){
        var soma = 0.0
        figuras.forEach {
            soma += it.calculaArea()
        }
        println("A soma das áreas é: "+ soma)
    }

    fun exibeFiguraAreaMaior20(){
        figuras.forEach {
            if(it.calculaArea() > 20.00) println("Área maior que 20: " + it)
        }
        println()
    }

    fun exibeQuadrado(){
        figuras.forEach {
            if(it is Quadrado){
                println("Exibindo quadrado: " + it)
            }
        }
        println()
    }
}
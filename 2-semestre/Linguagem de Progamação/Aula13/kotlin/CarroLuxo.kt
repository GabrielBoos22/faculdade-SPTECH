/*
CarroLuxo : Carro() -> significa que...
CarroLuxo "herda" tudo que é possível herdar de Carro

Ou seja, CarroLuxo é uma SubClasse de Carro
Portanto, Carro é Super Classe de Carro Luxo

Existem também os termos Classe Base e Clarre derivada:
Ou seja, CarroLuxo é uma Classe Derivada de Carro
Portanto, Carro é Classe Base de CarroLuxo
 */

class CarroLuxo : Carro(){

    /*
    override -> indica que este método SOBRESCREVE
    o comportamento que ele tem na Super Classe
     */
    override fun getReacaoPessoas(): String {
        velocidade -= 3.0 // Conseguimos acessar velocidade porque ela é protected
        return "Noooooossa! Que carrão esse $fabricante $modelo"
    }

    override fun getVelocidadeAceleracao(): Double {
        return 25.0
    }

    override fun getVelocidadeFreada(): Double {
        return 15.0
    }

    override fun getVelocidadeMaxima(): Double {
        return 225.0
    }
}
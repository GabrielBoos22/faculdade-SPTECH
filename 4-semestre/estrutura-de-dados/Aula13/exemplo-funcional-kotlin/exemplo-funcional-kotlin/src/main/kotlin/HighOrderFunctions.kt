fun main() {

    // Criando uma função e armazenando em uma variável
    val hello = {
        println("Olá, funcional")
    }

    // Invocando variável através da variável
    hello()

    // Criando uma função utilizando a sintaxe de função anonima
    val soma = fun(a: Double, b: Double): Double {
        return a + b
    }

    // Criando uma função utilizando a sintaxe de função lambda
    val subtracao = { a: Double, b: Double ->
        a - b
    }

    // Atribuindo uma função a uma variável através da referência de função
    val div = ::divisao // referencia da fun divisao(a: Double, b: Double)

    val calculadora2e4 = CalculadoraDoisNumeros(8.0, 4.0)
    println(calculadora2e4.executarOperacao(soma))
    println(calculadora2e4.executarOperacao(subtracao))
    println(calculadora2e4.executarOperacao { a, b -> a * b }) // Criando método dentro do executarOperacao
    println(calculadora2e4.executarOperacao(div))
}

fun divisao(a: Double, b: Double): Double {
    return a / b
}

class CalculadoraDoisNumeros(var a: Double, var b: Double) {

    // Método que recebe uma função como argumento e retorna o resultado dessa função
    // funcao: (Double, Double) -> Double
    // funcao => Nome da variavel onde a função fica armazenada
    // (Double, Double) => Recebe dois números Double como argumento
    // -> Double => Retorna um número Double
    fun executarOperacao(funcao: (Double, Double) -> Double): Double {
        return funcao(a, b) // invoca funcao passando a e b como argumento e retorna o resultado de "funcao"
    }
}

fun main() {

    val numero = Numero(2.0)

    val soma = fun(a: Double, b: Double): Double {
        return a + b
    }

    val divisao = { a: Double, b: Double -> a / b }


    numero.finalizar(numero.operacao(4.0, soma))
    numero.finalizar(numero.operacao(3.0, divisao))
}

class Numero(var a: Double) {
    fun operacao(b: Double, funcao: (Double, Double) -> Double): Double {
        return funcao(a, b)
    }

    fun finalizar(a: Double) {
        println(a)
    }
}

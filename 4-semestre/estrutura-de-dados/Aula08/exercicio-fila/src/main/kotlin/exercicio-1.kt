package org.example

import java.util.*
import java.util.concurrent.ArrayBlockingQueue
fun main() {
        // Exemplo de vetor com números positivos e negativos
        val v = intArrayOf(2, 7, -3, -50, 45, -4, 30, -21, 38)

        // Chamar o método para separar e exibir os números
        separaPositivoNegativoEmOrdem(v)
}

fun separaPositivoNegativoEmOrdem(vetor: IntArray) {

    val filaPositivos: Queue<Int> = ArrayBlockingQueue(vetor.size)
    val filaNegativos: Queue<Int> = ArrayBlockingQueue(vetor.size)

    for (numero in vetor) {
        if (numero >= 0) {
            filaPositivos.add(numero)
        } else {
            filaNegativos.add(numero)
        }
    }

    while (!filaPositivos.isEmpty()) {
        print(filaPositivos.poll().toString() + " ")
    }

    while (!filaNegativos.isEmpty()) {
        print(filaNegativos.poll().toString() + " ")
    }

    println()
}



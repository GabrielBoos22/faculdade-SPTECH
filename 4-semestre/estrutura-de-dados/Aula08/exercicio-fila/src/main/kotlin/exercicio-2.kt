package org.example

import java.util.*
import java.util.concurrent.ArrayBlockingQueue
fun main() {
        // Exemplo de vetor com números positivos e negativos
        val v = intArrayOf(2, 7, -3, -50, 45, -4, 30, -21, 38)

        // Chamar o método para separar e exibir os números
        separaPositivoNegativoEmOrdemDiferente(v)
}

fun separaPositivoNegativoEmOrdemDiferente(vetor: IntArray) {

    val filaPositivos: Queue<Int> = ArrayBlockingQueue(vetor.size)
    val filaNegativos: Stack<Int> = Stack<Int>()

    for (numero in vetor) {
        if (numero >= 0) {
            filaPositivos.add(numero)
        } else {
            filaNegativos.push(numero)
        }
    }

    while (!filaPositivos.isEmpty()) {
        print(filaPositivos.poll().toString() + " ")
    }

    while (!filaNegativos.isEmpty()) {
        print(filaNegativos.pop().toString() + " ")
    }

    println()
}



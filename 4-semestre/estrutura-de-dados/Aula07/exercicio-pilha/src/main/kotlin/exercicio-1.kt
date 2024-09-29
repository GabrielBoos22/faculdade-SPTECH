@file:Suppress("DEPRECATED_IDENTITY_EQUALS")

package org.example

import java.util.*

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var vetorPalindromo = arrayOf(1,3,3,1)
    var vetorNaoPalindromo = arrayOf(1,3,2,1)
    var verificaPalindromo = verificaPalindromo(vetorPalindromo)
    var verificaPalindromoOtimizado = verificaPalindromoOtimizado(vetorNaoPalindromo)

    println("Verifica Palindromo (1331): "+ verificaPalindromo)
    println("Verifica Palindromo (1321): "+ verificaPalindromo)

    println("Verifica PalindromoOtimizado (1331): "+ verificaPalindromoOtimizado)
    println("Verifica PalindromoOtimizado (1321): "+ verificaPalindromoOtimizado)
}

fun verificaPalindromo(vetor: Array<Int>): Boolean{

    var pilha = Stack<Int>()
    for(num in vetor) {
        pilha.push(num)
    }

    for(num in vetor) {
        if(num !== pilha.pop()){
            return false
        }
    }

    return true

}

fun verificaPalindromoOtimizado(vetor: Array<Int>): Boolean {

    var pilha = Stack<Int>()


    for (i in 0 until vetor.size / 2) {
        pilha.push(vetor[i])
    }

    val inicioSegundaMetade = if (vetor.size % 2 == 0) vetor.size / 2 else vetor.size / 2 + 1

    // Compara a segunda metade do vetor com a pilha (que contém a primeira metade)
    for (i in inicioSegundaMetade until vetor.size) {
        if (vetor[i] != pilha.pop()) {
            return false
        }
    }

    return true
}


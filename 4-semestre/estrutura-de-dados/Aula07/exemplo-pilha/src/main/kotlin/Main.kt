package org.example

import java.util.*

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var pilha = Stack<String>()

    pilha.push("item 1")
    pilha.push("item 2")
    pilha.push("item 3")

    println("Desimpilhando um elemento da pilha: "+ pilha.pop())

    println("Espiando o topo da pilha: " + pilha.peek())

    var pilhaLetras = Stack<String>()
    pilhaLetras.push("p")
    pilhaLetras.push("i")
    pilhaLetras.push("l")
    pilhaLetras.push("h")
    pilhaLetras.push("a")

    while(pilhaLetras.isNotEmpty()){
        println(pilhaLetras.pop())
    }
}


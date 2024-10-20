package org.example

import java.util.Queue
import java.util.concurrent.ArrayBlockingQueue

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var fila = ArrayBlockingQueue<String>(10)

    fila.add("item 1")
    fila.add("item 2")
    fila.add("item 3")

    println("Verificando os elementos da fila: $fila")

    println("Primeiro elemento sendo removido! " + fila.poll())

    println("Verificando os elementos da fila: $fila")

    println("Espiando a fila: " + fila.peek())

    var filaLetras = ArrayBlockingQueue<String>(10)

    filaLetras.add("f")
    filaLetras.add("i")
    filaLetras.add("l")
    filaLetras.add("a")

    while(filaLetras.isNotEmpty()){
        println(filaLetras.poll())
    }

}
package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val votos = mutableMapOf<String, Int>()

    while (true) {
        println("Digite o sabor do sorvete (ou '0' para encerrar):")
        val sabor = readLine() ?: ""

        if (sabor == "0") {
            break
        }

        if (votos.containsKey(sabor)) {
            votos[sabor] = votos[sabor]!! + 1
        } else {
            votos[sabor] = 1
        }
    }

    println("Resultado da votação:")
    for ((sabor, quantidade) in votos) {
        println("$sabor: $quantidade")
    }
}

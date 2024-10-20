package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var mapVazio = LinkedHashMap<String, String>()

    var mapConfiguracao = mutableMapOf(
        "linguagem" to "kotlin",
        "versão" to "1.16.0",
        "ambiente" to "desenvolvimento"
    )

    println(mapConfiguracao)

    println(mapConfiguracao["linguagem"])

    mapConfiguracao["linguagem"] = "java"
    println(mapConfiguracao)

    mapConfiguracao["modo"] = "debug"
    println(mapConfiguracao)

    var ultimaChave = mapConfiguracao.keys.last()

    mapConfiguracao.remove(ultimaChave)

    var lista = listOf(6, 5, 4, 3, 2, 1)

    var mapNumeros = lista.groupBy {
        if(it % 2 == 0) "Par" else "Ímpar"
    }

    println(mapNumeros)

    println(mapConfiguracao.getOrElse("linguagem") {"Linguagem Não Definida"})
    println(mapConfiguracao.getOrElse("linguagem2") {"Linguagem Não Definida"})

    println("Exibindo os valores do mapConfiguração:")
    for (valor in mapConfiguracao.values){
        println(valor)
    }

    println("Exibindo os valores do mapConfiguração pela chave:")
    for (chave in mapConfiguracao.keys){
        println(mapConfiguracao[chave])
    }
}
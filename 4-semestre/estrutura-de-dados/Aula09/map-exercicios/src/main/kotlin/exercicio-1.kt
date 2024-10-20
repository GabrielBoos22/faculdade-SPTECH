package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val contatos = mutableMapOf(
        "Ana" to "1234-5678",
        "Bruno" to "9876-5432",
        "Carla" to "5555-4444"
    )

    println("Digite o nome do amigo que deseja buscar:")
    val nome = readLine()?.lowercase()?.replaceFirstChar { it.uppercase() } ?: ""

    if (contatos.containsKey(nome)) {
        println("O telefone de $nome é ${contatos[nome]}")
    } else {
        println("Amigo não encontrado")
    }
}

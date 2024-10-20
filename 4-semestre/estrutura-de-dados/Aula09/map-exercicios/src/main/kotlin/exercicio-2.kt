package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val contatos = mutableListOf<String>()

    while (true) {
        println("Menu:")
        println("1 – Inserir contato")
        println("2 – Exibir contatos")
        println("0 – Sair")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                println("Digite o nome completo do contato:")
                val nome = readLine() ?: ""
                contatos.add(nome)
            }
            2 -> {
                if (contatos.isEmpty()) {
                    println("Nenhum contato cadastrado.")
                } else {
                    val agrupados = contatos.groupBy { it.first().uppercaseChar() }
                    for ((letra, lista) in agrupados) {
                        println("[$letra]")
                        lista.forEach { println(it) }
                    }
                }
            }
            0 -> {
                println("Encerrando o programa.")
                break
            }
            else -> {
                println("Opção inválida, tente novamente.")
            }
        }
    }
}

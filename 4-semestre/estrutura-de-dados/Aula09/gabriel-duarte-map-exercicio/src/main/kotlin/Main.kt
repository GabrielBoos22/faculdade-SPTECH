package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var gerenciadorMusica = GerenciadorMusica()
    while (true) {
        println("-------- Menu --------")
        println("1 - Adicionar item")
        println("2 - Remover item")
        println("3 - Remover último item")
        println("4 - Exibir itens")
        println("5 - Buscar item")
        println("6 - Atualizar item")
        println("7 - Gerar relatório")
        println("0 - Sair")
        println("Escolha uma opção:")

        when (readLine()?.toIntOrNull()) {
            1 -> gerenciadorMusica.adicionarItem()
            2 -> gerenciadorMusica.removerItem()
            3 -> gerenciadorMusica.removerUltimoItem()
            4 -> gerenciadorMusica.exibirItens()
            5 -> gerenciadorMusica.buscarItem()
            6 -> gerenciadorMusica.atualizarItem()
            7 -> gerenciadorMusica.gerarRelatorio()
            0 -> {
                println("Saindo do programa.")
                break
            }
            else -> println("Opção inválida, tente novamente.")
        }
    }
}
package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var musicas: List<Musica>;

    while (true) {
        println("-------- Menu --------")
        println("1 - Cadastrar Música")
        println("2 - Exibir Lista")
        println("3 - Gravar csv")
        println("4 - Ler csv")
        println("5 - Fim")
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
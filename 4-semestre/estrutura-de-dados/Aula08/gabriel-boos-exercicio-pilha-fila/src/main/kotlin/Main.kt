package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.JOptionPane

fun main() {
    val repositorio = Repositorio()
    var idAtual = 99

    while (true) {
        val opcao = JOptionPane.showInputDialog(
            "Menu:\n" +
                    "1- Salvar música\n" +
                    "2- Deletar objeto\n" +
                    "3- Exibir\n" +
                    "4- Desfazer\n" +
                    "5- Agendar salvar\n" +
                    "6- Executar agendado\n" +
                    "7- Fim"
        ).toInt()

        when (opcao) {
            1 -> {
                val titulo = JOptionPane.showInputDialog("Digite o título da música:")
                val duracao = JOptionPane.showInputDialog("Digite a duração da música (em minutos):").toDouble()
                val classificacao = JOptionPane.showInputDialog("Digite a classificação da música:").toInt()
                val artista = JOptionPane.showInputDialog("Digite o nome do artista:")
                val genero = JOptionPane.showInputDialog("Digite o gênero musical:")
                val musica = Musica(idAtual++, titulo, duracao, classificacao, artista, genero)
                repositorio.salvar(musica)
            }
            2 -> {
                val id = JOptionPane.showInputDialog("Digite o ID da música a ser deletada:").toInt()
                repositorio.deletar(id)
            }
            3 -> {
                repositorio.exibir()
            }
            4 -> {
                repositorio.desfazer()
            }
            5 -> {
                val titulo = JOptionPane.showInputDialog("Digite o título da música:")
                val duracao = JOptionPane.showInputDialog("Digite a duração da música (em minutos):").toDouble()
                val classificacao = JOptionPane.showInputDialog("Digite a classificação da música:").toInt()
                val artista = JOptionPane.showInputDialog("Digite o nome do artista:")
                val genero = JOptionPane.showInputDialog("Digite o gênero musical:")
                val musica = Musica(idAtual++, titulo, duracao, classificacao, artista, genero)
                repositorio.agendarSalvar(musica)
            }
            6 -> {
                val qtdOperacoes = JOptionPane.showInputDialog("Digite a quantidade de operações a serem executadas:").toInt()
                repositorio.executarAgendado(qtdOperacoes)
            }
            7 -> {
                JOptionPane.showMessageDialog(null, "Encerrando o programa.")
                break
            }
            else -> {
                JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.")
            }
        }
    }
}

package org.example

import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val musicas = mutableListOf<Musica>()

    while (true) {
        println("Menu:")
        println("1 - Cadastrar")
        println("2 - Exibir a lista")
        println("3 - Gravar CSV")
        println("4 - Ler CSV")
        println("5 - Fim")

        when (scanner.nextInt()) {
            1 -> {
                println("Digite o ID da música:")
                val id = scanner.nextInt()
                println("Digite o título da música:")
                val titulo = scanner.next()
                println("Digite a duração da música (em minutos):")
                val duracao = scanner.nextDouble()
                println("Digite a classificação da música:")
                val classificacao = scanner.nextInt()
                println("Digite o artista da música:")
                val artista = scanner.next()
                println("Digite o gênero da música:")
                val genero = scanner.next()

                val musica = Musica(id, titulo, duracao, classificacao, artista, genero)
                musicas.add(musica)
                println("Música cadastrada com sucesso!")
            }
            2 -> {
                if (musicas.isEmpty()) {
                    println("Não há músicas cadastradas.")
                } else {
                    musicas.forEach { println(it) }
                }
            }
            3 -> {
                if (musicas.isEmpty()) {
                    println("Não há nada a gravar.")
                } else {
                    println("Digite o nome do arquivo (sem extensão):")
                    val nomeArquivo = scanner.next()
                    val arquivo = FileWriter("$nomeArquivo.csv")
                    val saida = Formatter(arquivo)

                    for(musica in musicas){
                        saida.format("%d;%s;%.2f;%d;%s;%s ;\n", musica.id,
                            musica.titulo, musica.duracao, musica.classificacao, musica.genero, musica.artista)
                    }

                    arquivo.close()
                    saida.close()
                    println("Dados gravados em $nomeArquivo.csv")
                }
            }
            4 -> {
                println("Digite o nome do arquivo a ser lido (sem extensão):")
                val nomeArquivo = scanner.next()
                val arquivo = FileReader("$nomeArquivo.csv")
                val leitor = Scanner(arquivo).useDelimiter(";|\\n")

                println(String.format("%-5S %-10S %-10S %-10S", "ID", "Título", "Duração", "Classificação", "Artista", "Gênero"))

                while(leitor.hasNext()){
                    val id = leitor.nextInt()
                    val titulo = leitor.next()
                    val duracao = leitor.nextDouble()
                    val classificacao = leitor.nextInt()
                    val artista = leitor.next()
                    val genero = leitor.next()

                    println("%10d | %-20s | %5.2f | %6s | %-12s | %-15s ".format(
                        id, titulo, duracao, classificacao, artista, genero
                    ))
                }

                leitor.close()
                arquivo.close()
            }
            5 -> {
                println("Programa encerrado.")
                return
            }
            else -> {
                println("Opção inválida.")
            }
        }
    }
}

package org.example

import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val musicas = mutableListOf<Musica>()

    while (true) {
        println("Menu:")
        println("1 - Cadastrar")
        println("2 - Exibir a lista")
        println("3 - Gravar CSV")
        println("4 - Gravar TXT")
        println("5 - Ler CSV")
        println("6 - Ler TXT")
        println("7 - Fim")

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
                if (musicas.isEmpty()) {
                    println("Lista vazia. Não há nada a gravar!")
                } else {
                    println("Digite o nome do arquivo (sem extensão):")
                    val nomeArquivo = scanner.next()
                    val arquivo = FileWriter("$nomeArquivo.txt")
                    val saida = Formatter(arquivo)

                    //HEADER
                    var header = "00MUSICA20242"
                    header += LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("ddMM-yyyy HH:mm:ss"))
                    header += "01"

                    saida.format(header + "\n")

                    //CORPO
                    for (musica in musicas){
                        val linha = StringBuilder()
                        linha.append("02")
                        linha.append(String.format("%-20.20s", musica.genero))
                        linha.append(String.format("%-20.20s", musica.titulo))
                        linha.append(String.format("%-20.20s", musica.artista))
                        linha.append(String.format("%05.2f", musica.duracao))
                        linha.append(String.format("%03d", musica.classificacao))
                        saida.format(linha.toString() + "\n")
                    }

                    //TRAILER
                    var trailer = "01"
                    trailer += String.format("%010d", musicas.size)

                    arquivo.close()
                    saida.close()
                    println("Gravação efetuada com sucesso!")
                }
            }
            5 -> {
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
            6 -> {
                println("Digite o nome do arquivo a ser lido (sem extensão):")
                val nomeArquivo = scanner.next()
                    val arquivo = FileReader("$nomeArquivo.txt")
                    val leitor = Scanner(arquivo)

                    val listaMusicas = mutableListOf<Musica>()

                    while(leitor.hasNext()){
                        val linha = leitor.nextLine()
                        val tipo = linha.substring(0, 2)

                        when(tipo){
                            "00" -> {
                                val conteudo = linha.substring(2,6)
                                val semestre = linha.substring(6,11)
                                val dataHora = linha.substring(11,30)
                                val versao = linha.substring(30,32)

                                println("Conteudo: $conteudo")
                                println("Semestre: $semestre")
                                println("Data/Hora: $dataHora")
                                println("Versão: $versao")
                            }
                            "01" -> {
                                //TRAILER
                                val qtdRegistros = linha.substring(2, 12).toInt()

                                if (qtdRegistros == listaAlunos.size) {
                                    println("Quantidade de registros: $qtdRegistros")
                                } else {
                                    println("Quantidade de registros divergente: $qtdRegistros")
                                }
                            }
                            "02" -> {
                                //CORPO
                                val curso = linha.substring(2, 7).trim()
                                val ra = linha.substring(7, 15).trim()
                                val nome = linha.substring(15, 65).trim()
                                val disciplina = linha.substring(65, 105).trim()
                                val media = linha.substring(105, 110).replace(",",".").toDouble()
                                val faltas = linha.substring(110, 113).toInt()

                                listaAlunos.add(Aluno(ra, nome, curso, disciplina, media, faltas))
                            }
                        }
                    }
                    leitor.close()
                    arquivo.close()
                    for (aluno in listaAlunos){
                        println(aluno)
                    }
                }
            7 -> {
                println("Programa encerrado.")
                return
            }
            else -> {
                println("Opção inválida.")
            }
        }
    }
}

package org.example

import java.time.LocalDate

class Musica(
    titulo: String,
    genero: String,
    classificacao: String,
    dataLancamento: LocalDate,
    val artista: String,
    val album: String,
    val duracao: Int
) : Conteudo(titulo, genero, classificacao, dataLancamento), Avaliado {

    private val avaliacoes = mutableListOf<Pair<Int, String>>() // List of (nota, comentario)

    override fun exibirDetalhes() {
        println("Música: $titulo, Gênero: $genero, Artista: $artista, Álbum: $album, Duração: $duracao segundos")
        println()
        exibirAvaliacoes()
        println()
    }

    override fun avaliar(nota: Int, comentario: String) {
        avaliacoes.add(Pair(nota, comentario))
        println("Avaliação adicionada à música: $titulo")
        println()
    }

    override fun exibirAvaliacoes() {
        println("Avaliações para a música: $titulo")
        avaliacoes.forEach { (nota, comentario) ->
            println("Nota: $nota, Comentário: $comentario")
        }
    }
}

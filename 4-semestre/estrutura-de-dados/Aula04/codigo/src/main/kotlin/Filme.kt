package org.example

import java.time.LocalDate

class Filme(
    titulo: String,
    genero: String,
    classificacao: String,
    dataLancamento: LocalDate,
    val diretor: String,
    val duracao: Int,
    val elenco: List<String>
) : Conteudo(titulo, genero, classificacao, dataLancamento), Avaliado {

    private val avaliacoes = mutableListOf<Pair<Int, String>>() // List of (nota, comentario)

    override fun exibirDetalhes() {
        println("Filme: $titulo, Gênero: $genero, Classificação: $classificacao, Lançamento: $dataLancamento")
        println("Diretor: $diretor, Duração: $duracao minutos, Elenco: ${elenco.joinToString(", ")}")
        println()
        exibirAvaliacoes()
        println()
    }

    override fun avaliar(nota: Int, comentario: String) {
        avaliacoes.add(Pair(nota, comentario))
        println("Avaliação adicionada ao filme: $titulo")

    }

    override fun exibirAvaliacoes() {
        println("Avaliações para o filme: $titulo")
        avaliacoes.forEach { (nota, comentario) ->
            println("Nota: $nota, Comentário: $comentario")
        }
    }
}
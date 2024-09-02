package org.example

import java.time.LocalDate

class Jogo(
    titulo: String,
    genero: String,
    classificacao: String,
    dataLancamento: LocalDate,
    val plataforma: String,
    val desenvolvedor: String,
    val modoMultiplayer: Boolean
) : Conteudo(titulo, genero, classificacao, dataLancamento) {

    private val avaliacoes = mutableListOf<Pair<Int, String>>() // List of (nota, comentario)

    override fun exibirDetalhes() {
        println()
        println("Jogo: $titulo, Gênero: $genero, Plataforma: $plataforma, Desenvolvedor: $desenvolvedor, Multiplayer: $modoMultiplayer")
    }
}

package org.example

import java.time.LocalDate

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val filme = Filme(
        "O Lobo de Wallstreet",
        "Comédia",
        "18+",
        LocalDate.of(2010, 7, 16),
        "Christopher Nolan",
        148,
        listOf("Leonardo DiCaprio", "Joseph Gordon-Levitt")
    )

    val musica = Musica(
        "Candy Shop",
        "HipHop",
        "17+",
        LocalDate.of(1975, 11, 21),
        "50 Cent",
        "",
        3
    )

    val jogo = Jogo(
        "Rocket League",
        "Ação",
        "Livre",
        LocalDate.of(2015, 7, 7),
        "Psyonix",
        "Dave Hagewood",
        true
    )

    filme.avaliar(5, "Ótimo filme!")
    musica.avaliar(4, "Música clássica incrível!")




    val Plataforma = Plataforma("Boos entertainment", LocalDate.of(2024, 9, 1))

    Plataforma.adicionarConteudo(filme)
    Plataforma.adicionarConteudo(musica)
    Plataforma.adicionarConteudo(jogo)


    Plataforma.exibirConteudos()
}
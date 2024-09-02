package org.example

import java.time.LocalDate

abstract class Conteudo(
    val titulo: String,
    val genero: String,
    val classificacao: String,
    val dataLancamento: LocalDate
) {
    abstract fun exibirDetalhes()
}
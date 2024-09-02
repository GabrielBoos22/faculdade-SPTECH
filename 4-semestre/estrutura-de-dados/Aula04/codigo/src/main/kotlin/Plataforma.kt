package org.example

import java.time.LocalDate

class Plataforma (
    val nome: String,
    val dataLancamento: LocalDate
){
    private val conteudos = mutableListOf<Conteudo>()

    fun adicionarConteudo(conteudo: Conteudo) {
        conteudos.add(conteudo)
    }

    fun exibirConteudos() {
        conteudos.forEach {
        it.exibirDetalhes()}
    }

}
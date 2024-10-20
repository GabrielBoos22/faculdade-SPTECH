package org.example

import java.time.LocalDate

class Musica(
    val id: Int,
    val titulo: String,
    val duracao: Double,
    val classificacao: Int,
    val artista: String,
    val genero: String,
){
    override fun toString(): String {
        return "Musica id: $id, titulo: $titulo, duracao: $duracao, classificacao: $classificacao, artista: $artista, genero: $genero"
    }
}
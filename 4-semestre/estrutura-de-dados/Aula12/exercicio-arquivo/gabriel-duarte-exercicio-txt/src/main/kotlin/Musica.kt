package org.example

import java.time.LocalDate

class Musica(
    val id: Int,
    var titulo: String,
    var duracao: Double,
    var classificacao: Int,
    var artista: String,
    var genero: String,
){
    override fun toString(): String {
        return "Musica id: $id, titulo: $titulo, duracao: $duracao, classificacao: $classificacao, artista: $artista, genero: $genero"
    }
}
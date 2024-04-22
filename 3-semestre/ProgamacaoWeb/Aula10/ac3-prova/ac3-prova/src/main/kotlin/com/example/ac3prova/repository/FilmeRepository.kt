package com.example.ac3prova.repository

import com.example.ac3prova.dominio.Filme
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate

interface FilmeRepository: JpaRepository<Filme, Int> {
    fun findByTitulo(titulo: String): Filme

    fun findByDiretorNacionalidade(nacionalidade: String): List<Filme>
    fun findByGeneroAndDiretorId(genero:String, idDiretor: Int): List<Filme>
    fun findByDiretorDataNascimentoBetween(dataInicio:LocalDate, dataFim: LocalDate): List<Filme>
}
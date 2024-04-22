package com.example.ac3prova.dominio

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import java.time.LocalDate
@Entity
data class Filme (
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val titulo: String,
    val genero: String,
    val anoLancamento: Int,
    val sinopse: String,
    @ManyToOne
    val diretor: Diretor
)
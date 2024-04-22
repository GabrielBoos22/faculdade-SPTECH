package com.example.ac3prova.dominio

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Past
import jakarta.validation.constraints.Size
import java.time.LocalDate

@Entity
data class Diretor (
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    @field:NotBlank
    @field:Size(min = 3)
    val nome: String,
    @field:NotBlank
    val nacionalidade: String,
    @field:Past
    @field:NotNull
    val dataNascimento: LocalDate
)
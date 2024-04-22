package com.example.projetoestoque.dominio

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Sabor(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var codigo: Int,
    var nome: String,
    var precoBase: Double,
    @field: Column(length = 30* 1024 * 1024)
    @field: JsonIgnore
    var foto: ByteArray?
)
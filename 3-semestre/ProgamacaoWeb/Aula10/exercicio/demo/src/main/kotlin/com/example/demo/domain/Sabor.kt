package com.example.demo.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
data class Sabor(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val codigo: Int,
    val nome: String,
    val precoBase: Double,
    @field: Column(length = 30* 1024 * 1024)
    @field: JsonIgnore
    var foto: ByteArray?
)

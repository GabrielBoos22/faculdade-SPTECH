package com.example.projetoestoque.dominio

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
data class Pizza (
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var codigo: Int,
    @ManyToOne
    var sabor: Sabor,
    var tamanho: Tamanho,
    var preco: Double
)

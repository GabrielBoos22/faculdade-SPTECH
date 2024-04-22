package com.example.demo.domain

import jakarta.persistence.*

@Entity
data class Pizza (
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val codigo: Int,
    @field:ManyToOne
    val sabor: Sabor,
    @Enumerated(EnumType.STRING)
    val tamanho: Tamanho
){
    val preco: Double
        get() = when(tamanho){
            Tamanho.PEQUENA -> sabor.precoBase
            Tamanho.MEDIA -> sabor.precoBase * 1.5
            Tamanho.GRANDE -> sabor.precoBase * 2
        }
}

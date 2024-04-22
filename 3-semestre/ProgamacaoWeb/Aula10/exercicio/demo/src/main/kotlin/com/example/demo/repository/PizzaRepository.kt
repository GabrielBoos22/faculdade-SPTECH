package com.example.projetoestoque.repository

import com.example.demo.domain.Pizza
import com.example.demo.domain.Tamanho
import org.springframework.data.jpa.repository.JpaRepository

interface PizzaRepository: JpaRepository<Pizza, Int>{
    fun findBySaborNomeContainingIgnoreCase(nome: String): List<Pizza>
    fun findBySaborNomeContainingIgnoreCaseAndTamanho(nome: String, tamanho: Tamanho): List<Pizza>
}
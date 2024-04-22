package com.example.projetoestoque.repository

import com.example.projetoestoque.dominio.Pizza
import com.example.projetoestoque.dominio.Tamanho
import org.springframework.data.jpa.repository.JpaRepository

interface PizzaRepository: JpaRepository<Pizza, Int>{
    fun findBySaborNomeContainingIgnoreCase(nome: String): List<Pizza>
    fun findBySaborNomeContainingIgnoreCaseAndTamanho(nome: String, tamanho: Tamanho): List<Pizza>
}
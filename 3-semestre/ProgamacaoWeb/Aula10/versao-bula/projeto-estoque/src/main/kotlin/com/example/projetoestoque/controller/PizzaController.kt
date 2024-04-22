package com.example.projetoestoque.controller

import com.example.projetoestoque.dominio.Pizza
import com.example.projetoestoque.dominio.Tamanho
import com.example.projetoestoque.repository.PizzaRepository
import com.example.projetoestoque.repository.SaborRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/pizzas")
class PizzaController (
    val pizzaRepository: PizzaRepository,
){
    @GetMapping
    fun getPizza(): ResponseEntity<List<Pizza>> {
    val pizzas = pizzaRepository.findAll()
        if (pizzas.isEmpty()) return ResponseEntity.status(204).build()
        return ResponseEntity.status(200).body(pizzas)
    }


    @GetMapping("/filtro-sabor/{sabor}")
    fun getPizzaByNomeSabor(
        @PathVariable sabor: String
    ): ResponseEntity<List<Pizza>> {
        val pizzas = pizzaRepository.findBySaborNomeContainingIgnoreCase(sabor)
        if (pizzas.isEmpty()) return ResponseEntity.status(204).build()
        return ResponseEntity.status(200).body(pizzas)
    }

    @GetMapping("/filtro-sabor-tamanho/{sabor}/{tamanho}")
    fun getPizzabySaborAndTamanho(
        @PathVariable sabor: String,
        @PathVariable tamanho: Tamanho
    ): ResponseEntity<List<Pizza>>{
        val pizzas = pizzaRepository.findBySaborNomeContainingIgnoreCaseAndTamanho(sabor, tamanho)
        if (pizzas.isEmpty())return ResponseEntity.status(204).build()
        return ResponseEntity.status(200).body(pizzas)
    }
}

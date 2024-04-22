package com.example.projetoestoque.controller

import com.example.projetoestoque.dominio.Fabricante
import com.example.projetoestoque.repository.FabricanteRepository
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/fabricantes")
class FabricanteController(
    val fabricanteRepository: FabricanteRepository
) {

    @PostMapping
    fun criar(
        @RequestBody @Valid novoFabricante: Fabricante
    ): ResponseEntity<Fabricante>{
        val fabricanteSalvo = fabricanteRepository.save(novoFabricante)
        return ResponseEntity.status(201).body(fabricanteSalvo)
    }

    @GetMapping
    fun listar(): ResponseEntity<List<Fabricante>>{
        val fabricantes = fabricanteRepository.findAll()

        if (fabricantes.isEmpty()) return ResponseEntity.status(204).build()

        return ResponseEntity.status(200).body(fabricantes)
    }
}
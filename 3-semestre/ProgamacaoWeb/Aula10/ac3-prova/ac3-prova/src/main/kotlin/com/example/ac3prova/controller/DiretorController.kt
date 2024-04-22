package com.example.ac3prova.controller

import com.example.ac3prova.dominio.Diretor
import com.example.ac3prova.repository.DiretorRepository
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/diretores")
class DiretorController(
    val diretorRepository: DiretorRepository
) {

    @PostMapping
    fun cadastraDiretor(@RequestBody @Valid novoDiretor:Diretor): ResponseEntity<Diretor>{
        val produtoSalvo = diretorRepository.save(novoDiretor)
        return ResponseEntity.status(201).body(produtoSalvo)
    }



}
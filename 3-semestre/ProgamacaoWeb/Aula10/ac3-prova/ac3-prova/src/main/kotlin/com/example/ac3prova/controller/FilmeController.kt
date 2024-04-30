package com.example.ac3prova.controller

import com.example.ac3prova.dominio.Diretor
import com.example.ac3prova.dominio.Filme
import com.example.ac3prova.repository.FilmeRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/filmes")
class FilmeController(
    val filmeRepository: FilmeRepository
) {
    @GetMapping
    fun listar(): ResponseEntity<List<Filme>> {
        val filmes = filmeRepository.findAll()

        if(filmes.isEmpty()){
            return ResponseEntity.status(204).build()
        }

        return ResponseEntity.status(200).body(filmes)
    }

    @GetMapping("/{id}")
    fun listarPorId(@PathVariable id: Int): ResponseEntity<Filme> {
        if (!filmeRepository.existsById(id)) return ResponseEntity.status(404).build()
        val filme = filmeRepository.findById(id).get()

        if(filme == null){
            return ResponseEntity.status(204).build()
        }

        return ResponseEntity.status(200).body(filme)
    }

    @GetMapping("/filtro-titulo")
    fun listarPorTitulo(@RequestParam titulo: String): ResponseEntity<Filme> {
        val filme = filmeRepository.findByTitulo(titulo)

        if(filme == null){
            return ResponseEntity.status(204).build()
        }

        return ResponseEntity.status(200).body(filme)
    }

    @GetMapping("/filtro-nacionalidade-diretor")
    fun listarPorNacionalidade(@RequestParam nacionalidade: String): ResponseEntity<List<Filme>> {
        val filmes = filmeRepository.findByDiretorNacionalidade(nacionalidade)

        if(filmes.isEmpty()){
            return ResponseEntity.status(204).build()
        }

        return ResponseEntity.status(200).body(filmes)
    }

    @GetMapping("/filtro-genero-diretor/{diretorId}")
    fun listaPorGeneroEDiretor(@PathVariable diretorId: Int,@RequestParam genero: String): ResponseEntity<List<Filme>> {
        val filmes = filmeRepository.findByGeneroAndDiretorId(genero, diretorId)

        if(filmes.isEmpty()){
            return ResponseEntity.status(204).build()
        }

        return ResponseEntity.status(200).body(filmes)
    }

    @GetMapping("/filtro-nascimento-diretor")
    fun listarPorDiretorData(@RequestParam dataInicio: LocalDate, @RequestParam dataFim: LocalDate): ResponseEntity<List<Filme>> {
        val filmes = filmeRepository.findByDiretorDataNascimentoBetween(dataInicio, dataFim)

        if(filmes.isEmpty()){
            return ResponseEntity.status(204).build()
        }

        return ResponseEntity.status(200).body(filmes)
    }

}
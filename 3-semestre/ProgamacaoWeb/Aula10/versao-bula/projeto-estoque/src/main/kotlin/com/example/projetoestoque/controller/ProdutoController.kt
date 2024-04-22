package com.example.projetoestoque.controller

import com.example.projetoestoque.dominio.Produto
import com.example.projetoestoque.repository.FabricanteRepository
import com.example.projetoestoque.repository.ProdutoRepository
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/produtos")
class ProdutoController(
    val produtoRepository: ProdutoRepository,
    val fabricanteRepository: FabricanteRepository
) {

    @PostMapping
    fun criar(
        @RequestBody @Valid novoProduto: Produto
    ): ResponseEntity<Produto> {

        if (!fabricanteRepository.existsById(novoProduto.fabricante.id)) {
            return ResponseEntity.status(404).build()
        }
        val produtoSalvo = produtoRepository.save(novoProduto)
        return ResponseEntity.status(201).body(produtoSalvo)
    }

    @GetMapping
    fun listar(): ResponseEntity<List<Produto>> {
        val produtos = produtoRepository.findAll()

        if (produtos.isEmpty()) return ResponseEntity.status(204).build()

        return ResponseEntity.status(200).body(produtos)
    }

    @GetMapping("/filtro-fabricante/{fabricanteId}")
    fun buscarPorIdFabricante(
        @PathVariable fabricanteId: Int
    ): ResponseEntity<List<Produto>>{
        val produtos = produtoRepository.findByFabricanteId(fabricanteId)
        if (produtos.isEmpty()) return ResponseEntity.status(204).build()
        return ResponseEntity.status(200).body(produtos)
    }

    @GetMapping("/filtro-qtdEstoque")
    fun buscarPorQtdEstoque(
        @RequestParam min: Int,
        @RequestParam max: Int
    ): ResponseEntity<List<Produto>>{
        val produtos = produtoRepository.findByQtdEstoqueBetween(min, max)
        if (produtos.isEmpty()) return ResponseEntity.status(204).build()
        return ResponseEntity.status(200).body(produtos)
    }

}
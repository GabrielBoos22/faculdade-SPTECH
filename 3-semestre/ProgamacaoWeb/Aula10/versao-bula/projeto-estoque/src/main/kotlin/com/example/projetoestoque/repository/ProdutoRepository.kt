package com.example.projetoestoque.repository

import com.example.projetoestoque.dominio.Produto
import org.springframework.data.jpa.repository.JpaRepository

interface ProdutoRepository : JpaRepository<Produto, Int> {
// SELECT * FROM PRODUTO p JOIN FABRICANTE f
// on p.fabricante_id = f.id WHERE f.id = ?

    fun findByFabricanteId(id: Int): List<Produto>
    fun findByQtdEstoqueBetween(min: Int, max: Int): List<Produto>
}
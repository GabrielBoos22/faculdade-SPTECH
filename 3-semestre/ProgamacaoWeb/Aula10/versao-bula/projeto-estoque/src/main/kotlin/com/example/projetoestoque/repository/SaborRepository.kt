package com.example.projetoestoque.repository

import com.example.projetoestoque.dominio.Sabor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface SaborRepository: JpaRepository<Sabor, Int>{
    fun findTop3ByOrderByPrecoBaseDesc(): List<Sabor>
    @Query("SELECT s.foto FROM Sabor s WHERE s.codigo = :codigo")
    fun findFotoByCodigo(codigo: Int): ByteArray
}
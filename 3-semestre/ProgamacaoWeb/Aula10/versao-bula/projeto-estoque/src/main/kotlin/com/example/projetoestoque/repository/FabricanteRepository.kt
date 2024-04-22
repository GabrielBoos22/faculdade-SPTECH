package com.example.projetoestoque.repository

import com.example.projetoestoque.dominio.Fabricante
import org.springframework.data.jpa.repository.JpaRepository

interface FabricanteRepository : JpaRepository<Fabricante, Int> {
}
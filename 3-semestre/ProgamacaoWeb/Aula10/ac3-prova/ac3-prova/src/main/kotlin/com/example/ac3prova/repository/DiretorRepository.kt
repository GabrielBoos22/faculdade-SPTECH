package com.example.ac3prova.repository

import com.example.ac3prova.dominio.Diretor
import com.example.ac3prova.dominio.Filme
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate

interface DiretorRepository: JpaRepository<Diretor, Int> {
}
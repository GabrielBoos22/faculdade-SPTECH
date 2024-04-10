package sptech.projetojpa3.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import sptech.projetojpa3.dominio.Compositor
import sptech.projetojpa3.dominio.Musica

interface CompositorRepository: JpaRepository<Compositor, Int> {

    @Query("select m.csv from Compositor m where m.codigo = ?1")
    fun recuperarCsv(codigo:Int):ByteArray
}
package sptech.projetojpa1.repository

import org.springframework.data.jpa.repository.JpaRepository
import sptech.projetojpa1.dominio.Musica
import java.time.LocalDate
import java.util.Optional

interface MusicaRepository: JpaRepository<Musica, Int> {
    /*
    Aqui usamos uma técnica chamada Dynamic Finder
     */
    fun findByNome(nome: String): List<Musica>

    fun findByNomeContains(nome: String): List<Musica>

    fun findByLancamentoAfter(data: LocalDate): List<Musica>

    fun findTop1ByOrderByLancamentoDesc(): Optional<Musica>

    fun findByClassicoTrue(): List<Musica>

    fun findByEstiloAndClassico(estilo: String, classificacao: Boolean): List<Musica>

    fun findTop3ByOrderByTotalOuvintesDesc(): List<Musica>
    fun countByEstilo(estilo: String): Int
}
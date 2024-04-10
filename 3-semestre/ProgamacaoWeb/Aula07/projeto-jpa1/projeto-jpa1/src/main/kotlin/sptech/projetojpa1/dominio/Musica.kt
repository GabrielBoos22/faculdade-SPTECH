package sptech.projetojpa1.dominio

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import java.time.LocalDate

@Entity
data class Musica (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var codigo: Int?,
    @field:NotBlank @field:Size(min = 2, max = 20) var nome: String?,
    @field:Min(0) var totalOuvintes: Int?,
    var lancamento: LocalDate,
    var estilo: String,
    var classico: Boolean
    )
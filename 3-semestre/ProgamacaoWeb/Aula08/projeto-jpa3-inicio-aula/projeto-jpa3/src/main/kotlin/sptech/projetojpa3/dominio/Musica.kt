package sptech.projetojpa3.dominio

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import java.time.LocalDate

@Entity
data class Musica(
    // Id é do pacote jakarta.persistence
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var codigo:Int?,
    @field:NotBlank @field:Size(min = 2, max = 20) var nome:String?,
    @field:Min(0) var totalOuvintes:Int?,
    var lancamento:LocalDate?,
    /*
    Coluimn -> configuramos as definições da coluna no banco relacional
    10 * 1024 * 1024 -> equivale 10 MB
     */
    @field:Column(length = 10 * 1024 * 1024)
    @JsonIgnore
    var foto:ByteArray,

    @field:ManyToOne
    var compositor: Compositor?
)

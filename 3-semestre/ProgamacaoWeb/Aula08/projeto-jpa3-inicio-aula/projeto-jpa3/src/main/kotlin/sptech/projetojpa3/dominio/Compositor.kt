package sptech.projetojpa3.dominio

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
data class Compositor(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY )
    var codigo: Int?,
    var nome:String?,
    @field:Column(length = 3 * 1024 * 1024)
    @JsonIgnore
    var csv: ByteArray?
) {
}
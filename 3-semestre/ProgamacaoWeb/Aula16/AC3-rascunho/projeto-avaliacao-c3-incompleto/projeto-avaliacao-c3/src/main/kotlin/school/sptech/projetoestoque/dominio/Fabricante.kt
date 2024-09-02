package school.sptech.projetoestoque.dominio

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Entity
data class Fabricante (
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var codigo: Int? = null,
    @field:NotNull @field:Size(min = 2, max = 10)
    var nome: String? = null,
    @field:NotNull @field:Size(min = 3, max = 20)
    var paisOrigem: String? = null,

    @field:OneToMany(mappedBy = "fabricante")
    var carros: List<Carro>? = null
)


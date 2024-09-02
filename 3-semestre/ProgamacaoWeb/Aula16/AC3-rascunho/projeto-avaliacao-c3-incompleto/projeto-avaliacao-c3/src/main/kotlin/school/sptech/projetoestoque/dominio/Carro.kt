package school.sptech.projetoestoque.dominio

import jakarta.persistence.*
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Entity
data class Carro (
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var codigo: Int? = null,
    @field:Size(min = 1, max = 12)
    var modelo: String? = null,
    @field:NotNull @field:DecimalMin(value = "1.0", message = "A potência deve ser maior ou igual a 1.0")
    @field:DecimalMax(value = "4.0", message = "A potência deve ser menor ou igual a 4.0")
    var potencia: Double? = null,
    @field:DecimalMin(value = "10000.0", message = "O preço de compra deve ser maior ou igual a 10000")
    var precoCompra:Double? = null,

    var importado:Boolean? = false,

    @field:ManyToOne
    var fabricante: Fabricante? = null
)






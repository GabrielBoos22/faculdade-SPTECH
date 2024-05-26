package school.sptech.projetoestoque.dto

import jakarta.persistence.ManyToOne
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.Size
import school.sptech.projetoestoque.dominio.Fabricante

data class ProdutoCadastroRequest (
    @field:Size(min = 3)
    var nome: String,

    @field:Positive
    var qtdEstoque: Int? = null,

    @field:Positive
    var preco:Double? = null,

    @field:ManyToOne
    var fabricante: Fabricante? = null
)
package school.sptech.projetoestoque.dto
import school.sptech.projetoestoque.dto.ProdutoSimplesSemFabricanteResponse

data class FabricanteResponse(
    var id: Int? = null,
    var nome: String? = null,
    var produtos: List<ProdutoSimplesSemFabricanteResponse>? = null
)
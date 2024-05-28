package school.sptech.projetoestoque.dto

data class ProdutoResponse(
    var id: Int? = null,
    var nome: String? = null,
    val fabricante: FabricanteSimplesResponse? = null,
    val qtdEstoque: Int? = null,
    val preco: Double? = null
) {
}
package school.sptech.projetoestoque.dto

// incompleto
data class CarroCadastroRequest(
    var modelo: String,

    var potencia: Double? = null,

    var importado: Boolean? = false,

    var precoCompra:Double? = null,

    var fabricante: FabricanteCadastroRequest? = null
)
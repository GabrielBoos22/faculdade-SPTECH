package school.sptech.projetoestoque.dto

// incompleto
data class FabricanteRelatorioResponse(
    var codigo: Int? = null,

    var nome: String? = null,

    var carros: List<CarroSimplesResponse>? = null // não deve retornar no JSON
) {

    fun getModelos(): Int {
        return carros!!.size
    }
}

package school.sptech.projetoestoque.dto

import com.fasterxml.jackson.annotation.JsonIgnore

// incompleto
data class CarroSimplesResponse(
    var codigo: Int? = null,
    @JsonIgnore
    var modelo: String? = null, // não deve retornar no JSON
    @JsonIgnore
    var potencia: Double? = null, // não deve retornar no JSON
    @JsonIgnore
    var fabricante: FabricanteRelatorioResponse? = null // não deve retornar no JSON
) {

    fun getDescricao(): String {
        return "${fabricante!!.nome} $modelo $potencia"
    }

}





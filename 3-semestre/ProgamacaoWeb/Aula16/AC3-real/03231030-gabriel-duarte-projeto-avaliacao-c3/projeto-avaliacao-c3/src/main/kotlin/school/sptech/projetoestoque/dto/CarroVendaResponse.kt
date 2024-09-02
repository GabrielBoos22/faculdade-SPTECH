package school.sptech.projetoestoque.dto

import com.fasterxml.jackson.annotation.JsonIgnore

// incompleto
data class CarroVendaResponse(
    var codigo: Int? = null,
    var modelo: String? = null,
    var potencia: Double? = null,
    @JsonIgnore
    var importado: Boolean? = null, // não deve retornar no JSON
    @JsonIgnore
    var precoCompra: Double? = null, // não deve retornar no JSON
    @JsonIgnore
    var fabricante: FabricanteSimplesResponse? = null // não deve retornar no JSON
) {

    fun getNomeFabricante(): String? {
        return fabricante!!.nome
    }

    fun getPrecoVenda(): Double {

        if(importado!!){
            return precoCompra!! + (0.15 * precoCompra!!)
        }
        return precoCompra!! + (0.10 * precoCompra!!)
    }
}





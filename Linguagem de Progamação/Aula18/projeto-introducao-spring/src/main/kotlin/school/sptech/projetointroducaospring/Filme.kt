package school.sptech.projetointroducaospring

import com.fasterxml.jackson.annotation.JsonIgnore

class Filme (
    var titulo: String,
    var diretor: String,
    var anoLancamento: Int) {

    fun getAlgumaCoisa() : Int {
        var numero = 15
        return numero
    }
}
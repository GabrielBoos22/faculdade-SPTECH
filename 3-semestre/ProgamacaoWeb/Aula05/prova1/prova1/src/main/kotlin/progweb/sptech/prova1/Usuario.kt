package progweb.sptech.prova1

import com.fasterxml.jackson.annotation.JsonIgnore

data class Usuario(
    val login: String,
    var senha: String,
    val nome: String,
    var dicaSenha: String,
    var ativo: Boolean,
    var autenticado: Boolean = false,
    var acessos: Int = 0
) {

}
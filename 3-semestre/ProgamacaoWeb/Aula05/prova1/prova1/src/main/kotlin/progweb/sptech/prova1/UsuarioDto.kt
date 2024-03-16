package progweb.sptech.prova1

data class UsuarioDto (
    val login: String,
    val senha: String,
    val nome: String,
    val dicaSenha: String,
    val ativo: Boolean
){
}
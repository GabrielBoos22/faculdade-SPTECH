import java.time.LocalDate
import java.time.Period

open class Pessoa {
    var nome: String = ""
    var email: String = ""
    lateinit var dataNascimento: LocalDate;

    fun getIdade(): Int{
        var ano = Period.between(dataNascimento, LocalDate.now()).years
        return ano
    }

    fun exibirInformacoes(): String{
        return """
            Nome: $nome
            Email: $email
            Idade: ${getIdade()}
            ${informacoesAdicionais()}
        """.trimIndent()
    }

    open fun informacoesAdicionais(): String{
        return ""
    }
}
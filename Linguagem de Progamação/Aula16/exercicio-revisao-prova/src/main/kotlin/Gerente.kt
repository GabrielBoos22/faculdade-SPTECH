import java.time.LocalDate

class Gerente():PessoaFisica(){
    var agencia: String = "";

    override fun adicional(): String {
        return "Agencia: ${agencia}"
    }
}
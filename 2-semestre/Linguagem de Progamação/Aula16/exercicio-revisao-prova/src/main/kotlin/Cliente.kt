import java.time.LocalDate

class Cliente():PessoaFisica(){
    var numeroConta: String = "";

    override fun adicional(): String {
        return "Número da conta: ${numeroConta}"
    }
}
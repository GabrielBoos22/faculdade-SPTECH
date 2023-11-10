class Atendente: Funcionario() {
    lateinit var setor: String

    override fun informacaoAdicional(): String {
        return "Setor: $setor"
    }
}
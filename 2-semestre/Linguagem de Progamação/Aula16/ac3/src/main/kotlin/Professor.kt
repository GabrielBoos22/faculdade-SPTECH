class Professor: Pessoa() {
    var especialidade: String = ""

    override fun informacoesAdicionais(): String {
        return "Especialidade: $especialidade"
    }
}
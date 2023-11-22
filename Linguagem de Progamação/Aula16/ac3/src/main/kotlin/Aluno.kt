class Aluno: Pessoa() {
    var matricula: String = ""

    override fun informacoesAdicionais(): String {
        return "Matrícula: $matricula"
    }
}
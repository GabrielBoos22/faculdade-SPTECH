class Gerente: Funcionario() {
    lateinit var departamento: String

    override fun informacaoAdicional(): String {
        return "Departamento: $departamento"
    }
}
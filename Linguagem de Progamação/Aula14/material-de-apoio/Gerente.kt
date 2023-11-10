class Gerente : Funcionario() {
    var departamento:String = ""

    override fun getDetalheDescricao(): String {
        return """
            Departamento: $departamento"""
    }
}
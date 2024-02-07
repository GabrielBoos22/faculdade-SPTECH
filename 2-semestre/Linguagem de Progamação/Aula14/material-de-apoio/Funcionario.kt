open class Funcionario {
    lateinit var nome:String
    var idade:Int = 0
    var salario:Double = 0.0

    fun exibirDados():String {
        return """
            Nome: $nome ${getDetalheDescricao()}
            Salário: ${"%.2f".format(salario)}
        """.trimIndent()
    }

    open fun getDetalheDescricao():String {
        return ""
    }
}



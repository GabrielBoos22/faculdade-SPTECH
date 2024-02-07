open class Funcionario {

    lateinit var nome:String
    var idade: Int = 0
    var salario: Double = 0.0

    fun exibirDados(): String{
        return """
            Nome: $nome
            ${informacaoAdicional()}
            Salario: $salario
        """.trimIndent()
    }

    open fun informacaoAdicional(): String{
        return ""
    }

    fun aumentarSalario(){
        this.salario *= 1.5
    }
}
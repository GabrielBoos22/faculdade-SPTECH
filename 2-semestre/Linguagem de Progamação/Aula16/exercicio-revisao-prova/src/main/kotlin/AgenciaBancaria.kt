class AgenciaBancaria {
    var nome: String = "";
    lateinit var gerente: Gerente;

    var clientes = mutableListOf<Cliente>()

    fun adicionarCliente(NovoCliente: Cliente){
        clientes.add(NovoCliente)
    }

    fun detalhes(): String{
        return """
           Nome: $nome
           Gerente: ${gerente.nome}
           Quantidade de Clientes: ${clientes.size}
        """.trimIndent()
    }
}
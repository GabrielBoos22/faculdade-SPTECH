fun main() {
    val pessoa1 = Pessoa("Rafael", 22)

    pessoa1.nome = "Reis"

    println("""
        seu nome é ${pessoa1.nome} 
        e você tem ${pessoa1.getIdade()}
    """.trimMargin())

    pessoa1.fazerAniversario()
    println("""
        seu nome é ${pessoa1.nome} 
        e você tem ${pessoa1.getIdade()}
    """.trimMargin())
}
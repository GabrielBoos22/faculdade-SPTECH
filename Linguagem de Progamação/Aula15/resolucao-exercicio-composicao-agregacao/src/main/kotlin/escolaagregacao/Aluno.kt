package escolaagregacao

class Aluno {
    lateinit var nome: String
    lateinit var matricula: String

    lateinit var turma: Turma

    fun getDescricao(): String {
        return """
        Nome da Turma: ${turma.nome}
        Nome do aluno: $nome
        Matricula: $matricula
        """.trimIndent()
    }
}
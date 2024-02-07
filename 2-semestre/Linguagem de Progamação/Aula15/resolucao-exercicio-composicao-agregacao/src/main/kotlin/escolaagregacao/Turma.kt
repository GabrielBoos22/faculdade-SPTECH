package escolaagregacao

class Turma {
    lateinit var nome: String
    var alunos = mutableListOf<Aluno>()

    /*
    Um Aluno existe antes de entrar numa turma, logo, não precisa da Turma para existir
     */
    fun matricularAluno(novoAluno:Aluno) {
        novoAluno.turma = this // "this" é esta turma
        alunos.add(novoAluno)
    }

    fun getDescricao(): String {
        return """
        Nome da turma: $nome 
        Quantidade de alunos: ${alunos.size}
        """.trimIndent()
    }
}
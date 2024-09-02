package school.sptech.herancaaluno

class Faculdade(var nome: String) {

    private val alunos = mutableListOf<Aluno>()

    fun matricularAluno(aluno: Aluno) {
        alunos.add(aluno)
    }

    fun exibirAlunos() {
        println("Alunos da $nome")

        for (alunoDaVez in alunos) {
            println(alunoDaVez)
        }

        println()
    }

    fun exibirAlunosPosGraduacao() {
        println("Alunos de pós graduação da $nome")

        for (alunoDaVez in alunos) {
            if (alunoDaVez is AlunoPosGraduacao) {
                println(alunoDaVez)
            }
        }

        println()
    }

    fun exibirSomaDasMedias() {
        var soma = 0.0

        for (aluno in alunos) {
            soma += aluno.calcularMedia()
        }

        println("Soma das médias: $soma")
    }
}
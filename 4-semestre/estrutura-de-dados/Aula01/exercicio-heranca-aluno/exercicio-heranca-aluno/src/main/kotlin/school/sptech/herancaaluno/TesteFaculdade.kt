package school.sptech.herancaaluno

fun main() {

    val aluno1 = Aluno(
        "Leonardo", 9.0, 8.0)

    val alunoPos1 = AlunoPosGraduacao(
        "João", 10.0, 8.0, 9.0)

    val faculdade1 = Faculdade("SPTech")
    faculdade1.matricularAluno(aluno1)
    faculdade1.matricularAluno(alunoPos1)

    faculdade1.exibirAlunos()
    faculdade1.exibirAlunosPosGraduacao()
    faculdade1.exibirSomaDasMedias()
}
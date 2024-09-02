package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var aluno = Aluno("Pedro", 5.0, 8.5)
    var alunoPos = AlunoPosGraduacao("Valquiria", 10.0, 7.0, 9.0)
    var faculdade = Faculdade("SPTech")

    faculdade.matricularAluno(aluno)
    faculdade.matricularAluno(alunoPos)

    faculdade.exibirAlunos()
    faculdade.exibirAlunosPosGraduacao()

    faculdade.exibirSomaDasMedias()
}

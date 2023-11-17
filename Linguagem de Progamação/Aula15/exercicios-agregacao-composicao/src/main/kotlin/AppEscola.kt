fun main(){

    val turma1 = Turma()
    turma1.nome = "1SIS"
    turma1.addAlunos("Gabriel Boos Duarte", "03231002", 50)

    turma1.exibirTurma()
    turma1.exibir3alunos()

    val turma2 = Turma()
    turma2.nome = "2SIS"
    turma2.addAlunos("Alexandre Damas", "1020301", 35)

    turma2.exibirTurma()
    turma2.exibir3alunos()
}
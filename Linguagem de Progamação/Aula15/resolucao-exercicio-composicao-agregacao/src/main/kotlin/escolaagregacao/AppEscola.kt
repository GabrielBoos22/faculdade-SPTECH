package escolaagregacao

import javax.swing.JOptionPane
import javax.swing.JOptionPane.showMessageDialog

fun main() {
    val turma1 = Turma()
    turma1.nome = "Equipe Ada"

    val aluno1 = Aluno()
    aluno1.nome = "Aluno A"
    aluno1.matricula = "111A"
    val aluno2 = Aluno()
    aluno2.nome = "Aluno B"
    aluno2.matricula = "222B"

    turma1.matricularAluno(aluno1)
    turma1.matricularAluno(aluno2)


    val turma2 = Turma()
    turma2.nome = "Equipe Idô"

    val aluno3 = Aluno()
    aluno3.nome = "Aluno C"
    aluno3.matricula = "333C"
    val aluno4 = Aluno()
    aluno4.nome = "Aluno D"
    aluno4.matricula = "444C"
    val aluno5 = Aluno()
    aluno5.nome = "Aluno E"
    aluno5.matricula = "555E"

    turma2.matricularAluno(aluno3)
    turma2.matricularAluno(aluno4)
    turma2.matricularAluno(aluno5)


    val turmas = listOf(turma1, turma2)


    turmas.forEach { turma -> // iterando a lista de turmas. Cada turma dentro se chama "turma"
        showMessageDialog(null, turma.getDescricao())

        // exibindo os 3 primeiros alunos cadastrados na turma
        for (a in 0..2) {
            // verificando se existe o aluno na posição "a" na lista de alunos
            // isso evita que a aplicação encerre por erro caso uma turma tenha menos de 3 alunos
            if (turma.alunos.size > a) {
                showMessageDialog(null, "${a+1}o. aluno:\r\n${turma.alunos[a].getDescricao()}")
            }
        }
    }



}
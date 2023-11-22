import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.swing.JOptionPane
import javax.swing.JOptionPane.showMessageDialog

fun main() {
    var professor1 = Professor()
    professor1.nome = "Rafael Reis"
    professor1.especialidade = "Algoritmo"
    professor1.email = "rafael.reis@sptech.school"
    professor1.dataNascimento = LocalDate.parse("07/04/2001", DateTimeFormatter.ofPattern("dd/MM/yyyy"))

    val aluno1 = Aluno()
    aluno1.nome = "Gabriel"
    aluno1.email = "gabriel.bduarte@sptech.school"
    aluno1.dataNascimento = LocalDate.parse("05/05/2005", DateTimeFormatter.ofPattern("dd/MM/yyyy"))
    aluno1.matricula = "0321400"

    val aluno2 = Aluno()
    aluno2.nome = "Joao"
    aluno2.email = "Joao.kleber@sptech.school"
    aluno2.dataNascimento = LocalDate.parse("11/11/2004", DateTimeFormatter.ofPattern("dd/MM/yyyy"))
    aluno2.matricula = "0221100"

    showMessageDialog(null, professor1.exibirInformacoes())
    showMessageDialog(null, aluno1.exibirInformacoes())
    showMessageDialog(null, aluno2.exibirInformacoes())

    val disciplina = Disciplina()
    disciplina.nome = "Linguagem de Progamação"
    disciplina.anoSemestre = "2023/2"
    disciplina.professor = professor1
    disciplina.adicionarAluno(aluno1)
    disciplina.adicionarAluno(aluno2)

    showMessageDialog(null, disciplina.detalhes())
}
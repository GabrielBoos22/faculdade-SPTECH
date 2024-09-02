package org.example

class Escola(
    val nome: String
) {

    var alunos = mutableListOf<Aluno>()

    fun adicionaAluno (aluno: Aluno) {
        alunos.add(aluno)
    }

    fun exibeTodos(){
        alunos.forEach {
            println(it)
        }
        println()
    }

    fun exibeAlunoGraduacao(){
        alunos.forEach {
            if(it is AlunoGraduacao) println(it)
        }
        println()
    }

    fun exibeAprovados(){
        alunos.forEach {
            if(it.calculaMedia() > 6.00) println(it)
        }
        println()
    }

    fun buscaAluno (ra: String){
        alunos.forEach {
            if(it.ra == ra){
                println(it)
            }
        }
        println()
    }
}
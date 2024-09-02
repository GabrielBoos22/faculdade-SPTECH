package org.example

class Faculdade (var nome: String){

    var alunos = mutableListOf<Aluno>()

    fun matricularAluno(novoAluno: Aluno){
        alunos.add(novoAluno)
    }

    fun exibirAlunos() {
        alunos.forEach{
            println(this.toString())
        }
        println()
    }

    fun exibirAlunosPosGraduacao(){
        alunos.forEach {
            if(it is AlunoPosGraduacao){
                println(it)
            }
        }
    }

    fun exibirSomaDasMedias(){
        var soma = 0.0
        alunos.forEach {
            soma += it.calcularMedia()
        }
        println("Soma das médias é $soma")
    }
}
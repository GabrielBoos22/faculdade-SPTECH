package org.example

class AlunoGraduacao(
    cpf: String,
    nome: String,
    nota1: Double,
    nota2: Double
) : Aluno(cpf, nome, nota1, nota2){

    override fun calculaMedia(): Double {
        return (nota1 + nota2) / 2
    }
    override fun toString(): String {
        return super.toString() + ", media: ${calculaMedia()}"
    }
}
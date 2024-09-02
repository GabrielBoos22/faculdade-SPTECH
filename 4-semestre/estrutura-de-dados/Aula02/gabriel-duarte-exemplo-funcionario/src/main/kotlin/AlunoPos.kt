package org.example

class AlunoPos(
    ra: String,
    nome: String,
    nota1: Double,
    nota2: Double,
    val notaMonografia: Double
) : Aluno (ra, nome, nota1, nota2){

    override fun calculaMedia(): Double {
        return (nota1 + nota2 + notaMonografia) / 3
    }

    override fun toString(): String {
        return super.toString() + ", media: ${calculaMedia()}"
    }

}
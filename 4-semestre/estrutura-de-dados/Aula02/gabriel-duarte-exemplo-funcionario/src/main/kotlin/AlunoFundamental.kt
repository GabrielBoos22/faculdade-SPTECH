package org.example

class AlunoFundamental(
    ra: String,
    nome: String,
    nota1: Double,
    nota2: Double,
    val nota3: Double,
    val nota4: Double
) : Aluno (ra, nome, nota1, nota2){
    override fun calculaMedia(): Double {
        return (nota1+ nota2 + nota3 + nota4) / 4
    }

    override fun toString(): String {
        return super.toString() + ", media: ${calculaMedia()}"
    }

}
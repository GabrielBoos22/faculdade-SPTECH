package school.sptech.herancaaluno

class AlunoPosGraduacao(
    nome: String,
    nota1: Double,
    nota2: Double,
    var notaTcc: Double
) : Aluno(nome, nota1, nota2) {

    override fun calcularMedia(): Double {
        return (nota1 + nota2 + notaTcc) / 3
    }

    override fun toString(): String {
        return "AlunoPosGraduacao(notaTcc=$notaTcc) ${super.toString()}"
    }
}
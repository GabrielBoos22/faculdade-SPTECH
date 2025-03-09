class Aluno(
    var ra: String,
    var nome: String,
    var curso: String,
    var disciplina: String,
    var media: Double,
    var qtdFaltas: Int
) {

    override fun toString(): String {
        return "Aluno(ra='$ra', nome='$nome', curso='$curso', disciplina='$disciplina', media=$media, qtdFaltas=$qtdFaltas)"
    }
}
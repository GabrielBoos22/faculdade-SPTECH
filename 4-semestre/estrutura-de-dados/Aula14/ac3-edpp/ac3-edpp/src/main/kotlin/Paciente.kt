class Paciente(
    var id: Int,
    var nome: String,
    var prioritario: Boolean,
    var sintomas: String,
    var idade: Int,
    var peso: Double
) {

    override fun toString(): String {
        return "Paciente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", prioritario=" + prioritario +
                ", sintomas='" + sintomas + '\'' +
                ", idade=" + idade +
                ", peso=" + peso +
                '}'
    }
}

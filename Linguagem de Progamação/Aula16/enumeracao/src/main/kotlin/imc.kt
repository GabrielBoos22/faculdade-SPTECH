enum class Imc(
    val resultado: String, val minimo:Double, val maximo:Double, val acao: String
) {
    ABAIXO_IDEAL("IMC abaixo do ideal", 18.5, 24.9, "Comer mais"),
    IDEAL("IMC ideal", 24.9,30.0, "Continue com sua refeição"),
    ACIMA_IDEAL("Imc Alto", 30.0, Double.MAX_VALUE, "Faça mais exercício");

    companion object{
        fun retornaImc(imcAmostra: Double): Imc{
            values().forEach{
                if(imcAmostra >= it.minimo && imcAmostra < it.maximo){
                    return it
                }
            }
            throw ImcInvalidoException()
        }
    }
}
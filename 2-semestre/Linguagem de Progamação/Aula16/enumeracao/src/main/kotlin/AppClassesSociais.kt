fun main(){
    val rendaEstagiario = -2_200.0
    try{
        val classeEstagiario =
            ClasseSocial.aPartirDaRenda(rendaEstagiario)

        println("A classe social de estagiário é ${classeEstagiario?.descricao}")
    } catch(excecao: Exception){
        println(excecao)
    }
    val rendaX = 12_500.0
    val classeX = ClasseSocial.aPartirDaRenda(rendaX)

    println("A classe é ${classeX?.descricao}")
}
// open significa que o Carro pode ter herdeiro (Sub Classes)
open class Cachorro {

    lateinit var nome: String
    var idade: Int = 0
    var peso: Double = 0.0

    fun comer(comida:String, quantidadeGramas: Double): String{
        peso += (quantidadeGramas / 1000) * getMultiplicadorPesoCachorro()
        return "Cachorro comendo $comida"
    }

   open fun getMultiplicadorPesoCachorro(): Double{
       return 1.0
   }

   open fun getCorrerCachorro():Boolean{
       return false
   }

   fun correrAoVerMoto():Boolean{
       return getCorrerCachorro()
   }

   open fun getPrecoMedio():Double{
       return 100.0
   }

   fun getDescricao(): String{
       return "O cachorro $nome tem $idade anos e pesa $peso"
   }
}
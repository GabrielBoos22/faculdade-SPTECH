package sptech.projeto02

import com.fasterxml.jackson.annotation.JsonIgnore

class TimeFutebol(
        val nome: String,
        val vitoria: Int,
        val empates: Int,
        val derrotas: Int,
        @JsonIgnore var patrimonio: Double
){

    /*
   métodos que começam com get/is fazem parte do padrão JavaBean
   como são um padrão, servem para prover propriedades para um JSON

   Quando criamos uma propriedade gerada a partir de uma informação
     */

    fun getPontos(): Int{
        return vitoria *3 + empates
    }

    //
    fun isInvicto(): Boolean {
        return derrotas == 0
    }

}
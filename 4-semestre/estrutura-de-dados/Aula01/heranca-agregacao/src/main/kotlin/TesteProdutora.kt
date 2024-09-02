package school.sptech.herancaaluno

import org.example.Ator
import org.example.Desenvolvedor
import org.example.DesenvolvedorMobile
import org.example.Protagonista
import kotlin.system.exitProcess

class TesteProdutora() {

    private val atores = mutableListOf<Ator>(
        Protagonista(nome = "Leonardo di Caprio", qtdHorasTrabalhadasProtagonista = 30, valorHoraTrabalhadaProtagonista = 150000.0),
        Ator(nome = "Millio Bob Brow", qtdHorasTrabalhadas = 15, valorHoraTrabalhada = 78000.0),
        Protagonista(nome = "Matt Damon", qtdHorasTrabalhadasProtagonista = 30, valorHoraTrabalhadaProtagonista = 100000.0)
    )

    fun teste(){
        val produtora = Produtora("Helbert Richards", 2)
        atores.forEach {
            println(it.toString())
            println(produtora.contratar(it))
        }
        println("Qtd atores: "+ produtora.getQuantidadeAtores())
        println("Qtd atores protagonistas: "+ produtora.getQuantidadeAtoresProtagonistas())
        println("Total Salário: "+ produtora.getTotalSalarios())
        println("Total Salário: "+ produtora.getTotalSalarios())
        println("Leonardo di Caprio: "+ produtora.buscarAtorPorNome("Leonardo di Caprio"))
        println("Produtora: "+ produtora.toString())

    }

}
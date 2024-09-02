package school.sptech.herancaaluno

import org.example.Ator
import org.example.Desenvolvedor
import org.example.DesenvolvedorMobile
import org.example.Protagonista

class Produtora(
    var nome: String,
    var vagas: Int) {

    private val atores = mutableListOf<Ator>()

    fun existePorNome(ator: Ator): Boolean {
        atores.forEach {
            if (it.nome == ator.nome){
                return true
            }
        }
        return false
    }

    fun contratar(ator: Ator): String {
        if(vagas <= 0) return "Sem vagas disponíveis!"
        atores.add(ator)
        vagas--
        return "Ator adicionado"
    }

    fun getQuantidadeAtores(): Int{
        var qtd = 0
        atores.forEach {
            if(it is Ator){
                qtd++
            }
        }
        return qtd
    }

    fun getQuantidadeAtoresProtagonistas(): Int{
        var qtd = 0
        atores.forEach {
            if(it is Protagonista){
                qtd++
            }
        }
        return qtd
    }

    fun getTotalSalarios(): Double{
        var soma = 0.0
         atores.forEach{
            soma += it.getSalario()
        }
        return soma
    }

    fun buscarAtorPorNome(nome: String): Ator?{
        atores.forEach {
            if(it.nome == nome){
                return it
            }
        }
        return null
    }

    override fun toString(): String {
        return "Produtora(nome='$nome', vagas='$vagas', atores='${atores.forEach{ return it.toString() }}')"
    }
}
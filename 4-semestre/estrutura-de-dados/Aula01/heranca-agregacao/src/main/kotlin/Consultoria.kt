package school.sptech.herancaaluno

import org.example.Desenvolvedor
import org.example.DesenvolvedorMobile

class Consultoria(
    var nome: String,
    var vagas: Int) {

    private val desenvolvedores = mutableListOf<Desenvolvedor>()

    fun existePorNome(desenvolvedor: Desenvolvedor): Boolean {
        desenvolvedores.forEach {
            if (it.nome == desenvolvedor.nome){
                return true
            }
        }
        return false
    }

    fun contratar(desenvolvedor: Desenvolvedor): String {
        if(vagas <= 0) return "Sem vagas disponíveis!"
        desenvolvedores.add(desenvolvedor)
        return "Desenvolvedor adicionado"
    }

    fun getQuantidadeDesenvolvedores(): Int{
        var qtd = 0
        desenvolvedores.forEach {
            if(it is Desenvolvedor){
                qtd++
            }
        }
        return qtd
    }

    fun getQuantidadeDesenvolvedoresMobile(): Int{
        var qtd = 0
        desenvolvedores.forEach {
            if(it is DesenvolvedorMobile){
                qtd++
            }
        }
        return qtd
    }

    fun getTotalSalarios(): Double{
        var soma = 0.0
         desenvolvedores.forEach{
            soma += it.getSalario()
        }
        return soma
    }

    fun buscarDesenvolvedorPorNome(nome: String): Desenvolvedor?{
        desenvolvedores.forEach {
            if(it.nome == nome){
                return it
            }
        }
        return null
    }

    override fun toString(): String {
        return "Consultoria(nome='$nome', vagas='$vagas', desenvolvedores='${desenvolvedores.forEach{ return it.toString() }}')"
    }
}
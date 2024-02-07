/*
Aqui a classe possui um CONSTRUTOR
 */

class Estudante(
    var nome: String,
    var media: Double,
    var frequencia: Double
) {

    var listaAtividades = mutableListOf<String>()

    fun aprovou():Boolean {
        return media >= 6.0 && frequencia >= 75.0
    }

    fun registrarAtividade(nomeAtividade: String){
        if(listaAtividades.size < 3){
            media = media + 0.15
            listaAtividades.add(nomeAtividade)
        }
        
    }
}
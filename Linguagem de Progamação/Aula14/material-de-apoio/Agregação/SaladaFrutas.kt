package agregacao

class SaladaFrutas {

    val frutas = mutableListOf<Fruta>()

    fun adicionarFruta(novaFruta: Fruta) {
        frutas.add(novaFruta)
    }

    fun tirarFruta(fruta: Fruta) {
        frutas.remove(fruta)
    }
}
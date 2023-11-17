package agregacao

class SaladaFrutas {
    //Agregação
    val frutas = mutableListOf<Fruta>()

    fun adicionarFruta(novaFruta: Fruta) {
        frutas.add(novaFruta)
    }

    fun tirarFruta(fruta: Fruta) {
        frutas.remove(fruta)
    }
}
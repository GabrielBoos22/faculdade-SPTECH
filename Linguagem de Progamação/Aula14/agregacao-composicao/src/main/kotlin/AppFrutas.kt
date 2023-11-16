package agregacao

fun main() {
    val fruta1 = Fruta()
    fruta1.nome = "maçã"
    fruta1.preco = 10.0

    val fruta2 = Fruta()
    fruta2.nome = "pêra"
    fruta2.preco = 3.0

    val fruta3 = Fruta()
    fruta3.nome = "morango"
    fruta3.preco = 17.0

    val salada1: SaladaFrutas = SaladaFrutas()
    salada1.adicionarFruta(fruta1)
    salada1.adicionarFruta(fruta2)
    salada1.adicionarFruta(fruta3)

    val salada2 = SaladaFrutas()
    salada2.adicionarFruta(fruta3)
    salada2.adicionarFruta(fruta2)

    println()

    salada1.frutas.clear()

    println()

    var salada3: SaladaFrutas? = SaladaFrutas()
    salada3?.adicionarFruta(fruta1)
    salada3?.adicionarFruta(fruta2)
    salada3?.adicionarFruta(fruta3)

    println()

    salada3 = null

    println()

}





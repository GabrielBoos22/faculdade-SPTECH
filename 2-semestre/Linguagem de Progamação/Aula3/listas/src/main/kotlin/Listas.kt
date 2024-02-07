fun main() {

    /*
    listOf()
    cria uma lista imutável (ou somente leitura)
    nenhum elemento pode entrar ou sair dela
     */

    val herois = listOf("Batman", "Mulher Maravilha", "Thor")

    println(herois)

    println("Primeiro: ${herois[0]}")
    println("Terceiro: ${herois[2]}")
    println("Ultimo: ${herois[herois.size-1]}")

    println("Primeiro: ${herois.first()}")
    println("Ultimo: ${herois.last()}")

     // herois.add("Saitama")

    /*
    MultablelistOf()
    cria uma lista MÚTAVEL (ou somente leitura)
    elementos podem entrar ou sair dela
     */

    val paises = mutableListOf<String>("Brasil", "México", "Chile")
    paises.add("Angola") // insere um elemento
    println(paises)

    paises.remove("México") // remove pelo VALOR
    paises.removeAt(0) // remove pela POSIÇÃO (índice)
    println(paises)

    // indluindo mais de um elemento por vez
    paises.addAll(listOf("Cuba", "Panamá", "Panamá"))

    println(paises)

    // as listas PERMITEM elementos repetidos
    paises.remove("Panamá")
    println(paises)

    paises.add(2, "Brasil")
    println(paises)

    paises.set(3, "EUA")
    // paises[3] = "EUA"
    println(paises)

    // isEmpty() -> true se NÃO houver nada na lista
    // isNotEmpty() -> true se a lista tiver pelomenos 1 elemento
    println("Os países estão vazios? ${paises.isEmpty()}")
    println("Há países? ${paises.isNotEmpty()}")

    paises.sort()
    println(paises)

    val numeros = mutableListOf(22, 80, 9, 1, 20, -12)
    numeros.sort()
    println(numeros)

    numeros.reverse()
    println(numeros)
    //sortDescending() -> ordena "ao contrário" os elementos

    val bla = mutableListOf(2,8,1,9)
    bla.sortDescending()
    println(bla)

    /*
    sorted() -> Cria e devolve uma CÓPIA
    da lista original ordenada
    mas NÃO altera a lista original
     */

    val bixos = listOf("gato", "rato", "cachorro")
    println(bixos.sorted())
    val bichosOrdenados = bixos.sorted()
    println(bixos)
    println(bichosOrdenados)

    paises.forEach {
        println("Já fui no país $it")
    }
/*
forEach {} - Abre um bloco de código que será executado para cada elemento da lista
por PADRÃO, cada elemento da lista recebe o nome de 'it"
 */
    paises.forEach { pais ->
        println("Já fui no país $pais")
    }

    paises.forEachIndexed {
        indice, pais ->
        println("O país na posição ${indice+1} é $pais")
    }

    val paisesFiltrados = paises.filter {
        it.contains("a")
    }
    println(paisesFiltrados)
    println(paises)

    val paisesBla = paises.filter { it.length < 6}
    print(paisesBla)
}
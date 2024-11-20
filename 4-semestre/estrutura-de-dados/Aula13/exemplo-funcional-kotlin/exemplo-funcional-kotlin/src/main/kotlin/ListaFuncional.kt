fun main() {

    // Laço de repetição utilizando o paradigma +/- imperativo
    // O Kotlin não possui a estrutura de repetição for de maneira totalmente imperativa
    println("Paradigma imperativo")
    for (i in 0..10) {
        println(i)
    }

    // Laço de repetição utilizando o paradigma funcional
    // (0..10) => Cria uma lista de 0 até 10
    // .forEach => Itera cada um dos números da lista
    // println(it) => printa o valor do it que corresponde ao item da vez (it = itemDaVez)
    //
    // Outra possível sintaxe (0..10).forEach({ itemDaVez -> println(itemDaVez) })
    // Nesse caso substituimos a variavel que se chama it para itemDaVez
    //
    // Outra possível sintaxe (0..10).forEach { itemDaVez -> println(itemDaVez) }
    // Quando a função lambda está no último argumento da função podemos deixá-la fora dos parênteses
    println("Paradigma funcional")
    (0..10).forEach { println(it) }

    // Somando valores de um vetor (imperativo)
    println("Soma imperativo:")
    var acumulador = 0
    for (i in 1..10) {
        acumulador += i
    }
    println(acumulador)

    // Somando valores de um vetor de forma imperativa utilizando reduce
    // O reduce recebe uma função com dois parâmetros, o acumulador e o valor atual
    // acc = acumulador
    // valor = itemDaVez no laço de repetição
    // Em algumas linguagens precisamos especificar qual o valor inicial do acumulador
    // No Kotlin o acumulador inicia com o primeiro item da lista que nesse exemplo é 0
    println("Soma funcional:")
    println((0..10).reduce { acc, valor -> acc + valor })

    // Manipulando a lista de maneira imperativa
    // Filtrando apenas valores pares e depois multiplicando o número atual por 2
    println("Alterando lista imperativo")
    val listaNumeros = listOf(2, 5, 9, 12)
    val listaDobro = mutableListOf<Int>()

    for (numero in listaNumeros) {
        if (numero % 2 == 0) {
            listaDobro.add(numero * 2)
        }
    }

    println(listaDobro)

    // Manipulando a lista de maneira funcional
    // Filtrando apenas valores pares e depois multiplicando o número atual por 2
    // Como cada função retorna uma nova lista, podemos encadear as funções até obter o resultado desejado
    println("Alterando lista funcional")
    println(listOf(2, 5, 9, 12)
        .filter { it % 2 == 0 }
        .map { it * 2 })

    // Buscando valor na lista de maneira imperativa
    println("Buscando na lista imperativo")
    val listaLetras = listOf("a", "b", "c")
    var valorEncontrado: String? = null

    for (letra in listaLetras) {
        if (letra == "b") {
            valorEncontrado = letra
        }
    }

    println(valorEncontrado)

    // Buscando valor na lista de maneira funcional
    println("Buscando na lista funcional")
    println(listOf("a", "b", "c").find { it == "b" })

    println("Removendo da lista de forma imperativa")
    // Removendo da lista de forma imperativa
    val listaLetras2 = mutableListOf("a", "b", "c")
    listaLetras2.remove("b")
    println(listaLetras2)

    println("Removendo da lista de forma funcional")
    // Para remover um item da lista de maneira funcional não podemos utilizar o método remove,
    // pois o método remove, altera a lista já existente ao invés de retornar uma
    // nova lista sem o valor removido
    // Removendo um valor da lista de forma funcional
    println(listOf("a", "b", "c").filter { it != "b" }) // Removendo letra b da lista
}
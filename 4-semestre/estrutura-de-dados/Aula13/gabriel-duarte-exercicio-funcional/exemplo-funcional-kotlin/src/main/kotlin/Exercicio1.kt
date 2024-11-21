fun main() {
    val a = (0..50).filter { it % 2 == 0 }

    println("Pares de 0 a 50:")
    println(a.forEach { println(it)})

    val b = (0..50).filter { it % 3 == 0 }.map{ it * 5}

    println("Divisiveis por 3 de 0 a 50:")
    println(b.forEach { println(it)})

    val c = (0..10).filterNot { it in listOf(4, 7, 9) }

    println("Diferente de 4, 7 e 9:")
    println(c.forEach { println(it)})

    val d = (1..10).map { it * it}

    println("1 a 10:" )
    println(d.forEach{ println(it) })

}

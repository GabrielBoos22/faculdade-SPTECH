import java.util.Stack

fun inverterFrase(frase: String): String {
    val pilha = Stack<Char>()

    for (indice in frase.indices) {
        pilha.push(frase[indice])
    }

    var fraseInvertida = ""
    while (!pilha.isEmpty()) {
        fraseInvertida += pilha.pop()
    }

    return fraseInvertida
}

fun main() {
    val frase = "A pilha do gato"
    val fraseInvertida = inverterFrase(frase)
    println("Frase original: $frase")
    println("Frase invertida: $fraseInvertida")
}

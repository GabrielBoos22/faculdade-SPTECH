import java.util.*

fun main() {
    val numero = 9
    println("Número $numero em binário:")
    converterParaBinario(numero)

    val numero2 = 12
    println("Número $numero2 em binário:")
    converterParaBinario(numero2)

    val numero3 = 32
    println("Número $numero3 em binário:")
    converterParaBinario(numero3)
}

fun converterParaBinario(numero: Int): Unit {
    var n = numero
    val pilha = Stack<Int>()

    // Divida o número sucessivamente por 2 e empilhe os restos
    while (n > 0) {
        pilha.push(n % 2)
        n /= 2
    }

    // Desempilhe e exiba os restos (que representam o binário)
    while (!pilha.isEmpty()) {
        print(pilha.pop())
    }

    println() // Para pular para a próxima linha após exibir o número binário
}

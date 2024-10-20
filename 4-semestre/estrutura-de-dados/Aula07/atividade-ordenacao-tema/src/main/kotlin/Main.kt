package org.example


fun ordenarPorClassificacao(vetor: Array<Musica>) {
    for (i in 0 until vetor.size - 1) {
        for (j in 0 until vetor.size - i - 1) {
            if (vetor[j].classificacao < vetor[j + 1].classificacao) {
                val temp = vetor[j]
                vetor[j] = vetor[j + 1]
                vetor[j + 1] = temp
            }
        }
    }
}

fun buscaBinariaPorClassificacao(vetor: Array<Musica>, classificacao: Int): Int {
    var inicio = 0
    var fim = vetor.size - 1

    while (inicio <= fim) {
        val meio = (inicio + fim) / 2
        if (vetor[meio].classificacao == classificacao) {
            return meio
        } else if (vetor[meio].classificacao < classificacao) {
            fim = meio - 1 //
        } else {
            inicio = meio + 1
        }
    }
    return -1
}

fun main() {

    val musicas = arrayOf(
        Musica(1, "Candy Shop", 3.5, 5, "50 Cent", "Hip Hop"),
        Musica(2, "In da Club", 4.0, 2, "50 Cent", "Hip Hop"),
        Musica(3, "Invicible", 2.08, 4, "Pop Smoke", "Hip Hop"),
        Musica(4, "Agudo Mágico 3", 5.0, 3, "MC K.K", "Funk"),
        Musica(5, "Set Do Mago Intergalatico", 3.32, 1, "MC MN", "Funk"),

    )

    println("Vetor antes da ordenação:")
    musicas.forEach { println("${it.titulo}, Classificação: ${it.classificacao}") }

    ordenarPorClassificacao(musicas)

    println("\nVetor após a ordenação por classificação (decrescente):")
    musicas.forEach { println("${it.titulo}, Classificação: ${it.classificacao}") }

    val valorExistente = 1
    val resultadoExistente = buscaBinariaPorClassificacao(musicas, valorExistente)
    println("\nResultado da busca binária para classificação $valorExistente:")
    if (resultadoExistente != -1) {
        println("Música encontrada: ${musicas[resultadoExistente].titulo}")
    } else {
        println("Classificação não encontrada!")
    }

    val valorNaoExistente = 6
    val resultadoNaoExistente = buscaBinariaPorClassificacao(musicas, valorNaoExistente)
    println("\nResultado da busca binária para classificação $valorNaoExistente:")
    if (resultadoNaoExistente != -1) {
        println("Música encontrada: ${musicas[resultadoNaoExistente].titulo}")
    } else {
        println("Classificação não encontrada!")
    }
}

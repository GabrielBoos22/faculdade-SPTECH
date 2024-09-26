fun main() {

    // Criando vetor com valores inteiros
    var vetor1 = arrayOf(1, 2, 3)

    // Criando vetor com valores de texto
    var vetor2 = arrayOf("a", "b", "c")

    // Criando um vetor de inteiros com 100 posições iniciados com 0
    var vetor3 = Array(100) {0}

    // Iterando vetor normalmente
    for (i in vetor1){
        println(i)
    }

    // Iterando vetor de trás para frente
    for(i in vetor1.indices.reversed()){
        println(vetor1[i])
    }

    // Criando uma variável sem inicializar o vetor
    var vetor4: Array<Double>

    // Inicializando vetor com o tamanho especificado pelo usuário
    println("Digite o tamanho do vetor de notas:")
    var tamanho = readln().toInt()

    var notas = Array(tamanho) {0.0}

    // Guardando valores especificados pelo usuário no vetor
    for (i in notas.indices){
        println("Digite o valor da nota ${i+1}")
        notas[i] = readln().toDouble()
    }

    // Exibindo vetor
    for (i in notas.indices){
        println("${i+1}ª Nota: ${notas[i]}")
    }

    // Calculando a média das notas
    var soma = 0.0

    for(i in notas.indices){
        soma += notas[i]
    }

    var media = soma / notas.size

    println("Média: $media")
    println("Média: ${notas.average()}")

}

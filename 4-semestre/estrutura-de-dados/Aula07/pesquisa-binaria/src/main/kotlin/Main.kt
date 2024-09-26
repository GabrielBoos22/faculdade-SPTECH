package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var array = kotlin.arrayOf(5,2,4,9,3,10)
    var arrayOrdenado = selectionSortOptimized(array)

    println("Verificando um numero que não existe: " + pesquisaBinaria(arrayOrdenado, 11))
    println("Verificando um numero que existe: " + pesquisaBinaria(arrayOrdenado, 10))
    println(array[2])
}

fun selectionSort(array: Array<Int>): Array<Int>{
     for(i in 0 until array.size - 1){
        for(j in i+1 until array.size){
            if(array[j] < array[i]){
                var aux = array[i]
                array[i] = array[j]
                array[j] = aux
            }
        }
    }
    return array
}

fun selectionSortOptimized(array: Array<Int>): Array<Int>{
    for(i in 0 until array.size - 1){
        var indMenor = i
        for(j in i+1 until array.size){
            if(array[j] < array[indMenor]){
                indMenor = j
            }
        }
        var aux = array[i]
        array[i] = array[indMenor]
        array[indMenor] = aux
    }
    return array
}

fun bubbleSort(array: Array<Int>): Array<Int>{
    for(i in 0 until array.size - 1){
        for (j in 1 until array.size - i){
            if(array[j-1] > array[j]){
                var aux = array[j]
                array[j] = array[j-1]
                array[j-1] = aux
            }
        }
    }
    return array
}

fun pesquisaBinaria(array: Array<Int>, n: Int): Int{
    var inicio = 0
    var fim = array.size - 1

    while(inicio <= fim){
        var meio = (inicio + fim) / 2
        if(n == array[meio]){
            return meio
        } else if(n > array[meio]){
            inicio = meio + 1
        } else {
            fim = meio - 1
        }
    }
    return -1
}

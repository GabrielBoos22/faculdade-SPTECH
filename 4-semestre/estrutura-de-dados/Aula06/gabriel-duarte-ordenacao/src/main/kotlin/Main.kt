package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var array = kotlin.arrayOf(5,2,4,9,3,10)
    selectionSort(array).forEach {
        println("Selection Sort " + it)
    }
    selectionSortOptimized(array).forEach {
        println("Selection Sort Optimized " + it)
    }
    bubbleSort(array).forEach {
        println("Bubble Sort " + it)
    }
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
                var aux = array[i]
                array[i] = array[indMenor]
                array[indMenor] = aux
            }
        }
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

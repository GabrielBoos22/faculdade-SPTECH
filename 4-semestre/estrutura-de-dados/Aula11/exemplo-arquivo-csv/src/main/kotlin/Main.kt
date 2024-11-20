package org.example

import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.util.*

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var cachorros = mutableListOf(
        Cachorro(1, "Billy", "Grande", 20.0),
        Cachorro(2, "Max", "Médio", 20.0),
        Cachorro(3, "Marley", "Pequeno", 3.3)
    )

    gravarCsv(cachorros, "dogs.csv")
    lerCsv("dogs.csv")

}

fun gravarCsv(lista: List<Cachorro>, nome: String){
    val arquivo = FileWriter(nome)
    val saida = Formatter(arquivo)

    for(cachorro in lista){
        saida.format("%d;%s;%s;%.2f\n", cachorro.id,
            cachorro.nome, cachorro.porte, cachorro.peso)
    }

    saida.close()
    arquivo.close()

    println(arquivo)
    println(saida)
}

fun lerCsv(nome: String){
    val arquivo = FileReader(nome)
    val leitor = Scanner(arquivo).useDelimiter(";|\\n")

    println(String.format("%-5S %-10S %-10S %-10S", "ID", "NOME", "PORTE", "PESO"))

    while(leitor.hasNext()){
        val id = leitor.nextInt()
        val nome = leitor.next()
        val porte = leitor.next()
        val peso = leitor.nextDouble()

        println(String.format("%05d %-10.10s %-10s %5.2f", id, nome, porte, peso))
    }

    leitor.close()
    arquivo.close()
}
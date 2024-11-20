package org.example

import java.io.FileReader
import java.io.FileWriter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val alunos = mutableListOf<Aluno>()

    alunos.add(Aluno("03231036",
        "Edson Morro",
        "SIS",
        "Estrudigmas",
        9.0,
        0)
    )

    alunos.add(Aluno("03231012",
        "Maria Paula",
        "SIS",
        "Gestão de Projetos",
        10.0,
        1)
    )

    escreverArquivoTxt(alunos, "alunos.txt")
    lerArquivoTxt("alunos.txt")
}

fun escreverArquivoTxt(lista: List<Aluno>, nomeArquivo: String){
    val arquivo = FileWriter(nomeArquivo)
    val saida = Formatter(arquivo)

    //HEADER
    var header = "00NOTA20242"
    header += LocalDateTime.now()
        .format(DateTimeFormatter.ofPattern("ddMM-yyyy HH:mm:ss"))
    header += "01"

    saida.format(header + "\n")

    //CORPO
    for (aluno in lista){
        val linha = StringBuilder()
        linha.append("02")
        linha.append(String.format("%-5.5s", aluno.curso))
        linha.append(String.format("%-8.8s", aluno.ra))
        linha.append(String.format("%-50.50s", aluno.nome))
        linha.append(String.format("%-40.40s", aluno.disciplina))
        linha.append(String.format("%05.2f", aluno.media))
        linha.append(String.format("%03d", aluno.qtdFaltas))
        saida.format(linha.toString() + "\n")
    }

    //TRAILER
    var trailer = "01"
    trailer += String.format("%010d", lista.size)

    saida.close()
    arquivo.close()
}

fun lerArquivoTxt(nomeArquivo: String): List<Aluno>{
    val arquivo = FileReader(nomeArquivo)
    val leitor = Scanner(arquivo)

    val listaAlunos = mutableListOf<Aluno>()

    while(leitor.hasNext()){
        val linha = leitor.nextLine()
        val tipo = linha.substring(0, 2)

        when(tipo){
            "00" -> {
                val conteudo = linha.substring(2,6)
                val semestre = linha.substring(6,11)
                val dataHora = linha.substring(11,30)
                val versao = linha.substring(30,32)

                println("Conteudo: $conteudo")
                println("Semestre: $semestre")
                println("Data/Hora: $dataHora")
                println("Versão: $versao")
            }
            "01" -> {
                //TRAILER
                val qtdRegistros = linha.substring(2, 12).toInt()

                if (qtdRegistros == listaAlunos.size) {
                    println("Quantidade de registros: $qtdRegistros")
                } else {
                    println("Quantidade de registros divergente: $qtdRegistros")
                }
            }
            "02" -> {
                //CORPO
                val curso = linha.substring(2, 7).trim()
                val ra = linha.substring(7, 15).trim()
                val nome = linha.substring(15, 65).trim()
                val disciplina = linha.substring(65, 105).trim()
                val media = linha.substring(105, 110).replace(",",".").toDouble()
                val faltas = linha.substring(110, 113).toInt()

                listaAlunos.add(Aluno(ra, nome, curso, disciplina, media, faltas))
            }
        }
    }
    leitor.close()
    arquivo.close()
    for (aluno in listaAlunos){
        println(aluno)
    }
    return listaAlunos
}
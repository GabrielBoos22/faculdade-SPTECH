import java.io.FileReader
import java.io.FileWriter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

fun main() {

    val alunos = mutableListOf<Aluno>()

    alunos.add(Aluno("01222103",
        "Thiago Serafim",
        "ADS", "Estrutura de Dados",
        6.00, 10))

    alunos.add(Aluno("01222204",
        "Nathalia Obi",
        "ADS", "Programação Web",
        10.00, 2))

    alunos.add(Aluno("04222000",
        "Ana Teixeira",
        "REDES", "Segurança da Informação",
        6.00, 5))

    alunos.add(Aluno("01222022",
        "Guilherme Nascimento",
        "SIS", "Engenharia de Software",
        7.00, 3))

    escreverArquivoTxt(alunos, "notas.txt")
    lerArquivoTxt("notas.txt")
}

fun escreverArquivoTxt(lista: List<Aluno>, nomeArquivo: String) {

    val arquivo = FileWriter(nomeArquivo)
    val saida = Formatter(arquivo)

    // Escrevendo header do arquivo
    var header = "00NOTA20232"
    header += LocalDateTime.now()
        .format(DateTimeFormatter
            .ofPattern("dd-MM-yyyy HH:mm:ss"))
    header += "01"

    saida.format(header + "\n")

    // Escrevendo corpo do arquivo

    for (aluno in lista) {
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

    // Gravando registro do trailer
    var trailer = "01"
    trailer += String.format("%010d", lista.size)

    saida.format(trailer + "\n")

    saida.close()
    arquivo.close()
}

fun lerArquivoTxt(nomeArquivo: String) {

    val arquivo = FileReader(nomeArquivo)
    val leitor = Scanner(arquivo)

    val listaAlunos = mutableListOf<Aluno>()

    while (leitor.hasNext()) {
        val linha = leitor.nextLine()
        val registro = linha.substring(0, 2)

        if (registro == "00") {
            val conteudo = linha.substring(2, 6)
            val semestre = linha.substring(6, 11)
            val dataHora = linha.substring(11, 30)
            val versao = linha.substring(30, 32)

            println("Conteúdo do arquivo: $conteudo")
            println("Semestre: $semestre")
            println("Data/Hora: $dataHora")
            println("Versão: $versao")
        } else if (registro == "02") {
            val curso = linha.substring(2, 7).trim()
            val ra = linha.substring(7, 15).trim()
            val nome = linha.substring(15, 65).trim()
            val disciplina = linha.substring(65, 105).trim()
            val media = linha.substring(105, 110).replace(",", ".").toDouble()
            val qtdFaltas = linha.substring(110, 113).toInt()

            val aluno = Aluno(ra, nome, curso,
                disciplina, media, qtdFaltas)

            listaAlunos.add(aluno)
        } else if (registro == "01") {
            val qtdRegistros = linha.substring(2, 12).toInt()

            if (qtdRegistros == listaAlunos.size) {
                println("Quantidade de registros " +
                        "corresponde ao valor informado")
            } else {
                println("Quantidade de registros não " +
                        "corresponde ao valor informado")
            }
        }
    }

    leitor.close()
    arquivo.close()

    for (aluno in listaAlunos) {
        println(aluno)
    }
}

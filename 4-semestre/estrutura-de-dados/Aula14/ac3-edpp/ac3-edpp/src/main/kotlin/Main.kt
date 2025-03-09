import java.io.FileReader
import java.io.FileWriter
import java.util.*

fun main() {

    // 1- Criar uma lista mutável de objetos Paciente
    val listaPacientes = mutableListOf<Paciente>()

    /* 2- Ler o arquivo paciente.txt que esta na pasta de projeto,
          criar um objeto Paciente para cada registro de dados do arquivo
          e adicionar esse objeto a lista criada acima.
          Mas atencao: se o paciente for prioritario, ele devera entrar no
          indice zero da lista, usando add(0,objeto)
          Se o paciente nao for prioritario, efetue add normal no fim da lista
          Atencao tambem para nao ficar com brancos excedentes nas variaveis texto
          A leitura deve seguir o documento de layout que esta na pasta do projeto
     */

    val arquivo = FileReader("paciente.txt")
    val leitor = Scanner(arquivo)
    val listaAlunos = mutableListOf<Paciente>()

    while (leitor.hasNext()) {
        val linha = leitor.nextLine()
        val registro = linha.substring(0, 2)
        if (registro == "00") {
            val tipo = linha.substring(2, 10)
            val dataHora = linha.substring(10, 29)
            val versao = linha.substring(29, 31)

            println("Tipo do arquivo: $tipo")
            println("Data/Hora: $dataHora")
            println("Versão: $versao")

        } else if (registro == "02") {
            val id = linha.substring(2, 7).toInt()
            val nome = linha.substring(7, 37).trim()
            val sintomas = linha.substring(37, 57).trim()
            val prioritario = linha.substring(57, 62).toBoolean()
            val peso = linha.substring(62, 68).replace(",", ".").toDouble()
            val idade = linha.substring(68, 71).toInt()

            val paciente = Paciente(id, nome, prioritario, sintomas, idade, peso)
            listaPacientes.add(paciente)
        } else if (registro == "01") {
            val qtdRegistros = linha.substring(2, 7).toInt()
            if (qtdRegistros == listaPacientes.size) {
                println("Quantidade de registros corresponde ao valor informado")
            } else {
                println("Quantidade de registros não corresponde ao valor informado")
            }
        }
    }

    leitor.close()
    arquivo.close()


    // 3- Exiba a lista de pacientes na console, sem usar saida formatada
    for (paciente in listaPacientes) {
        println(paciente)
    }
    // 4- Grave o conteudo da lista num arquivo paciente.csv

    val arquivoCsv = FileWriter("paciente.csv")
    val saidaCsv = Formatter(arquivoCsv)

    for (paciente in listaPacientes) {
        saidaCsv.format("%d;%s;%s;%s;%d;%.2f\n", paciente.id,
            paciente.nome, paciente.prioritario, paciente.sintomas, paciente.idade, paciente.peso)
    }

    arquivoCsv.close()
    saidaCsv.close()

    // 5- Leia o arquivo paciente.csv e exiba com saida formatada
    //    Nao se esqueca dos titulos das colunas

    val arquivoCsvPaciente = FileReader("paciente.csv")
    val leitorCsvPaciente = Scanner(arquivoCsvPaciente).useDelimiter(";|\\n")

    println(String.format("%-5S %-30S %-20S %-13S %-3S %-6S", "ID", "NOME", "SINTOMAS","PROPRIETARIO", "IDADE","PESO"))

    while(leitorCsvPaciente.hasNext()){
        val id = leitorCsvPaciente.nextInt()
        val nome = leitorCsvPaciente.next()
        val proprietario = leitorCsvPaciente.nextBoolean()
        val sintomas = leitorCsvPaciente.next()
        val idade = leitorCsvPaciente.nextInt()
        val peso = leitorCsvPaciente.nextDouble()

        println(String.format("%05d %-30.30S %-20S %-13S %03d %6.2f", id, nome, sintomas, proprietario, idade, peso))
    }

    arquivoCsvPaciente.close()
    leitorCsvPaciente.close()
}
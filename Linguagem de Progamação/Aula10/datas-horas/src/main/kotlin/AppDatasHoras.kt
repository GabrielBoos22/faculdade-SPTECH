import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun main() {
    val hoje = LocalDate.now() // fornece a data atual

    println(hoje)

    val agora = LocalDateTime.now() // fornece a data e hora atuais
    println(agora)

    val nascimentoTexto = "2000-01-01"
    val dataNascimento = LocalDate.parse(nascimentoTexto)
    println(dataNascimento)

    // pegar do banco e exibir na tela
    val hojeBrasil =
            hoje.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
    println(hojeBrasil)

    // pegar do usuario e enviar ao banco
    val dataDoUsuario = "31/12/2000" // poderia ser JOptionPane
    val dataConvertida = LocalDate.parse(dataDoUsuario, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
    println(dataConvertida)

    // operações com datas
    val amanha = hoje.plusDays(1)
    println("amanhã: " + amanha)

    val ontem = hoje.minusDays(1)
    println("Ontem: " + ontem)

    val ha5anos = hoje.minusYears(5)

    val daquiMeiaHora = agora.plusMinutes(30)
    val ha15segundos = agora.minusSeconds(15)
    println("Daqui meia hora:" + daquiMeiaHora)
    println("Há 15 segundos:" + ha15segundos)

    
}
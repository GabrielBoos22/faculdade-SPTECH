import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import javax.swing.JOptionPane

fun main() {
    val data = JOptionPane.showInputDialog("Sua data de nascimento em dia/mes/ano (dd/MM/yyyy)")
    val dataConvertida = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
    println(dataConvertida)
    val dataAtual = LocalDate.now()

    // var ano = Period.between(dataConvertida, dataAtual).years
    var ano = ChronoUnit.YEARS.between(dataConvertida, dataAtual)
    // val dias = Period.between(dataConvertida, dataAtual).days obs:Não funciona para dias apenas para anos
    val dias = ChronoUnit.DAYS.between(dataConvertida, dataAtual)
    JOptionPane.showMessageDialog(null,"Voce tem $ano anos de vida")
    JOptionPane.showMessageDialog(null,"Voce tem $dias dias de vida")


}
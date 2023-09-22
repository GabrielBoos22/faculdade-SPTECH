import javax.swing.JOptionPane

fun main() {
    val horas = JOptionPane.showInputDialog("Digite a quantidade de horas do relógio:").toInt()
    val minutos = JOptionPane.showInputDialog("Digite a quantidade de minutos do relógio:").toInt()
    val segundos = JOptionPane.showInputDialog("Digite a quantidade de segundos do relógio:").toInt()

    val relogio = Relogio()

    val maisHoras = JOptionPane.showInputDialog("Digite a quantidade de horas a serem adicionadas:").toInt()
    val maisMinutos = JOptionPane.showInputDialog("Digite a quantidade de minutos a serem adicionadas:").toInt()
    val maisSegundos = JOptionPane.showInputDialog("Digite a quantidade de segundos a serem adicionadas:").toInt()

    relogio.adicionarTempo(horas, minutos, segundos)

    val horaAtual = relogio.horaAtual()
    println(horaAtual)
}
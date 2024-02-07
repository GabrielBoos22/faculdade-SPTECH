import javax.swing.JOptionPane

fun main() {
    val peso: Double = JOptionPane.showInputDialog("Digite o seu peso").toDouble();
    val altura: Double = JOptionPane.showInputDialog("Digite a sua altura em metros").toDouble();

    val imc = CalculaImc(peso, altura);

    exibeMensagem( "Seu IMC é ${"%.2f".format(imc)}")
}
fun CalculaImc(peso: Double, altura: Double): Double {
    var imcCalculado = peso / (altura * altura)
    return imcCalculado
}

fun exibeMensagem(frase: String) {
    JOptionPane.showMessageDialog(null, frase)
}
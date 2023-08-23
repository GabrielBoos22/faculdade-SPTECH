import javax.swing.JOptionPane

fun main() {
    val altura: Double = JOptionPane.showInputDialog("Digite a sua altura em m").toDouble();

    if(altura >= 1.8) {
        exibeMensagem("Você pode jogar basquete}")
    } else {
        exibeMensagem("Não pode jogar basquete")
    }

}
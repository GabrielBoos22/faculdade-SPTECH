import javax.swing.JOptionPane

fun main() {
    val ki: Int = JOptionPane.showInputDialog("Digite o seu ki (força)").toInt();

    exibeMensagem("Quando SSJ é ${ki * 50}")
    exibeMensagem("Quando SSJ2 é ${ki * 100}")
    exibeMensagem("Quando SSJ3 é ${ki * 200}")
    exibeMensagem("Quando God é ${ki * 500}")
}
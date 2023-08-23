import javax.swing.JOptionPane

fun main() {
    val nome: String = JOptionPane.showInputDialog("Digite o seu nome");
    val bairro: String = JOptionPane.showInputDialog("Digite o seu bairro");



    exibeMensagem( "Seu nome é ${nome} e seu bairro é ${bairro}")
}

fun exibeMensagem(frase: String) {
    JOptionPane.showMessageDialog(null, frase)
}
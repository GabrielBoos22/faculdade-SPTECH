import javax.swing.JOptionPane

fun main() {
    val Frase: String = JOptionPane.showInputDialog("Qual a frase?");
    val Qtd: Int = JOptionPane.showInputDialog("Qual a quantidade?").toInt();

    for (i in 1..Qtd){
        exibeMensagem(Frase)
    }
}
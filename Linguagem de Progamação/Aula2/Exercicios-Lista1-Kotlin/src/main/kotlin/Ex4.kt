import javax.swing.JOptionPane

fun main() {
    val gols: Int = JOptionPane.showInputDialog("Digite quantos gols").toInt();

    when(gols){
         0 -> JOptionPane.showMessageDialog(null, "Sem pontaria")
        in 1..2 -> JOptionPane.showMessageDialog(null, "Pontaria meia boca")
        in 3..5 -> JOptionPane.showMessageDialog(null, "Dá pro gasto")
        in 5..Int.MAX_VALUE  -> JOptionPane.showMessageDialog(null, "Artilheiro")
    }

}
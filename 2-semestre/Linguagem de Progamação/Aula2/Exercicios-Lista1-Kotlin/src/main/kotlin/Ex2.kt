import javax.swing.JOptionPane

fun main() {
    val idade: Double = JOptionPane.showInputDialog("Digite a sua idade").toDouble();

    if(verificaSePodeVotar(idade)){
        JOptionPane.showMessageDialog(null, "Você já pode votar")

    } else {
        JOptionPane.showMessageDialog(null, "Você não pode votar")
    }

}

fun verificaSePodeVotar(idade: Double): Boolean {
    var PodeVotar: Boolean = false
   if(idade >= 16) {
       PodeVotar = true
   }
    return PodeVotar
}
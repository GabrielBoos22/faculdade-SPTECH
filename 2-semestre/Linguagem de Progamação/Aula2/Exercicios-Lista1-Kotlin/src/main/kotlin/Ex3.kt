import javax.swing.JOptionPane

fun main() {
    val frase = "Eu S2 mamão!"

    for (i in 1..7 ){
        JOptionPane.showMessageDialog(null, frase)
        println(
            frase)
    }
}
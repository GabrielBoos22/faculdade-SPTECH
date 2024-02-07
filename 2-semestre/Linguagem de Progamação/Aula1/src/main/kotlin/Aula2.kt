import java.util.*
import javax.swing.JOptionPane

fun main() {
    // Como captar inputs de usuário da maneira "roots"

//    val sn = Scanner(System.`in`)
//    println("Digite seu nome: ")
//
//    val texto = sn.next()
//
//    println("\nO seu nome é $texto")

    val nomeUsuario =
    JOptionPane.showInputDialog("Digite seu nome!")
    JOptionPane.showMessageDialog(null, "O seu nome é $nomeUsuario")
    println("Seu nome é: ${nomeUsuario}")
}
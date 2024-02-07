import javax.swing.JOptionPane

fun main() {
    val salario: Double = JOptionPane.showInputDialog("Digite o seu salário").toDouble();

    if (salario < 0) {
        exibeMensagem("Salário inválido")
    } else {
        when(salario){
            in 0.00..1000.0 -> exibeMensagem("Classe C")
            in 1000.01..2000.0 -> exibeMensagem("Classe B")
            in 2000.01..5000.0 -> exibeMensagem("Classe A")
            in 5000.01..Double.MAX_VALUE  -> exibeMensagem("Classe AA")
        }
    }
}



import javax.swing.JOptionPane

fun main() {
    val nomeLinha: String = JOptionPane.showInputDialog("Digite o nome da linha de õnibus");
    val maiorTempo: Int = JOptionPane.showInputDialog("Digite o maior tempo de sua volta").toInt();
    val menorTempo: Int = JOptionPane.showInputDialog("Digite o menor tempo de sua volta").toInt();

    exibeMensagem("A linha $nomeLinha leva em média ${calculaMedia(maiorTempo, menorTempo)} minutos/volta")
}

fun calculaMedia(maiorTempo: Int, menorTempo: Int): Double {
    var media = (maiorTempo + menorTempo)/ 2.0
    return media
}
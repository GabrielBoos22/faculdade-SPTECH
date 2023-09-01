import javax.swing.JOptionPane

fun main() {
    var nome1 = JOptionPane.showInputDialog("Vamos começar a Luta! Nome do 1º lutador")
    var ataque1 =JOptionPane.showInputDialog("Vamos começar a Luta! Força de ataque do 1º lutador ").toDouble()
    var defesa1 = JOptionPane.showInputDialog("Vamos começar a Luta! Defesa do 1º lutador").toDouble()

    var nome2 = JOptionPane.showInputDialog("Vamos começar a Luta! Nome do 2º lutador")
    var ataque2 = JOptionPane.showInputDialog("Vamos começar a Luta! Força de ataque do 2º lutador ").toDouble()
    var defesa2 = JOptionPane.showInputDialog("Vamos começar a Luta! Defesa do 2º lutador").toDouble()

    val lutador1 = Lutador(nome1, ataque1, defesa1)
    val lutador2 = Lutador(nome2, ataque2, defesa2)

    for (i in 1..3){
        var opcao = JOptionPane.showInputDialog("1 - Lutador 1 bate no Lutador 2\r\n" +
                "2 - Lutador 2 bate no Lutador 1").toInt()

        if(opcao == 1){
            lutador2.apanhar(lutador1)
        } else if(opcao == 2){
            lutador1.apanhar(lutador2)
        }
        JOptionPane.showMessageDialog(null,"${lutador1.descrever()}")
        JOptionPane.showMessageDialog(null,"${lutador2.descrever()}")

        var opcao2 = JOptionPane.showInputDialog("     1 - Lutador 1 se concentra\r\n" +
                "     2 - Lutador 2 se concentra\r\n" +
                "     NDA - Nenhum se concentra")

        when(opcao2){
            "1" -> lutador1.concentrar()
            "2" -> lutador2.concentrar()
        }

        JOptionPane.showMessageDialog(null,"${lutador1.descrever()}")
        JOptionPane.showMessageDialog(null,"${lutador2.descrever()}")
    }

    if(lutador1.vidaAtual > lutador2.vidaAtual){
        print("O lutador 1 é o vencedor!")
    } else if(lutador1.vidaAtual < lutador2.vidaAtual){
        print("O lutador 2 é o vencedor!")
    } else {
        print("Empatou")
    }
}
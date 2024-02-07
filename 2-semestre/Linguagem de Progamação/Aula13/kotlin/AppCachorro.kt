import javax.swing.JOptionPane

fun main() {
    val cachorro1:Cachorro = Cachorro()
    cachorro1.nome = JOptionPane.showInputDialog("Qual o nome do cachorro?")
    cachorro1.idade = JOptionPane.showInputDialog("Qual a idade do cachorro?").toInt()
    cachorro1.peso = JOptionPane.showInputDialog("Qual o peso do cachorro?").toDouble()
    JOptionPane.showMessageDialog(null, cachorro1.getDescricao())
    JOptionPane.showMessageDialog(null, "O cachorro ${cachorro1.nome} ${if(cachorro1.getCorrerCachorro()) "corre atrás" else "não corre atrás"} quando ve uma moto")
    cachorro1.comer("Melancia", 2000.0)
    JOptionPane.showMessageDialog(null, cachorro1.getDescricao())

    val cachorro2:CachorroRaca = CachorroRaca()
    cachorro2.nome = JOptionPane.showInputDialog("Qual o nome do cachorro de raça?")
    cachorro2.idade = JOptionPane.showInputDialog("Qual a idade do cachorro de raça?").toInt()
    cachorro2.peso = JOptionPane.showInputDialog("Qual o peso do cachorro de raça?").toDouble()
    JOptionPane.showMessageDialog(null, cachorro2.getDescricao())
    JOptionPane.showMessageDialog(null, "O cachorro ${cachorro1.nome} ${if(cachorro1.getCorrerCachorro()) "corre atrás" else "não corre atrás"} quando ve uma moto")
    cachorro1.comer("Melão", 2000.0)
    JOptionPane.showMessageDialog(null, cachorro2.getDescricao())

    val cachorro3:CachorroViraLata = CachorroViraLata()
    cachorro3.nome = JOptionPane.showInputDialog("Qual o nome do cachorro vira lata?")
    cachorro3.idade = JOptionPane.showInputDialog("Qual a idade do cachorro vira lata?").toInt()
    cachorro3.peso = JOptionPane.showInputDialog("Qual o peso do cachorro vira lata?").toDouble()
    JOptionPane.showMessageDialog(null, cachorro3.getDescricao())
    JOptionPane.showMessageDialog(null, "O cachorro ${cachorro3.nome} ${if(cachorro3.getCorrerCachorro()) "corre atrás" else "não corre atrás"} quando ve uma moto")
    cachorro3.comer("Chocolate", 2000.0)
    JOptionPane.showMessageDialog(null, cachorro3.getDescricao())
}
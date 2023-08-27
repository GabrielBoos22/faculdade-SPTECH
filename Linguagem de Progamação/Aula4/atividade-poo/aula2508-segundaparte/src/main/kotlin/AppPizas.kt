import javax.swing.JOptionPane

fun main() {
    var pedidoPizza = PedidoPizza()

    pedidoPizza.preco = JOptionPane.showInputDialog("Qual o preço da pizza?").toDouble();
    pedidoPizza.sabor = JOptionPane.showInputDialog("Qual o sabor da pizza?");
    pedidoPizza.quantidadeAmigos = JOptionPane.showInputDialog("Qual a quantidade de amigos?").toInt();

    var cupom = JOptionPane.showInputDialog("Qual o cupom da pizza?");
    pedidoPizza.validarCupom(cupom)
    JOptionPane.showMessageDialog(null, "${pedidoPizza.descrever()}")

    var valor = pedidoPizza.obterValorPorAmigo()
    JOptionPane.showMessageDialog(null, "Cada amigo vai pagar: R$${valor}")
    JOptionPane.showMessageDialog(null, "Cada amigo vai pagar: R$${"%.2f".format(valor)}")
}
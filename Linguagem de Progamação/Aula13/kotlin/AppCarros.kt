import javax.swing.JOptionPane

fun main() {
//    val carro1 = Carro()
//
//    carro1.fabricante = JOptionPane.showInputDialog("Fabricante?")
//    carro1.modelo = JOptionPane.showInputDialog("Modelo?")
//
//    JOptionPane.showMessageDialog(null, carro1.getReacaoPessoas())
//    JOptionPane.showMessageDialog(null, carro1.getDescricao())
//
//    carro1.acelerar()
//    JOptionPane.showMessageDialog(null, carro1.getDescricao())
//
//    carro1.ligar()
//    carro1.acelerar()
//    JOptionPane.showMessageDialog(null, carro1.getDescricao())

    val carro2 = CarroLuxo()
    carro2.fabricante = JOptionPane.showInputDialog("Fabricante?")
    carro2.modelo = JOptionPane.showInputDialog("Modelo?")


    // como o método getReacaoPessoas() foi sobrescrito
    // terá o comportamento que ele tem na Super Classe
    // Num método sobrescrito, a assinatura (nome, argumentos e retorno)
    // devem ser IDENTICOS a da Super Classe
    // O corpo do método pode ser totalmente diferente

    JOptionPane.showMessageDialog(null, carro2.getReacaoPessoas())
    carro2.ligar()
    carro2.acelerar()
    JOptionPane.showMessageDialog(null, carro2.getDescricao())

    val carro3: CarroPobre = CarroPobre()
    carro3.fabricante = JOptionPane.showInputDialog("Fabricante do carro pobre?")
    carro3.modelo = JOptionPane.showInputDialog("Modelo do carro pobre?")
    carro3.ligar()
    carro3.acelerar()
    JOptionPane.showMessageDialog(null, carro3.getDescricao())
    carro3.frear()
}
import javax.swing.JOptionPane

fun main() {
    var produto1 = Produto()

        produto1.nome = JOptionPane.showInputDialog("Digite seu nome")
        var brinde = JOptionPane.showInputDialog("\"É brinde? 1 - É brinde / 2 - Não é brinde\"").toInt()
        if(brinde == 1){
            produto1.brinde = true

        }
        produto1.preco = JOptionPane.showInputDialog("Digite seu preco").toDouble()


    JOptionPane.showMessageDialog(null,"O produto ${produto1.nome} custa ${"{%.2f}".format(produto1.preco)}")


}
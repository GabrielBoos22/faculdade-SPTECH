import javax.swing.JOptionPane

fun main() {

    Conexao.criarTabelas();
    val repositorio = PizzaRepositorio()
    repositorio.iniciar()

while(true){

    val cadastrar = JOptionPane.showInputDialog(
        "Quer cadastrar uma nova pizza? S ou N"
    )
    if(cadastrar.uppercase() != "S"){
        break // sai do while
    }

    val novaPizza = Pizza()
    novaPizza.sabor = JOptionPane.showInputDialog("Qual sabor?")
    novaPizza.preco = JOptionPane.showInputDialog("Qual preco?").toDouble()
    novaPizza.quantidade = JOptionPane.showInputDialog("Qual quantidade?").toInt()

    repositorio.cadastrar(novaPizza)


}
    val ultimo = repositorio.getUltimoCodigo()

    val codigo = JOptionPane.showInputDialog(
        "Qual a pizza quer vender? Digite de 1 a $ultimo"
    ).toInt()

    if(codigo >= 1 && codigo <= ultimo){
        val vendeu = repositorio.vender(codigo)
        val pizza = repositorio.recuperar(codigo)
        if(vendeu){
            JOptionPane.showMessageDialog(null,
                "Quantidade da pizza ${pizza.sabor} atualizada para ${pizza.quantidade}")
        } else{
            JOptionPane.showMessageDialog(null,
                "A pizza de ${pizza.sabor} está zerada no estoque")
        }
    }

    val ultimo2 = repositorio.getUltimoCodigo()

    val codigo2 = JOptionPane.showInputDialog(
        "Qual a pizza quer mudar o preco? Digite de 1 a $ultimo"
    ).toInt()

    val preco = JOptionPane.showInputDialog(
        "Qual o novo preco? Digite de 1 a $ultimo"
    ).toDouble()

    val pizza2 = repositorio.buscarPizzaPreco(codigo2)
    if(pizza2 !== null){
        val atualizado = repositorio.mudarPizzaPreco(preco, codigo2)
        if(atualizado){
            JOptionPane.showMessageDialog(null,"Preço da pizza ${pizza2.preco} para ${repositorio.pegarNovoPreco(pizza2)}")
        } else {
            JOptionPane.showMessageDialog(null, "Pizza não encontrada")
        }
    }
}
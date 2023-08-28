import javax.swing.JOptionPane

class PedidoPizza {
    var sabor: String = ""
    var preco: Double = 0.0;
    var quantidadeAmigos: Int = 0;
    var cuponsUsados = mutableListOf<String>()

    fun descrever(): String{
        return "Pedido de pizza de $sabor, que custa R$$preco";
    }

    fun validarCupom(cupom:String){
        if(cupom == "#amopizza"){
            preco = 0.9 * preco
        }

        if (!cuponsUsados.contains(cupom)) {
            cuponsUsados.add(cupom)
            println("Cupom '$cupom' adicionado à lista de cupons usados.")
        } else {
            println("O cupom '$cupom' já foi usado anteriormente.")
        }
    }

    fun obterCuponsUsados(): String {
        if (cuponsUsados.isEmpty()) {
            return "Nenhum cupom usado foi registrado."
        } else {
            val cuponsTexto = cuponsUsados.joinToString("\n") { "- $it" }
            return "Cupons usados:\n$cuponsTexto"
        }

    }

    fun obterValorPorAmigo(): Double{
        return preco / quantidadeAmigos
    }
}
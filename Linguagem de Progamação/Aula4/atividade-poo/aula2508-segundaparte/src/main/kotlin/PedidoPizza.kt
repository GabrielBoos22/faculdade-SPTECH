import sun.security.ec.point.ProjectivePoint.Mutable

class PedidoPizza {
    var sabor: String = ""
    var preco: Double = 0.0;
    var quantidadeAmigos: Int = 0;
    var cuponsUsados: MutableList<String> = ();

    fun descrever(): String{
        return "Pedido de pizza de $sabor, que custa R$$preco";
    }

    fun validarCupom(cupom:String){
        if(cupom == "#amopizza"){
            preco = 0.9 * preco
        }
    }

    fun obterValorPorAmigo(): Double{
        return preco / quantidadeAmigos
    }
}
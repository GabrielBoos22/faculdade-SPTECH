package school.sptech.projetoestoque.service

import org.springframework.stereotype.Service
import school.sptech.projetoestoque.dominio.Cliente
import school.sptech.projetoestoque.dominio.Produto

@Service
class CalculadoraService {

    fun calcularPrecoVenda(precoCompra:Double): Double {
        val precoVenda: Double;
        if(precoCompra > 100){
            precoVenda = precoCompra * 1.07
        } else if(precoCompra > 10){
            precoVenda = precoCompra * 1.10
        } else {
            precoVenda = precoCompra * 1.15
        }

        return precoVenda
    }

    fun recalcularPrecoVendaAte500(precoCompra:Double): Double{
        var precoVenda = calcularPrecoVenda(precoCompra)
        if(precoCompra > 100){
            precoVenda *=  1.06/1.07
        } else if(precoCompra > 10){
            precoVenda *= 1.10/1.09
        } else {
            precoVenda *= 1.15/1.14
        }
        return precoVenda
    }

    fun recalcularPrecoVendaAte5000(precoCompra:Double): Double{
        var precoVenda = calcularPrecoVenda(precoCompra)
        if(precoCompra > 100){
            precoVenda *=  1.03/1.07
        } else if(precoCompra > 10){
            precoVenda *= 1.07/1.09
        } else {
            precoVenda *= 1.12/1.14
        }
        return precoVenda
    }

    fun recalcularPrecoVendaAte10000(precoCompra:Double):Double{
        var precoVenda = calcularPrecoVenda(precoCompra)
        if(precoCompra > 100){
            precoVenda *=  1.01/1.07
        } else if(precoCompra > 10){
            precoVenda *= 1.05/1.09
        } else {
            precoVenda *= 1.10/1.14
        }
        return precoVenda
    }

    fun calcularPrecoVendaFinal(produto: Double, pontosCliente: Int):Double {
        val produto = Produto(preco = produto)
        val cliente = Cliente(pontos = pontosCliente)
        val precoCompra = produto.preco!!
        val precoVendaFinal: Double;
        if(cliente.pontos!! > 5000){
            precoVendaFinal = calcularPrecoVenda(precoCompra) * 0.95
        } else if(cliente.pontos!! > 500){
            precoVendaFinal = calcularPrecoVenda(precoCompra) * 0.97
        } else {
            precoVendaFinal = calcularPrecoVenda(precoCompra) * 0.99
        }
        return precoVendaFinal; // você terá que codar aqui
    }
}
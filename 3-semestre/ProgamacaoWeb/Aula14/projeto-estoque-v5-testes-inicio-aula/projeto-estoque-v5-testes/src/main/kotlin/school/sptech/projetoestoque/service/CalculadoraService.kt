package school.sptech.projetoestoque.service

import org.springframework.stereotype.Service
import school.sptech.projetoestoque.dominio.Cliente
import school.sptech.projetoestoque.dominio.Produto

@Service
class CalculadoraService {

    fun calcularPrecoVenda(precoCompra:Double): Double {
        if(precoCompra < 0.0) throw IllegalArgumentException("Preço da compra não pode ser negativo")
        val porcentagem = when (precoCompra) {
            in 0.0..10.0 -> 1.15
            in 10.01..100.0 -> 1.10
            else -> 1.07
        }

        val precoVenda = precoCompra * porcentagem

        return precoVenda
    }

    fun calcularPrecoVendaFinal(produto: Produto, cliente: Cliente):Double {
        val precoVendaSemDesconto = calcularPrecoVenda(produto.preco!!)

        val descontoCliente = when(cliente.pontos) {
            in 0..500 -> 0.01
            in 501..5000 -> 0.03
            else -> 0.05
        }
        val precoVendaComDesconto = produto.preco!! * descontoCliente

        val precoFinal = precoVendaSemDesconto - precoVendaComDesconto
        return precoFinal
    }
}
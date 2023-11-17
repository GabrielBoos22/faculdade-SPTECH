package composicao

import java.time.LocalDateTime

class Conta {
    // Composição
    val abertura:LocalDateTime = LocalDateTime.now()

    val itens = mutableListOf<ItemConta>()

    fun adicionarItem(
        nomeItem: String,
        valor: Double,
        quantidade: Int
    ) {
        val novoItem = ItemConta()
        novoItem.nomeItem = nomeItem
        novoItem.valor = valor
        novoItem.quantidade = quantidade

        itens.add(novoItem)
    }

    fun getValorPagar():Double {
        var total = 0.0
        itens.forEach { total += it.valor * it.quantidade }
        total *= 1.1
        return total
    }
}
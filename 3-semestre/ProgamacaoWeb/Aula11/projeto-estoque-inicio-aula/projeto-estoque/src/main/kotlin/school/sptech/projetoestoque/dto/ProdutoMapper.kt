package school.sptech.projetoestoque.dto

import school.sptech.projetoestoque.dominio.Produto

class ProdutoMapper {
    fun toProdutoSimples(produto:Produto): ProdutoSimplesResponse{
        val dto = ProdutoSimplesResponse(
            id = produto.id,
            nome = produto.nome,
            fabricante = produto.fabricante!!.nome
        )
        return dto
    }

    fun toProdutoSimplesList(produtos:List<Produto>): List<ProdutoSimplesResponse>{

        return produtos.map { produto -> toProdutoSimples(produto)}
    }
}
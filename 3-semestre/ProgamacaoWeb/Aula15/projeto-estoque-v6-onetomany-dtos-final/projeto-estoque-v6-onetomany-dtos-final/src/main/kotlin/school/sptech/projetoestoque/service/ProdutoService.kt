package school.sptech.projetoestoque.service

import org.modelmapper.ModelMapper
import org.modelmapper.TypeToken
import org.springframework.http.HttpStatusCode
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import school.sptech.projetoestoque.dominio.Produto
import school.sptech.projetoestoque.dto.ProdutoContabilResponse
import school.sptech.projetoestoque.dto.ProdutoFinanceiroResponse
import school.sptech.projetoestoque.dto.ProdutoResponse
import school.sptech.projetoestoque.dto.ProdutoSimplesResponse
import school.sptech.projetoestoque.repository.FabricanteRepository
import school.sptech.projetoestoque.repository.ProdutoRepository

@Service
class ProdutoService(
    // criando as repository como parâmetros do construtor, não é necessário o uso do @Autowired
    val produtoRepository: ProdutoRepository,
    val fabricanteRepository: FabricanteRepository,
    val mapper: ModelMapper = ModelMapper()
) {

    fun validarLista(lista:List<*>) {
        if (lista.isEmpty()) {
            throw ResponseStatusException(HttpStatusCode.valueOf(204))
        }
    }

    fun validarIdProduto(id:Int) {
        if (!produtoRepository.existsById(id)) {
            throw ResponseStatusException(HttpStatusCode.valueOf(404))
        }
    }

    fun getListaSimples():List<ProdutoSimplesResponse> {
        val lista = produtoRepository.findSimples()
        validarLista(lista)

        val dtos = lista.map {
            mapper.map(it, ProdutoSimplesResponse::class.java)
        }
        return dtos
    }

    fun getListaContabil():List<ProdutoContabilResponse> {
        val lista = produtoRepository.findContabil()
        validarLista(lista)

        val dtos = lista.map {
            mapper.map(it, ProdutoContabilResponse::class.java)
        }

        return dtos
    }

    fun getListaFinanceiro():List<ProdutoFinanceiroResponse> {
        val lista = produtoRepository.findAll()
        validarLista(lista)

        val dtos = lista.map {
            mapper.map(it, ProdutoFinanceiroResponse::class.java)
        }

        return dtos
    }

    fun salvar(produto:Produto): ProdutoResponse {
        if (!fabricanteRepository.existsById(produto.fabricante!!.id)) {
            throw ResponseStatusException(
                HttpStatusCode.valueOf(404))
        }

        val salvo = produtoRepository.save(produto)

        val dto = mapper.map(salvo, ProdutoResponse::class.java)

        return dto
    }

    fun getSimples(id:Int):ProdutoSimplesResponse {
        validarIdProduto(id)

        val produto = produtoRepository.findById(id).get()

        val dto = mapper.map(
            produto,
            ProdutoSimplesResponse::class.java
        )
        return dto
    }

    fun get(id:Int):ProdutoResponse {
        validarIdProduto(id)

        val produto = produtoRepository.findById(id).get()

        val dto = mapper.map(
            produto,
            ProdutoResponse::class.java
        )
        return dto
    }

    fun getLista():List<ProdutoResponse> {
        val lista = produtoRepository.findAll()
        validarLista(lista)

        val listaDtos: List<ProdutoResponse> = mapper.map(
            lista,
            object : TypeToken<List<ProdutoResponse>>() {}.type
        )

        /*
        O código acima faz o mesmo que:
        val listaDtos = lista.map {
            mapper.map(it, ProdutoSimplesResponse::class.java)
        }
        */

        return listaDtos
    }

    fun getListaPorFabricante(idFabricante:Int):List<Produto> {
        val lista = produtoRepository.findByFabricanteId(idFabricante)
        validarLista(lista)

        return lista
    }

    fun getListaPorQuantidade(qtdMin: Int,
                              qtdMax: Int):List<Produto> {
        val lista = produtoRepository.findByQtdEstoqueBetween(qtdMin, qtdMax)
        validarLista(lista)

        return lista
    }

}
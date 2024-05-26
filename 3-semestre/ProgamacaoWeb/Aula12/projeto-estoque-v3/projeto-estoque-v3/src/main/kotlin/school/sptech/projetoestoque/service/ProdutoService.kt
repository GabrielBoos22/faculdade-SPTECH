package school.sptech.projetoestoque.service

import org.apache.coyote.Response
import org.modelmapper.ModelMapper
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.server.ResponseStatusException
import school.sptech.projetoestoque.dominio.Produto
import school.sptech.projetoestoque.dto.ProdutoContabilResponse
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
    fun getSimples() : ResponseEntity<List<ProdutoSimplesResponse>> {
        val produtos = produtoRepository.findSimples()
        validarLista(produtos)

        val dtos = produtos.map{
            mapper.map(it, ProdutoSimplesResponse::class.java)
        }

        return ResponseEntity.status(200).body(dtos)
    }

    fun getListaContabil() : ResponseEntity<List<ProdutoContabilResponse>> {
        val lista = produtoRepository.findContabil()

        validarLista(lista)
        val dtos = lista.map{
            mapper.map(it, ProdutoContabilResponse::class.java)
        }

        return ResponseEntity.status(200).body(dtos)
    }

    fun getProduto(): ResponseEntity<List<Produto>> {
        val produtos = produtoRepository.findAll()

        validarLista(produtos)
        return ResponseEntity.status(200).body(produtos)
    }

    fun salvar(produto: Produto){
        if (!fabricanteRepository.existsById(produto.fabricante!!.id)){
            throw ResponseStatusException(HttpStatusCode.valueOf(404))
        }
        produtoRepository.save(produto)
    }

    fun getByFabricanteId(id: Int): ProdutoSimplesResponse {
        validarIdProduto(id)
        val produto = produtoRepository.findById(id).get()

        val dto = mapper.map(
            produto,
            ProdutoSimplesResponse::class.java
        )
        return dto
    }

     fun validarIdProduto(id: Int) {
        if(!produtoRepository.existsById(id)){
            throw ResponseStatusException(HttpStatusCode.valueOf(404))
        }
    }

    fun validarLista(lista: List<*>){
        if(lista.isEmpty()){
            throw ResponseStatusException(HttpStatusCode.valueOf(204))
        }
    }

}
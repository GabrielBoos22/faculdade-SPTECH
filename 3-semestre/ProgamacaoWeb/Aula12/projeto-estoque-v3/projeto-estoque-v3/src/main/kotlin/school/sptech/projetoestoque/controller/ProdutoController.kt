package school.sptech.projetoestoque.controller

import jakarta.validation.Valid
import org.modelmapper.ModelMapper
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import school.sptech.projetoestoque.dominio.Produto
import school.sptech.projetoestoque.dto.ProdutoCadastroRequest
import school.sptech.projetoestoque.dto.ProdutoContabilResponse
import school.sptech.projetoestoque.dto.ProdutoSimplesResponse
import school.sptech.projetoestoque.repository.FabricanteRepository
import school.sptech.projetoestoque.repository.ProdutoRepository
import school.sptech.projetoestoque.service.ProdutoService

@RestController
@RequestMapping("/produtos")
class ProdutoController(
    // criando as repository como parâmetros do construtor, não é necessário o uso do @Autowired
    val produtoService: ProdutoService,
    val produtoRepository: ProdutoRepository,
    val fabricanteRepository: FabricanteRepository,
    val mapper: ModelMapper = ModelMapper()
) {

    @GetMapping("/simples")
    fun listarSimples() : ResponseEntity<List<ProdutoSimplesResponse>> {
        val dtos = produtoService.getSimples()

        return dtos
    }


    @PostMapping
    fun criar(@RequestBody @Valid novoProduto: Produto) : ResponseEntity<Produto> {
        produtoService.salvar(novoProduto)
        return ResponseEntity.status(201).body(novoProduto)
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id:Int, @RequestBody @Valid produto: Produto) : ResponseEntity<Produto> {
        // Verificando se o fabricante do produto existe, caso não, retorna 404
        produto.id = id
        produtoService.salvar(produto)
        return ResponseEntity.status(200).body(produto)
    }

    @GetMapping
    fun listar() : ResponseEntity<List<Produto>> {
        val produtos = produtoService.getProduto()
        return produtos
    }

    @GetMapping("/filtro-fabricante/{fabricanteId}")
    fun buscarPorIdFabricante(@PathVariable fabricanteId: Int):
            ResponseEntity<List<Produto>> {

        val produtos =
            produtoRepository.findByFabricanteId(fabricanteId)

        if (produtos.isEmpty()) {
            return ResponseEntity.status(204).build()
        }
        return ResponseEntity.status(200).body(produtos)
    }

    @GetMapping("/filtro-qtd")
    fun buscarPorIdFabricante(
        @RequestParam qtdMin: Int, // @RequestParam utilizado para fazer buscas personalizadas que sejam diferentes do id
        @RequestParam qtdMax: Int):
            ResponseEntity<List<Produto>> {

        val produtos =
            produtoRepository.findByQtdEstoqueBetween(qtdMin, qtdMax)

        if (produtos.isEmpty()) {
            return ResponseEntity.status(204).build()
        }
        return ResponseEntity.status(200).body(produtos)
    }

    @GetMapping("/contabil")
    fun listarContabil(): ResponseEntity<List<ProdutoContabilResponse>>{
        val produtos =
            produtoRepository.findContabil()

        if (produtos.isEmpty()) {
            return ResponseEntity.status(204).build()
        }

        val dtos = produtos.map{
            mapper.map(it, ProdutoContabilResponse::class.java)
        }

        return ResponseEntity.status(200).body(dtos)
    }
}
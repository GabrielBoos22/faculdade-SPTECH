package school.sptech.projetoestoque.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.server.ResponseStatusException
import school.sptech.projetoestoque.dominio.Produto
import school.sptech.projetoestoque.dto.ProdutoContabilResponse
import school.sptech.projetoestoque.dto.ProdutoSimplesResponse
import school.sptech.projetoestoque.repository.FabricanteRepository
import school.sptech.projetoestoque.repository.ProdutoRepository
import java.util.*

class ProdutoServiceTest {

    lateinit var produtoRepository: ProdutoRepository
    lateinit var fabricanteRepository: FabricanteRepository
    lateinit var service: ProdutoService

    @BeforeEach
    fun iniciar(){
        produtoRepository = mock(ProdutoRepository::class.java)
        fabricanteRepository = mock(FabricanteRepository::class.java)
        service = ProdutoService(produtoRepository, fabricanteRepository)
    }
    @Test
    fun `Busca o produto da tabela, retorna a lista esperada`(){
        val listaEsperada = listOf(
            Produto(id=2, nome= "mel"),
            Produto(id = 2, nome = "aveia"))

        `when`(produtoRepository.findAll())
            .thenReturn(listaEsperada)

        val resultado = service.getLista()

        assertEquals(listaEsperada.size, resultado.size)
    }

    @Test
    fun `Se a tabela estiver vazia, deve lançar uma exceção`(){

        `when`(produtoRepository.findAll()).thenReturn(listOf())

        val excecao = assertThrows(ResponseStatusException::class.java) {
            service.getLista()
        }

        assertEquals(204, excecao.statusCode.value())
    }
    @Test
    fun `Busca o produto da tabela, retorna o produto esperado`(){
        val listaEsperada = Produto(id=2, nome= "mel")
        val id = 1
        `when`( produtoRepository.findById(id))
            .thenReturn(Optional.of(listaEsperada))

        `when`( produtoRepository.existsById(id))
            .thenReturn(true)
        val resultado = service.getSimples(id)

        assertEquals(listaEsperada.id, resultado.id)
        assertEquals(listaEsperada.nome, resultado.nome)
    }

    @Test
    fun `Verifica status 200 e lista retornada `(){7
        val produtos = listOf(
            Produto(id=2, nome= "mel", qtdEstoque = 3, 10.0),
            Produto(id=1, nome= "joao", qtdEstoque = 1, 20.0))

        val listaEsperada = listOf(
            ProdutoContabilResponse(id=2, nome= "mel", qtdEstoque = 3, 10.0),
            ProdutoContabilResponse(id=1, nome= "joao", qtdEstoque = 1, 20.0))

        `when`(produtoRepository.findContabil()).thenReturn(produtos)

        val resultado = service.getListaContabil()
        assertEquals(listaEsperada, resultado)
    }

    @Test
    fun `Verifica status 204 quando lista retorna vazia`(){

        `when`(produtoRepository.findContabil()).thenReturn(listOf())
        val excecao = assertThrows(ResponseStatusException::class.java) {
            service.getListaContabil()
        }

        assertEquals(204, excecao.statusCode.value())
    }

}
package school.sptech.projetoestoque.service

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.springframework.web.server.ResponseStatusException
import school.sptech.projetoestoque.dominio.Carro
import school.sptech.projetoestoque.dominio.Fabricante
import school.sptech.projetoestoque.dto.CarroCadastroRequest
import school.sptech.projetoestoque.dto.CarroSimplesResponse
import school.sptech.projetoestoque.dto.FabricanteCadastroRequest
import school.sptech.projetoestoque.repository.CarroRepository
import school.sptech.projetoestoque.repository.FabricanteRepository

class CarroServiceTest {

    lateinit var carroRepository: CarroRepository
    lateinit var fabricanteRepository: FabricanteRepository
    lateinit var fabricanteService: FabricanteService
    lateinit var service: CarroService

    @BeforeEach
    fun iniciar() {
        carroRepository = mock(CarroRepository::class.java)
        fabricanteRepository = mock(FabricanteRepository::class.java)
        fabricanteService = FabricanteService(fabricanteRepository)
        service = CarroService(carroRepository, fabricanteService)
    }

    @DisplayName("Caso o código do fabricante seja nulo, uma exceção com status 406 deve ocorrer")
    @Test
    fun postCarroSemCodigoFabricante() {
        val carroSemCodigoFabricante = CarroCadastroRequest(
            modelo = "m1",
            potencia = 1.0,
            precoCompra = 10000.0,
            fabricante = FabricanteCadastroRequest()
        )

        val excecao = assertThrows(ResponseStatusException::class.java) {
            service.salvar(carroSemCodigoFabricante)
        }

        assertEquals(406, excecao.statusCode.value())
        assertEquals("Código do fabricante não indicado", excecao.reason)
    }

    @DisplayName("Caso o código do fabricante seja inválido, uma exceção com status 404 deve ocorrer")
    @Test
    fun postCarroFabricanteInvalido() {
        val codigoNaoExistente = 999

        val carroSemCodigoFabricante = CarroCadastroRequest(
            modelo = "m1",
            potencia = 1.0,
            precoCompra = 10000.0,
            fabricante = FabricanteCadastroRequest(codigo = codigoNaoExistente)
        )

        `when`(fabricanteRepository.existsById(codigoNaoExistente)).thenReturn(false)

        val excecao = assertThrows(ResponseStatusException::class.java) {
            service.salvar(carroSemCodigoFabricante)
        }

        assertEquals(404, excecao.statusCode.value())
        assertEquals("Fabricante $codigoNaoExistente não encontrado no sistema", excecao.reason)
    }

    @DisplayName("getListaSimples() - Se houverem carros na tabela, deve retornar os mesmos elementos 'simples' deles")
    @Test
    fun getListaSimplesComDados() {
        val listaEsperada = listOf(
            Carro(codigo = 1, modelo = "Fit", potencia = 1.5, fabricante = Fabricante(nome = "Honda")),
            Carro(codigo = 2, modelo = "XC60", potencia = 2.0, fabricante = Fabricante(nome = "Volvo"))
        )

        `when`(carroRepository.findAll()).thenReturn(listaEsperada)

        val resultado = service.getListaSimples()

        assertEquals(listaEsperada.size, resultado.size)

        for (c in 0..1) {
            assertEquals(listaEsperada[c].codigo, resultado[c].codigo)
            assertEquals(
                "${listaEsperada[c].fabricante?.nome} ${listaEsperada[c].modelo} ${listaEsperada[c].potencia}",
                resultado[c].getDescricao()
            )
        }
    }


    @DisplayName("getListaSimples() - Se a tabela de carros estiver vazia, deve lançar uma exceção com status 204")
    @Test
    fun getListaSimplesSemDados() {
        `when`(carroRepository.findAll()).thenReturn(listOf())

        val excecao = assertThrows(ResponseStatusException::class.java) {
            service.getListaSimples()
        }

        assertEquals(204, excecao.statusCode.value())
    }

    @DisplayName("getListaVenda() - Se houverem carros na tabela, deve retornar os mesmos elementos 'venda' deles")
    @Test
    fun getListaVendaComDados() {
        val listaEsperada = listOf(
            Carro(
                codigo = 1,
                modelo = "Argo",
                potencia = 1.5,
                precoCompra = 10000.0,
                importado = false,
                fabricante = Fabricante(nome = "Fiat")
            ),
            Carro(
                codigo = 2,
                modelo = "XC60",
                potencia = 2.0,
                precoCompra = 10000.0,
                importado = true,
                fabricante = Fabricante(nome = "Volvo")
            )
        )

        `when`(carroRepository.findAll()).thenReturn(listaEsperada)

        val resultado = service.getListaVenda()

        assertEquals(listaEsperada.size, resultado.size)

        for (c in 0..1) {
            assertEquals(listaEsperada[c].codigo, resultado[c].codigo)
            assertEquals(listaEsperada[c].modelo, resultado[c].modelo)
            assertEquals(listaEsperada[c].fabricante?.nome, resultado[c].getNomeFabricante())
            assertEquals(listaEsperada[c].potencia, resultado[c].potencia)
        }
        assertEquals(listaEsperada[0].precoCompra!! * 1.1, resultado[0].getPrecoVenda())
        assertEquals(listaEsperada[1].precoCompra!! * 1.15, resultado[1].getPrecoVenda())
    }

    @DisplayName("getListaVenda() - Se a tabela de carros estiver vazia, deve lançar uma exceção com status 204")
    @Test
    fun getListaVendaSemDados() {
        `when`(carroRepository.findAll()).thenReturn(listOf())

        val excecao = assertThrows(ResponseStatusException::class.java) {
            service.getListaVenda()
        }

        assertEquals(204, excecao.statusCode.value())
    }

}

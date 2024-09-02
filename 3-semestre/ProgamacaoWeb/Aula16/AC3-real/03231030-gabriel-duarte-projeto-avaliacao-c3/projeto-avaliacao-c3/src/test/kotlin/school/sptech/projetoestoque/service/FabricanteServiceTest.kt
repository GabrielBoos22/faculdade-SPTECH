package school.sptech.projetoestoque.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.springframework.web.server.ResponseStatusException
import school.sptech.projetoestoque.dominio.Carro
import school.sptech.projetoestoque.dominio.Fabricante
import school.sptech.projetoestoque.repository.FabricanteRepository

class FabricanteServiceTest {

    lateinit var fabricanteRepository: FabricanteRepository
    lateinit var service: FabricanteService

    @BeforeEach
    fun iniciar() {
        fabricanteRepository = mock(FabricanteRepository::class.java)
        service = FabricanteService(fabricanteRepository)
    }

    @DisplayName("getListaRelatorio() - Se houverem fabricantes na tabela, deve retornar os mesmos elementos 'relatorio' deles")
    @Test
    fun getListaRelatorioComDados() {
        val listaEsperada = listOf(
            Fabricante(codigo = 1, nome = "Volvo", paisOrigem = "Suécia", carros = listOf(Carro(), Carro())),
            Fabricante(codigo = 2, nome = "Honda", paisOrigem = "Japão", carros = listOf(Carro(), Carro(), Carro()))
        )

        `when`(fabricanteRepository.findAll()).thenReturn(listaEsperada)

        val resultado = service.getListaRelatorio()

        assertEquals(listaEsperada.size, resultado.size)

        for (c in 0..1) {
            assertEquals(listaEsperada[c].codigo, resultado[c].codigo)
            assertEquals(listaEsperada[c].nome, resultado[c].nome)
            assertEquals(listaEsperada[c].carros?.size, resultado[c].getModelos())
        }
    }

    @DisplayName("getListaRelatorio() - Se a tabela de fabricantes estiver vazia, deve lançar uma exceção com status 204")
    @Test
    fun getListaRelatorioSemDados() {
        `when`(fabricanteRepository.findAll()).thenReturn(listOf())

        val excecao = assertThrows(ResponseStatusException::class.java) {
            service.getListaRelatorio()
        }

        assertEquals(204, excecao.statusCode.value())
    }

}

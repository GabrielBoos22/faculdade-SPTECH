package school.sptech.projetoestoque.service

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import org.junit.jupiter.params.provider.CsvSource

class CalculadoraServiceTest {
    val service = CalculadoraService()
    @Test
    fun `O valor de venda deve ser o valor de compra +15%`() {

        val resultado = service.calcularPrecoVenda(5.00)
        val resultado2 = service.calcularPrecoVenda(10.00)

        assertEquals(5.75, resultado)
        assertEquals(11.50, resultado2)
    }
    @Test
    fun `O valor de venda deve ser o valor de compra +10%`() {

        val resultado = service.calcularPrecoVenda(50.00)
        val resultado2 = service.calcularPrecoVenda(100.00)
        assertEquals(55.0, resultado,0.001)

        assertEquals(110.0, resultado2,0.001)
    }

    @ParameterizedTest
    // @CsvSource(value = ["5, 5.75", "7, 8.05", "11, 12.1", "100.01, 107.0107", "200, 214"])
    @CsvFileSource(resources = ["/cenarios-preco.csv"])
    fun `Calcular preco venda`(precoCompra: Double, resultado:Double) {
        val resultadoTeste = service.calcularPrecoVenda(precoCompra)

        assertEquals(resultado, resultadoTeste,0.001)
    }

    @ParameterizedTest
    @CsvSource(value = [
     "10, 500, 11,40", "50, 1000, 53,50", "3000, 10000,3060"
     ])
    fun `calcularPrecoVendaFinal`(produto: Double, pontosCliente: Int, precoVendaEsperado:Double) {
        val resultadoTeste = service.calcularPrecoVendaFinal(produto, pontosCliente)

        assertEquals(precoVendaEsperado, resultadoTeste,0.001)
    }
}


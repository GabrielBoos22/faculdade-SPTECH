package school.sptech.projetoestoque.service

import org.modelmapper.ModelMapper
import org.springframework.http.HttpStatusCode
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import school.sptech.projetoestoque.dominio.Carro
import school.sptech.projetoestoque.dto.CarroCadastroRequest
import school.sptech.projetoestoque.dto.CarroSimplesResponse
import school.sptech.projetoestoque.dto.CarroVendaResponse
import school.sptech.projetoestoque.repository.CarroRepository

@Service
class CarroService(
    val carroRepository: CarroRepository,
    val fabricanteService: FabricanteService,
    val mapper: ModelMapper = ModelMapper()
) {

    fun validarLista(lista: List<*>) {
        if (lista.isEmpty()) {
            throw ResponseStatusException(HttpStatusCode.valueOf(204))
        }
    }

    fun validarIdProduto(id: Int) {
        if (!carroRepository.existsById(id)) {
            throw ResponseStatusException(HttpStatusCode.valueOf(404), "Carro $id não encontrado no sistema")
        }
    }

    fun getListaSimples(): List<CarroSimplesResponse> {
        val carros = carroRepository.findAll()
        validarLista(carros)

        val dtos = carros.map {
            mapper.map(it, CarroSimplesResponse::class.java)
        }
        return dtos
    }

    fun getListaVenda(): List<CarroVendaResponse> {
        // erro
        val carros = carroRepository.findAll()
        validarLista(carros)

        val dtos = carros.map {
            mapper.map(it, CarroVendaResponse::class.java)
        }
        return dtos
    }


    fun salvar(carro: CarroCadastroRequest): Carro {

        if(carro.fabricante!!.codigo == null) return throw ResponseStatusException(
            HttpStatusCode.valueOf(406), "Código do fabricante não indicado")

        fabricanteService.validarIdFabricante(carro.fabricante!!.codigo!!) // método incompleto

        val entidade = mapper.map(carro, Carro::class.java)
        val carro = carroRepository.save(entidade)
        return carro
    }

    fun getSimples(id: Int): CarroSimplesResponse {
        validarIdProduto(id) // incompleto

        // erro
        return CarroSimplesResponse()
    }

}
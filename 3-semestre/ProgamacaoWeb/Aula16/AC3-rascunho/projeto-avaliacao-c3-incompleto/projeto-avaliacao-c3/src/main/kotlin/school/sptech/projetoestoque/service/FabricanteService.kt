package school.sptech.projetoestoque.service

import org.modelmapper.ModelMapper
import org.springframework.http.HttpStatusCode
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import school.sptech.projetoestoque.dominio.Carro
import school.sptech.projetoestoque.dominio.Fabricante
import school.sptech.projetoestoque.dto.CarroVendaResponse
import school.sptech.projetoestoque.dto.FabricanteCadastroRequest
import school.sptech.projetoestoque.dto.FabricanteRelatorioResponse
import school.sptech.projetoestoque.repository.FabricanteRepository

@Service
class FabricanteService(
    var fabricanteRepository: FabricanteRepository,
    var mapper: ModelMapper = ModelMapper()
) {

    fun validarLista(lista:List<*>) {
        if (lista.isEmpty()) {
            throw ResponseStatusException(HttpStatusCode.valueOf(204))
        }
    }

    fun salvar(fabricante: FabricanteCadastroRequest): Fabricante? {

        val fabricanteASerSalvo = mapper.map(fabricante, Fabricante::class.java)
        val fabricanteSalvo = fabricanteRepository.save(fabricanteASerSalvo)
        return fabricanteSalvo
    }

    fun getListaRelatorio(): List<FabricanteRelatorioResponse> {
        val fabricantes = fabricanteRepository.findAll()
        validarLista(fabricantes)

        val dtos = fabricantes.map {
            mapper.map(it, FabricanteRelatorioResponse::class.java)
        }
        return dtos
    }

    fun validarIdFabricante(id:Int) {

        if (!fabricanteRepository.existsById(id)) {
            throw ResponseStatusException(HttpStatusCode.valueOf(404),
                "Fabricante $id não encontrado no sistema")
        }

    }
}
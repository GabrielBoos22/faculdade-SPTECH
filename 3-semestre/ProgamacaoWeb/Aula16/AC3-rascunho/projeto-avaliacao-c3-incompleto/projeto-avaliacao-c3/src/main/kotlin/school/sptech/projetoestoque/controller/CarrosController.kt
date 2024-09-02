package school.sptech.projetoestoque.controller

import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import school.sptech.projetoestoque.dominio.Carro
import school.sptech.projetoestoque.dto.CarroCadastroRequest
import school.sptech.projetoestoque.dto.CarroSimplesResponse
import school.sptech.projetoestoque.dto.CarroVendaResponse
import school.sptech.projetoestoque.service.CarroService

@RestController
@RequestMapping("/carros")
class CarrosController(
    val carroService: CarroService
) {
    @PostMapping
    fun criar(@RequestBody @Valid novoCarro: CarroCadastroRequest) : ResponseEntity<Carro> {
        val carro = carroService.salvar(novoCarro)
        return ResponseEntity.status(201).body(carro)
    }

    @GetMapping("/simples")
    fun listarSimples() : ResponseEntity<List<CarroSimplesResponse>> {
        val lista = carroService.getListaSimples()
        return ResponseEntity.status(200).body(lista)
    }

    @GetMapping("/venda")
    fun listarContabil() : ResponseEntity<List<CarroVendaResponse>> {
        val lista = carroService.getListaVenda()
        return ResponseEntity.status(200).body(lista)
    }

}
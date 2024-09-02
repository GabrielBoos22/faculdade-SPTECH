package school.sptech.projetoestoque.controller

import jakarta.validation.Valid
import org.apache.coyote.Response
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import school.sptech.projetoestoque.dominio.Fabricante
import school.sptech.projetoestoque.dto.FabricanteCadastroRequest
import school.sptech.projetoestoque.dto.FabricanteRelatorioResponse
import school.sptech.projetoestoque.service.FabricanteService

@RestController
@RequestMapping("/fabricantes")
class FabricanteController(
    val fabricanteService: FabricanteService
) {
    @PostMapping
    fun criar(@RequestBody @Valid novoFabricante: FabricanteCadastroRequest) : ResponseEntity<Fabricante> {
        val fabricante = fabricanteService.salvar(novoFabricante)
        return ResponseEntity.status(201).body(fabricante)
    }

    @GetMapping("/relatorio")
    fun listar(): ResponseEntity<List<FabricanteRelatorioResponse>> {
        val lista = fabricanteService.getListaRelatorio()
        return ResponseEntity.status(200).body(lista)
    }
}
package school.sptech.projeto03verboshttp

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/medicamentos")
class MedicamentoController {

    // lista vazia de objetos do tipo Medicamento
    val medicamentos = mutableListOf<Medicamento>()

    @PostMapping
    fun cadastrar(@RequestBody novoMedicamento: Medicamento): ResponseEntity<Medicamento> {
        medicamentos.add(novoMedicamento)
        return ResponseEntity.status(201).body(novoMedicamento)
    }

    @GetMapping
    fun lista(): ResponseEntity<List<Medicamento>> {
        if (medicamentos.isEmpty()) {
            return ResponseEntity.status(204).build()
        }
        return ResponseEntity.status(200).body(medicamentos)
    }

    @GetMapping("/{indice}")
    fun getUm(@PathVariable indice:Int): ResponseEntity<Medicamento> {
        try {
            return ResponseEntity.status(200).body(medicamentos[indice])
        } catch (exception:Exception) {
            return ResponseEntity.status(404).build()
        }
    }

    @PatchMapping("/{indice}")
    fun patch(
        @PathVariable indice: Int,
        @RequestBody atualizacao: PatchMedicamento
    ): ResponseEntity<Medicamento> {
        try {
            val medicamento = medicamentos[indice]
            medicamento.valorUnd = atualizacao.novoValorUnd
            medicamento.quantidade += atualizacao.quantidadeEntrada
            return ResponseEntity.status(200).body(medicamento)
        } catch (exception:Exception) {
            return ResponseEntity.status(404).build()
        }
    }

}





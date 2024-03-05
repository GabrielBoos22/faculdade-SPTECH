import org.apache.coyote.Request
import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.RequestEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/medicamentos")
class MedicamentoController {
    val listaMedicamento: MutableList<Medicamento> = mutableListOf()
    @PostMapping
    fun adicionar(@RequestBody medicamento: Medicamento): ResponseEntity<Medicamento> {
        validarCadastroMedicamento(medicamento)
        listaMedicamento.add(medicamento)
        return ResponseEntity.status(HttpStatus.CREATED).body(medicamento)
    }

    @GetMapping
    fun listar(): ResponseEntity<List<Medicamento>>{
        if(listaMedicamento.isEmpty()){
            return ResponseEntity.status(204).build()
        }
        return ResponseEntity.status(200).body(listaMedicamento)
    }

    @GetMapping("/{indice}")
    fun listarPorIndice(@PathVariable indice: Int): ResponseEntity<Medicamento>{
        if(existeMedicamento(indice)){
            return ResponseEntity.status(200).body(listaMedicamento[indice])
        }
        return ResponseEntity.status(404).build()
    }

    @PatchMapping("/{indice}")
    fun edita(@RequestBody body: MedicamentoAlterado, @PathVariable indice: Int): ResponseEntity<Medicamento?>{
        try{
            val novoMedicamento = Medicamento(
                codigo = listaMedicamento[indice].codigo,
                nome = listaMedicamento[indice].nome,
                valorUnd = body.novoValorUnd,
                quantidade = body.quantidadeEntrada,
                precisaReceita = listaMedicamento[indice].precisaReceita
            )
            listaMedicamento.set(indice, novoMedicamento)
            return ResponseEntity.status(200).body(novoMedicamento)
        } catch(exception: Exception){
            return ResponseEntity.status(204).build()
        }

    }


    fun existeMedicamento(indice: Int): Boolean {
        return indice >= 0 && indice < listaMedicamento.size
    }

    fun validarCadastroMedicamento(medicamento: Medicamento) {
        if (medicamento.nome.length < 2) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome deve ter pelo menos 2 letras")
        }
        if (medicamento.valorUnd < 0.01) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Valor deve ser no mínimo 0.01")
        }
        if (medicamento.quantidade < 0) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Quantidade deve ser no mínimo 0")
        }
    }
}
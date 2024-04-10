package sptech.projetojpa3.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import sptech.projetojpa3.repository.CompositorRepository
import sptech.projetojpa3.repository.MusicaRepository

@RestController
@RequestMapping("/compositores")
class CompositorController {
    @Autowired
    lateinit var repository: CompositorRepository

    @PatchMapping(value = ["/documento/{codigo}"],
        consumes = ["text/csv"])
    fun patchCsv(
        @PathVariable codigo: Int,
        @RequestBody novoCsv: ByteArray
    ): ResponseEntity<Void> {
        val compositor = repository.findById(codigo).get()
        compositor.csv = novoCsv
        repository.save(compositor)

        return ResponseEntity.status(204).build()
    }

    @GetMapping(value = ["/compositores/documento/{codigo}"],
        produces = ["text/csv"])
    fun getCsv(@PathVariable codigo: Int): ResponseEntity<ByteArray> {
        val musica = repository.recuperarCsv(codigo)

        return ResponseEntity.status(200).body(musica)
    }


}
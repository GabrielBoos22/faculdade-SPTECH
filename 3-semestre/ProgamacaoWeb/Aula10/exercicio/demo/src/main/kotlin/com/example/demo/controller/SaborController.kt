package com.example.projetoestoque.controller

import com.example.demo.domain.Sabor
import com.example.projetoestoque.repository.SaborRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sabores")
class SaborController(
    private val saborRepository: SaborRepository,
) {

    @GetMapping("/top3-caras")
    fun getTop3PizzasMaisCaras(): ResponseEntity<List<Sabor>> {
        val sabores = saborRepository.findTop3ByOrderByPrecoBaseDesc()
        if (sabores.isEmpty()) return ResponseEntity.status(204).build()
        return ResponseEntity.status(200).body(sabores)
    }

    @PatchMapping(
        value = ["/imagem/{codigo}"],
        consumes = ["image/jpg", "image/png"]
    )
    fun updateFotoSabor(
        @PathVariable codigo: Int,
        @RequestBody novaFoto: ByteArray
    ): ResponseEntity<Void> {
        val sabor = saborRepository.findById(codigo).get()
        sabor.foto = novaFoto
        saborRepository.save(sabor)
        return ResponseEntity.status(204).build()
    }

    @GetMapping(
        value = ["/imagem/{codigo}"],
        produces = ["image/jpg", "image/png"]
    )
    fun getFoto(@PathVariable codigo: Int): ResponseEntity<ByteArray> {
        val musica = saborRepository.findFotoByCodigo(codigo)
        if (musica.isEmpty())return ResponseEntity.status(204).build()
        return ResponseEntity.status(200).body(musica)
    }

}
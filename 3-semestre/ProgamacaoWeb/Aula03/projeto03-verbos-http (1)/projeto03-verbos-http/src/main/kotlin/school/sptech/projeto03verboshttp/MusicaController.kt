package school.sptech.projeto03verboshttp

import org.apache.coyote.Response
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/musicas")
class MusicaController {

    var listaMusicas = mutableListOf<Musica>(Musica("Profissao foda", "Dj Roca"))

    @GetMapping
    fun listar(): ResponseEntity<List<Musica>>{
        if(listaMusicas.isEmpty()){
            return ResponseEntity.status(204).build()
        }
        return ResponseEntity.status(200).body(listaMusicas)
    }

    @GetMapping("/{indice}")
    fun buscaPorIndice(@PathVariable indice: Int): ResponseEntity<Musica?>{
        if (existeMusica(indice)){
            return ResponseEntity.status(200).body(listaMusicas[indice])
        }
        return ResponseEntity.status(404).build()
    }
    @PostMapping
    fun cadastrar(@RequestBody musica: Musica): ResponseEntity<Musica> {
        listaMusicas.add(musica)
        return ResponseEntity.status(201).body(musica)
    }

    @PutMapping("/{indice}")
    fun atualizar(
            @PathVariable indice: Int,
            @RequestBody musica: Musica
    ): ResponseEntity<Musica?>{
        if(existeMusica(indice)){
            listaMusicas.set(indice, musica)
            return ResponseEntity.status(200).body(listaMusicas[indice])
        }

        return ResponseEntity.status(404).build()
    }
    @DeleteMapping("/{indice}")
    fun deletar(@PathVariable indice: Int):ResponseEntity<Void>{
        if(existeMusica(indice)){
            listaMusicas.removeAt(indice)
            return ResponseEntity.status(204).build()
        }
        return ResponseEntity.status(404).build()
    }

    fun existeMusica(indice: Int): Boolean {
        return indice >= 0 && indice < listaMusicas.size
    }
}
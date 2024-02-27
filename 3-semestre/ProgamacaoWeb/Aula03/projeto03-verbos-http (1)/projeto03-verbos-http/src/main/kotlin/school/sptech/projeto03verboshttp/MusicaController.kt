package school.sptech.projeto03verboshttp

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
            RETURN ResponseEntity.status(204).build()
        }
        return ResponseEntity.status(200).body(listaMusicas)
    }

    @GetMapping("/{indice}")
    fun buscaPorIndice(@PathVariable indice: Int): Musica?{
        if (existeMusica(indice)){
            return listaMusicas[indice]
        }
        return null
    }
    @PostMapping
    fun cadastrar(@RequestBody musica: Musica): Musica {
        listaMusicas.add(musica)
        return musica
    }

    @PutMapping("/{indice}")
    fun atualizar(
            @PathVariable indice: Int,
            @RequestBody musica: Musica
    ): Musica?{
        if(existeMusica(indice)){
            listaMusicas.set(indice, musica)
            return listaMusicas[indice]
        }

        return null
    }
    @DeleteMapping("/{indice}")
    fun deletar(@PathVariable indice: Int){
        if(existeMusica(indice)){
            listaMusicas.removeAt(indice)
        }
    }

    fun existeMusica(indice: Int): Boolean {
        return indice >= 0 && indice < listaMusicas.size
    }
}
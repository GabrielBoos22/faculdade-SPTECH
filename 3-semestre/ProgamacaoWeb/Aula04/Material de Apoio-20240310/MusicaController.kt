package school.sptech.projeto03verboshttp

import org.apache.coyote.Response
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/musicas")
class MusicaController {

    // lista vazia de musicas
    val listaMusicas: MutableList<Musica> = mutableListOf()

    // /musicas
    @GetMapping// Utilizamos GET para fazer listagem
    fun listar(): ResponseEntity<List<Musica>> {
        if (listaMusicas.isEmpty()) {
            return ResponseEntity.status(204).build() // 204 Not Content - Lista vazia
        }
        return ResponseEntity.status(200).body(listaMusicas) // 200 Ok - Lista com itens
    }

    // /musicas/0
    @GetMapping("/{indice}") // Utilizamos GET para buscar por indice
    fun buscaPorIndice(@PathVariable indice: Int): ResponseEntity<Musica> {
        if (existeMusica(indice)) {
            return ResponseEntity.status(200).body(listaMusicas[indice]) // 200
        }

        return ResponseEntity.status(404).build() // 404
    }

    // /musicas
    @PostMapping // Post - Utilizado para criação de algum recurso
    fun cadastrar(@RequestBody musica: Musica): ResponseEntity<Musica> { // RequestBody - Receber JSON como objeto
        if (musica.nome.length < 2) {
            // fazemos esse throw .... para forçar o retorno com status 400 e uma mensagem de erro
            // OBS: lembrar de adicionar as 2 configurações no application.properties (ver no moodle)
            throw ResponseStatusException(
                HttpStatusCode.valueOf(400), "Nome deve ter 2+ letras")
        }
        listaMusicas.add(musica)
        return ResponseEntity.status(201).body(musica)
    }

    // /musicas/0
    @PutMapping("/{indice}") // PUT - Atualização completa de um recurso
    fun atualizar(
        @PathVariable indice: Int,
        @RequestBody musica: Musica): ResponseEntity<Musica> {

        if (existeMusica(indice)) {
            listaMusicas.set(indice, musica)
            return ResponseEntity.status(200).body(musica)
        }
        return ResponseEntity.status(404).build()
    }

    // ResponseEntity<Void> -> Indica que NÃO terá corpo de resposta em nenhuma situação!
    // /musicas/0
    @DeleteMapping("/{indice}") // DELETE - Utilizamos para deletar um recurso específico
    fun deletar(@PathVariable indice: Int):ResponseEntity<Void> {
        if (existeMusica(indice)){
            listaMusicas.removeAt(indice)
            return ResponseEntity.status(204).build()
        }
        return ResponseEntity.status(404).build()
    }

    fun existeMusica(indice: Int): Boolean {
        return indice >= 0 && indice < listaMusicas.size
    }

}
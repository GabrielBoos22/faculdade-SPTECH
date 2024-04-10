package sptech.projetojpa1.controller

import org.apache.coyote.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sptech.projetojpa1.dominio.Musica
import sptech.projetojpa1.repository.MusicaRepository
import java.time.LocalDate

@RestController
@RequestMapping("/musicas")
class MusicaController {

    @Autowired
    lateinit var repository: MusicaRepository

    @PostMapping
    fun post(@RequestBody novaMusica: Musica):ResponseEntity<Musica>{
        repository.save(novaMusica)
        return ResponseEntity.status(201).body(novaMusica)
    }

    @GetMapping
    fun get(): ResponseEntity<List<Musica>> {
        val lista = repository.findAll()
        if(lista.isNotEmpty()){
            return ResponseEntity.status(200).body(lista)
        }
        return ResponseEntity.status(204).build()
    }

    @GetMapping("/{codigo}")
    fun get(@PathVariable codigo:Int): ResponseEntity<Musica>{
        /*
        if(repository.existsById(codigo)){
            val musica = repository.findById(codigo).get()
            return ResponseEntity.status(200).body(musica)
        }
        return ResponseEntity.status(404).build()

         */
        return ResponseEntity.of(repository.findById(codigo))
    }

    @DeleteMapping("/{codigo}")
    fun delete(@PathVariable codigo: Int):ResponseEntity<Void>{
        if(repository.existsById(codigo)){
            repository.deleteById(codigo)
            return ResponseEntity.status(200).build()
        }
        return ResponseEntity.status(404).build()
    }

    @PutMapping("/{codigo}")
    fun put(@PathVariable codigo: Int, @RequestBody musica: Musica): ResponseEntity<Musica> {
        if(repository.existsById(codigo)){
            musica.codigo = codigo
            repository.save(musica)
            return ResponseEntity.status(200).body(musica)
        }

        return ResponseEntity.status(404).build()
    }

    @GetMapping("/filtro-nome/{nome}")
    fun filtroNome(@PathVariable nome:String): ResponseEntity<List<Musica>>{
        val lista = repository.findByNomeContains(nome)

        if(lista.isNotEmpty()) return ResponseEntity.status(200).body(lista)

        return ResponseEntity.status(204).build()
    }

    @GetMapping("/lancadas-apos/{lancamento}")
    fun filtroData(@PathVariable lancamento: LocalDate): ResponseEntity<List<Musica>>{
     val lista = repository.findByLancamentoAfter(lancamento)

        return if (lista.isEmpty())
            ResponseEntity.status(204).build()
            else ResponseEntity.status(200).body(lista)
    }

    @GetMapping("/ultima")
    fun ultima(): ResponseEntity<Musica>{
        return ResponseEntity.of(
            repository.findTop1ByOrderByLancamentoDesc()
        )
    }

    @GetMapping("/classicos")
    fun buscarClassicos():ResponseEntity<List<Musica>>{
        val classicos = repository.findByClassicoTrue()
        if(classicos.isNotEmpty()){
            return ResponseEntity.status(200).body(classicos)
        }
        return ResponseEntity.status(404).build()
    }

    @GetMapping("/filtro-estilo/{estilo}/{classico}")
    fun buscaEstiloPelaClassificacao(@PathVariable estilo: String, @PathVariable classico: Boolean): ResponseEntity<List<Musica>>{
        val musicas = repository.findByEstiloAndClassico(estilo, classico)
        if(musicas.isNotEmpty()){
            return ResponseEntity.status(200).body(musicas)
        }
        return ResponseEntity.status(404).build()
    }

    @GetMapping("/top3-tocadas")
    fun pegaTop3(): ResponseEntity<List<Musica>>{
        val musicas = repository.findTop3ByOrderByTotalOuvintesDesc()
        if(musicas.isNotEmpty()){
            return ResponseEntity.status(200).body(musicas)
        }
        return ResponseEntity.status(404).build()
    }
    @GetMapping("/contagem-estilo/{estilo}")
    fun pegaTop3(@PathVariable estilo: String): ResponseEntity<Int>{
        val musicas = repository.countByEstilo(estilo)
        if(musicas > 0){
            return ResponseEntity.status(200).body(musicas)
        }
        return ResponseEntity.status(404).build()
    }
}
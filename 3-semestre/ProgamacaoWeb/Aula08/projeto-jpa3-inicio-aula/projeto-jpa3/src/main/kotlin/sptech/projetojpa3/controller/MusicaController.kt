package sptech.projetojpa3.controller

import org.apache.coyote.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import sptech.projetojpa3.dominio.Musica
import sptech.projetojpa3.repository.MusicaRepository
import java.time.LocalDate


@RestController
@RequestMapping("/musicas")
class MusicaController {

    /*
@Autowired -> Indica que é de responsabilidade do Spring em instanciar o objeto,
no caso, o 'repository'.
Assim, quando qualquer dos método da classe precisar do 'repository', ele já terá um valor válido
 */

    @Autowired
    lateinit var repository: MusicaRepository

    @PostMapping
    fun post(@RequestBody novaMusica: Musica):ResponseEntity<Musica> {
        // save() -> equivale a um "insert into tabela" ou a um "update tabela". Se o campo que for a Id será um insert, caso contrário, um update
        repository.save(novaMusica)
        return ResponseEntity.status(201).body(novaMusica)
    }

    @GetMapping
    fun get(): ResponseEntity<List<Musica>> {
        // findAll() -> equivale a um "select * from tabela"
        val lista = repository.findAll()

        if (lista.isNotEmpty()) {
            return ResponseEntity.status(200).body(lista)
        }
        return ResponseEntity.status(204).build()
    }

    @GetMapping("/{codigo}")
    fun get(@PathVariable codigo:Int): ResponseEntity<Musica> {
        // existsById() -> retorna true se o valor é uma PK que existe para a entidade
        /*if (repository.existsById(codigo)) {
            val musica = repository.findById(codigo).get()
            return ResponseEntity.status(200).body(musica)
        }
        return ResponseEntity.status(404).build()*/
        /*
ResponseEntity.of():
se o argumento tiver valor - retorna status 200 com o valor no corpo da resposta
se o argumento NÃO tiver valor - retorna 404 e sem corpo de resposta
         */
        return ResponseEntity.of(repository.findById(codigo))
    }

    @DeleteMapping("/{codigo}")
    fun delete(@PathVariable codigo:Int):ResponseEntity<Void> {
        if (repository.existsById(codigo)) {
            repository.deleteById(codigo)
            return ResponseEntity.status(204).build()
        }
        return ResponseEntity.status(404).build()
    }

    @PutMapping("/{codigo}")
    fun put(
    @PathVariable codigo: Int,@RequestBody musica: Musica):
           ResponseEntity<Musica> {
        if (repository.existsById(codigo)) {
            musica.codigo = codigo
            // save() -> equivale a um "insert into tabela" ou a um "update tabela". Se o campo que for a Id será um insert, caso contrário, um update
            repository.save(musica)
            return ResponseEntity.status(200).body(musica)
        }
        return ResponseEntity.status(404).build()
    }

    @GetMapping("/filtro-nome/{nome}")
    fun filtroNome(@PathVariable nome:String):
            ResponseEntity<List<Musica>> {
        val lista = repository.findByNomeContains(nome)

        if (lista.isNotEmpty()) {
            return ResponseEntity.status(200).body(lista)
        }
        return ResponseEntity.status(204).build()
    }

    @GetMapping("/lancadas-apos/{lancamento}")
    fun filtroData(
        @PathVariable lancamento: LocalDate
    ): ResponseEntity<List<Musica>> {

        val lista = repository.findByLancamentoAfter(lancamento)

        return if (lista.isEmpty())
            ResponseEntity.status(204).build()
            else ResponseEntity.status(200).body(lista)
    }

    @GetMapping("/ultima")
    fun ultima(): ResponseEntity<Musica> {

        return ResponseEntity.of(
               repository.findTop1ByOrderByLancamentoDesc())
    }


    @PatchMapping(value = ["/foto/{codigo}"],
        consumes = ["image/*"])
    fun patchFoto(
        @PathVariable codigo: Int,
        @RequestBody novaFoto: ByteArray
    ): ResponseEntity<Void>{
        val musica = repository.findById(codigo).get()
        musica.foto = novaFoto
        repository.save(musica)

        return ResponseEntity.status(204).build()
    }
     /*
     produces -> indica o Content-type do corpo de resposta
     #hack: o "image/jpeg" funciona para todos os tipos de imagem
     o "image/ *" NÃO funciona para download!
      */
    @GetMapping(value = ["/foto/{codigo}"],
        produces = ["image/jpg"])
    fun getFoto(@PathVariable codigo: Int): ResponseEntity<ByteArray> {
        val musica = repository.recuperarFoto(codigo)

       return ResponseEntity.status(200).body(musica)
    }

    @GetMapping("/filtro-compositor-codigo/{codigo}")
    fun getCompositorCodigo(@PathVariable codigo: Int): ResponseEntity<List<Musica>>{
        return ResponseEntity.status(200)
            .body(repository.findByCompositorCodigo(codigo))
    }

    @GetMapping("/filtro-compositor-nome/{nome}")
    fun getCompositorNome(@PathVariable nome: String): ResponseEntity<List<Musica>>{
        return ResponseEntity.status(200)
            .body(repository.findByCompositorNomeContains(nome))
    }
}
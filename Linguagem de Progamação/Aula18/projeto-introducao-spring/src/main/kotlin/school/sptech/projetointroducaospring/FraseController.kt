package school.sptech.projetointroducaospring

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/frases")
// http://localhost:8080/frases
class FraseController {

    // http://localhost:8080/frases
    @GetMapping
    fun ola() : String {
        return "Olá mundo"
    }

    // http://localhost:8080/frases/tudo-bem
    @GetMapping("/tudo-bem")
    fun tudoBem() : String {
        return "Tudo bem?"
    }

    // http://localhost:8080/frases/personalizado/{algumacoisa}
    @GetMapping("/personalizado/{nome}")
    fun personalizado(@PathVariable nome: String) : String { // @PathVariable para receber valores dinamicamente na URI
        return "Olá, $nome"
    }

    // http://localhost:8080/frases/personalizado/{nome}/{sobrenome}
    @GetMapping("/personalizado/{nome}/{sobrenome}")
    fun personalizado2(
        @PathVariable nome: String,
        @PathVariable sobrenome: String): String {

        return "Olá $nome $sobrenome"
    }

    var numero: Int = 0

    // http://localhost:8080/frases/somar
    @GetMapping("/somar")
    fun somar() : Int {
        numero++
        return numero
    }

    // http://localhost:8080/frases/somar2
    @GetMapping("/somar2")
    fun somar2() : Int {
        numero++
        return numero
    }

    // http://localhost:8080/frases/filme
    @GetMapping("/filme")
    fun retornaFilme() : Filme {
        return Filme("Titanic", "James Cameron", 1998)
    }
}
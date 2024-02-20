package sptech.projeto01

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
/*
@RestController - Anotação
transforma a classe numa REST Controller
ou seja, uma classe que pode abrigar Chamadas ou EndPoints
 */
@RestController
@RequestMapping("/frases") // indica que todos os Endpoints vão começar com /frases
class FrasesController {

    /*
@GetMapping -> esta anotação indica que o método é um EndPoint ou Chamada
"/bom-dia" -> URI (Universal Resource Identifier)
Mas a URI completa deste EndPoint é "/frases/bom-dia"
     */
    @GetMapping("/bom-dia")
    fun bomDia(): String {
        return "Bom dia, flor do dia!"
    }

    @GetMapping("/idade-maior-idade")
    fun idadeMaiorIdade(): Int {
        return 18
    }

    @GetMapping("/sistema-online")
    fun sistemaOnLine(): Boolean {
        return true
    }

}
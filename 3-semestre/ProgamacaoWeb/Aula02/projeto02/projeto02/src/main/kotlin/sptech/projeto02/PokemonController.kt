package sptech.projeto02

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pokemon")
class PokemonController {
    val pokemons = mutableListOf<Pokemon>(
            Pokemon("Pikachu", "Elétrico"),
            Pokemon("Charizard", "Fogo"),
            Pokemon("Charmeleon", "Fogo"),
            Pokemon("Pangolim", "Terra")
    )
    @GetMapping
    fun listar(): List<Pokemon>{
        return pokemons
    }

    @GetMapping("/cadastrar/{nome}/{elemento}")
    fun cadastra(@PathVariable nome: String, @PathVariable elemento: String): String{
        pokemons.add(Pokemon(nome, elemento))
        return "Cadastrado"
    }

    @GetMapping("/recuperar/{indice}")
    fun buscar(@PathVariable indice: Int): Pokemon{
        return pokemons[indice]
    }

    @GetMapping("/deletar/{indice}")
    fun remover(@PathVariable indice: Int): String{
        pokemons.removeAt(indice)
        return "Excluido"
    }
    @GetMapping("/atualizar/{indice}/{nome}/{elemento}")
    fun remover(@PathVariable indice: Int, @PathVariable nome: String, @PathVariable elemento: String): String{
        if(indice >= 0 && indice <= pokemons.size){
            pokemons[indice] = Pokemon(nome, elemento)
            return "Pokemon Atualizado"
        } else{
            return "Não encontrado"
        }
    }
}
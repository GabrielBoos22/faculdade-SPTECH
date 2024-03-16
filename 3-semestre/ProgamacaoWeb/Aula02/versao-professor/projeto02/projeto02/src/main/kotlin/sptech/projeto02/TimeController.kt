package sptech.projeto02

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/times")
class TimeController {

    val times = mutableListOf(
        TimeFutebol("aaa", 10, 1, 0, 100.0),
        TimeFutebol("bbb", 4, 7, 2, 200.0),
        TimeFutebol("ccc", 0, 4, 10, 300.0)
    )

    @GetMapping("/primeiro")
    fun primeiro():TimeFutebol {
        return times.first() // ou times[0]
    }

    @GetMapping
    fun todos():List<TimeFutebol> {
        return times
    }
    /*
EndPoint: /times/novo/{nome}/{vit}/{emp}/{derr}/{patr}
Ao ser chamado, ele cadastra um novo time na API
e retorna a frase "Time NOME cadastrado com sucesso"
#FicaDica: chame o EndPoint /times para confirmar se cadastrou mesmo
     */
    @GetMapping(
    "/novo/{nome}/{vitorias}/{empates}/{derrotas}/{patrimonio}")
    fun novo(@PathVariable nome:String,
             @PathVariable vitorias:Int,
             @PathVariable empates:Int,
             @PathVariable derrotas:Int,
             @PathVariable patrimonio:Double): String {
        val novoTime =
            TimeFutebol(nome, vitorias, empates, derrotas, patrimonio)

        times.add(novoTime)
        return "Time $nome criado com sucesso"
    }
/*
EndPoint: /times/{posicao}
Retorna um time da lista conforme a "posicao"
Ex: posicao 0 retorna o 1o. da lista
Ex: posicao 2 retorna o 3o. da lista
O retorno é o JSON do time encontrado
 */
    @GetMapping("/{posicao}")
    fun recuperar(@PathVariable posicao:Int):TimeFutebol? {
        /*
        Valores válidos para "posicao":
        0..(tamanho-1)
        3 -> 0..2
        5 -> 0..4
         */
        if (posicao >=0 && posicao <= times.size-1) {
            return times[posicao]
        } else {
            return null
        }
    }

}





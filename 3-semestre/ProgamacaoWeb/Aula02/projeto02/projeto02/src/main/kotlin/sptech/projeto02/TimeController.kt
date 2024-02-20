package sptech.projeto02

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/times")
class TimeController {

    val times = mutableListOf<TimeFutebol>(
            TimeFutebol("aaa", 10, 1, 0, 100.0),
            TimeFutebol("bbb", 4, 7, 2, 200.0),
            TimeFutebol("ccc", 0, 4, 10, 400.0)
    )

    @GetMapping("/primeiro")
    fun primeiro(): TimeFutebol {
        return times.first()
    }

    @GetMapping
    fun todos(): List<TimeFutebol>{
        return times
    }
    /*
    EndPoint: /times/novo/{nome}/
     */
    @GetMapping("/novo/{nome}/{vit}/{emp}/{derr}/{patr}")
    fun todos(@PathVariable nome: String,@PathVariable vit: Int, @PathVariable emp: Int,@PathVariable derr: Int, @PathVariable patr: Double): String{
        times.add(TimeFutebol(nome, vit, emp, derr, patr))
        return "Time novo cadastrado com sucesso!"
    }

    @GetMapping("/{posicao}")
    fun retorna(@PathVariable posicao: Int): TimeFutebol{
        return times[posicao]
    }
}
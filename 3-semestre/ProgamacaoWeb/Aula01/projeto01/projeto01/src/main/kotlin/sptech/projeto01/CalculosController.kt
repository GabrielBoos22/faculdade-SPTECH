package sptech.projeto01

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/calculos")
class CalculosController {

    // URI: /calculos/somar/1.5/3.5  -> A soma... 5.0
    // URI: /calculos/somar/9/2  -> A soma... 11.0
    /*
    Neste Enpoint temos 2 PATH PARAMS (num1 e num2)
    {num1} foi associado automaticamente ao parâmetro num1 por terem o mesmo nome
    mass.... só ocorreu porque o parâmetro num1 está anotado com @PathVariable
     */
    @GetMapping("/somar/{num1}/{num2}")
    fun somar(@PathVariable num1:Double, @PathVariable num2:Double): String {
        return "A soma entre $num1 e $num2 é ${num1 + num2}"
    }

    /*
    /calculos/resultado/{nota1}/{nota2}
    Se a média entre as notas for:
    <6  ->  retorne "Infelizmente reprovação"
    >=6  -> retorne "Parabéns! Aprovação!"
     */
    @GetMapping("/resultado/{nota1}/{nota2}")
    fun resultado(@PathVariable nota1:Double, @PathVariable nota2:Double): String {
        val media = (nota1+nota2)/2.0
        return if (media >= 6) "Parabéns! Aprovação!" else "Infelizmente reprovação"
    }

}




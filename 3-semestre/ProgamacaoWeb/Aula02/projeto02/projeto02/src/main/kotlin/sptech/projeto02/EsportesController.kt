package sptech.projeto02

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/esportes")
class EsportesController {
    val esportes = mutableListOf("futebol", "tênis", "volei", "basquete", "xadrez")

    /*
    /esportes/pesquisa?termo=te
    /esportes/pesquisa?termo=s
    /esportes/pesquisa?termo=x
    /esportes/pesquisa?termo=www
     */
    @GetMapping("/pesquisa")
    fun pesquisar(@RequestParam termo: String): List<String>{
        return esportes.filter{ it.contains(termo)}
    }

    /*
    /esportes/filtro
    2 Parâmetros de requisição: termo e tamanho
     */

    @GetMapping("/filtro/{tamanho}")
    fun filtrar(@RequestParam termo: String,
                @PathVariable tamanho: Int): List<String>{
        return esportes.filter{
            it.contains(termo) && it.length >= tamanho
        }
    }
}
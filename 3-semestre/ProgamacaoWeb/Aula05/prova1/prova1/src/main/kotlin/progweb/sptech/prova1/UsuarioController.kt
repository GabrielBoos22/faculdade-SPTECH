package progweb.sptech.prova1

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuarios")
class UsuarioController {
    val listaUsuario:MutableList<Usuario> = mutableListOf()
    @PostMapping
    fun cadastrar(@RequestBody usuario: Usuario): ResponseEntity<Usuario> {
        if(retornaUsuario(usuario.login) !== null){
            return ResponseEntity.status(409).build()
        }
        listaUsuario.add(usuario)
        return ResponseEntity.status(201).body(usuario)
    }

    @DeleteMapping
    fun desativar(@RequestParam login: String): ResponseEntity<Usuario>{
        val usuarioBuscado = retornaUsuario(login)
        if(usuarioBuscado == null){
            return ResponseEntity.status(404).build()
        } else{
            usuarioBuscado.autenticado = false
            usuarioBuscado.ativo = false
            return ResponseEntity.status(200).body(usuarioBuscado)
        }
    }

    @GetMapping
    fun buscar(): ResponseEntity<List<Usuario>>{
        if(listaUsuario.size <= 0){
            return ResponseEntity.status(204).build()
        }
        return ResponseEntity.status(200).body(listaUsuario)
    }

    @PostMapping("/autenticacao")
    fun autenticar(@RequestBody autenticacao: Autenticar): ResponseEntity<Usuario>{
        for (i in listaUsuario){
            if(i.login == autenticacao.login && i.senha == autenticacao.senha){
                if(i.ativo == true){
                    i.acessos += 1
                    i.autenticado = true
                    return ResponseEntity.status(200).body(i)
                } else {
                    return ResponseEntity.status(401).build()
                }
            }
        }
        return ResponseEntity.status(404).build()
    }

    @DeleteMapping("/autenticacao")
    fun desautenticar(@RequestParam login: String): ResponseEntity<Usuario>{
        val usuarioBuscado = retornaUsuario(login)
        if(usuarioBuscado !== null){
            usuarioBuscado.autenticado = false
            return ResponseEntity.status(200).body(usuarioBuscado)
        }
        return ResponseEntity.status(404).build()
    }

    @PatchMapping
    fun alterarSenha(@RequestBody info: SenhaNova, @RequestParam login: String): ResponseEntity<SenhaNova>{
        var usuarioBuscado = retornaUsuario(login)
        if (usuarioBuscado !== null){
            usuarioBuscado.senha = info.senha
            usuarioBuscado.dicaSenha = info.dicaSenha
            return ResponseEntity.status(200).body(info)
        }
        return ResponseEntity.status(404).build()
    }

    fun retornaUsuario(login: String): Usuario?{
        for (i in listaUsuario){
            if (login == i.login){
                return i
            }
        }
        return null
    }
}
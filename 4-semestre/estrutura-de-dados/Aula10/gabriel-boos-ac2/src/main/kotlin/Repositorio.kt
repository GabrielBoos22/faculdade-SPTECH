package org.example

import java.util.*
import java.util.concurrent.ArrayBlockingQueue

class Repositorio {
    var map = mutableMapOf<String, String>()
    var pilha = Stack<Info>()
    var fila = ArrayBlockingQueue<String>(10)

    fun salvar(nome: String, ra: String){
        map[nome] = ra
    }

    fun deletar(ra: String){
        if(map.keys.contains(ra)){
            pilha.push(Info(map[ra]!!, ra))
            map.remove(ra)
        } else{
            println("Aluno inexistente")
        }
    }

    fun exibir(){
        if(map.isEmpty()){
            println("Nenhum aluno cadastrado")
            return
        }
        for((nome, ra) in map){
            println("Nome: $nome | RA: $ra")
        }
    }

    fun desfazer(qtdOperacoes: Int){
        if(pilha.isEmpty()){
            println("Não há nada a desfazer")
            return
        }

        if(qtdOperacoes > pilha.size || qtdOperacoes < 0){
            println("Quantidade Inválida")
            return
        }
        val info = pilha.pop()
        salvar(info.aluno, info.ra)
    }

    fun agendarDeletar(ra: String){
        if(map.keys.contains(ra)){
            fila.add(ra)
        } else{
            println("Aluno inexistente")
        }
    }

    fun executarAgendado(){
        if(fila.isEmpty()){
            println("Não há operações agendadas")
            return
        }
        val ra = fila.poll()
        deletar(ra)
    }

}
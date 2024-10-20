package org.example

import java.util.*
import java.util.concurrent.ArrayBlockingQueue
import javax.swing.JOptionPane

class Repositorio {

    val lista: MutableList<Musica> = mutableListOf()
    val pilha: Stack<Int> = Stack()
    val fila: ArrayBlockingQueue<Musica> = ArrayBlockingQueue(10)

    fun salvar(musica: Musica){
        lista.add(musica)
        pilha.push(musica.id)
    }

    fun deletar(id: Int){
        ordenaListaPorId()
        val buscaIndiceMusica = buscaMusicaBinaria(id)
        if(buscaIndiceMusica == -1){
            JOptionPane.showMessageDialog(null, "ID inexistente.")
        } else{
            lista.removeAt(buscaIndiceMusica)
            JOptionPane.showMessageDialog(null, "musica deletada.")
        }
    }

    fun exibir(){
        if(lista.isEmpty()){
            JOptionPane.showMessageDialog(null, "Repositório vazio.")
        } else {
            lista.forEach{
                JOptionPane.showMessageDialog(null, "${it.toString()}")
            }
            println()
        }
    }

    fun desfazer(){
        if(pilha.isNotEmpty()){
            deletar(pilha.pop())
        } else {
            JOptionPane.showMessageDialog(null, "Não há nada a desfazer!")
        }
    }


    fun agendarSalvar(musica: Musica){
        fila.add(musica)
        JOptionPane.showMessageDialog(null, "Musica agendada para salvar!")
    }

    fun executarAgendado(qtdOperacoes: Int){
        if(fila.isNotEmpty()){
            if(qtdOperacoes > fila.size){
                println("Quantidade inválida!")
            } else {
                println("Salvando música agendada" + fila.peek())
                salvar(fila.poll())
            }
        } else{
            JOptionPane.showMessageDialog(null, "Não há operações de músicas agendadas!")
        }
    }
    private fun buscaMusicaBinaria (id: Int): Int {
        var inicio = 0
        var fim = lista.size - 1

        while (inicio <= fim) {
            val meio = (inicio + fim) / 2
            if (lista[meio].id == id) {
                return meio
            } else if (lista[meio].id < id) {
                fim = meio - 1 //
            } else {
                inicio = meio + 1
            }
        }
        return -1
    }

    private fun ordenaListaPorId (): Unit {
        for (i in 0 until lista.size - 1) {
            for (j in 0 until lista.size - i - 1) {
                if (lista[j].id > lista[j + 1].id) {
                    val temp = lista[j]
                    lista[j] = lista[j + 1]
                    lista[j + 1] = temp
                }
            }
        }
    }
}
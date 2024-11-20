package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val repo = Repositorio()

    println("\nExecutando agendado fila vazia:")
    repo.executarAgendado()

    println("Desfazendo pilha vazia:")
    repo.desfazer(1)

    repo.salvar("5000", "Maria Souza")
    repo.salvar("5001", "Isabela Santana")
    repo.salvar("5002", "João Pedro")
    repo.salvar("5003", "Bruno Silva")

    println("\nRepositorio apos salvar 4 alunos:")
    repo.exibir()

    repo.deletar("5001")
    repo.deletar("5003")

    println("\nRepositorio apos deletar:")
    repo.exibir()

    println("\nDeletando aluno inexistente:")
    repo.deletar("4000")

    println("\nDesfazendo -1 operações")
    repo.desfazer(-1)

    println("\nDesfazendo 10 operações")
    repo.desfazer(10)

    repo.desfazer(1)
    println("\nRepositorio apos desfazer")
    repo.exibir()

    repo.agendarDeletar("5000")
    repo.agendarDeletar("5002")

    println("\nRepositorio apos agendarDeletar:")
    repo.exibir()

    repo.executarAgendado()
    println("\nRepositorio apos executar agendado")
    repo.exibir()
}
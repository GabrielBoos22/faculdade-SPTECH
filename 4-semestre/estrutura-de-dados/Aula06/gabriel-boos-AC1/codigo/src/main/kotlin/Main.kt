package org.example

import javax.naming.ldap.Control

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val socio = Socio("Joao", 3000.0)
    val brinquedoIngresso = BrinquedoIngresso(1030, "Escorregador", 20.0, 50)
    val brinquedoAlugado = BrinquedoAlugado(1031, "Carrinho", 15, 70.0)

    println("Apresentando os objetos com toString(): ")
    println(socio.toString())
    println(brinquedoIngresso.toString())
    println(brinquedoAlugado.toString())

    val controleImposto = ControleImposto()
    controleImposto.adicionarObjeto(brinquedoIngresso)
    controleImposto.adicionarObjeto(brinquedoAlugado)
    controleImposto.adicionarObjeto(socio)

    println("Objetos que possuem impostos:")
    controleImposto.exibirObjeto()
    println("Total de impostos:")
    println(controleImposto.calcularTotalImposto())
}
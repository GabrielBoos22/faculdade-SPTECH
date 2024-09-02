package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val dvd = Dvd(1, 20.0, "Xitaozin e Chororo", "Xitaozin e chororo records")
    val livro = Livro(2, 10.0, "A arte da guerra", "San tzu", "teste")
    val servico = Servico("pedreiro", 200.0, 100, 10.0)

    val carrinho = Carrinho()
    carrinho.adicionaTributavel(dvd)
    carrinho.adicionaTributavel(livro)
    carrinho.adicionaTributavel(servico)

    carrinho.exibeTodos()
    carrinho.calculaTotalTributo()
}
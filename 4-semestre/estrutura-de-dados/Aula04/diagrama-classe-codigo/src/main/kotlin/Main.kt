package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val secretaria = Secretaria("12345678900", "Ana", 3000.0, 200.0)
    val professor = Professor("98765432100", "João", 20, 50.0)
    val coordenador = Coordenador("45678912300", "Marcos", 15, 70.0, 3)

    val controleBonus = ControleBonus()
    controleBonus.adicionarBonificavel(professor)
    controleBonus.adicionarBonificavel(coordenador)

    println("Funcionários que recebem bônus:")
    controleBonus.exibirBonificaveis()

    println("Total de bônus: ${controleBonus.calcularTotalBonus()}")
}
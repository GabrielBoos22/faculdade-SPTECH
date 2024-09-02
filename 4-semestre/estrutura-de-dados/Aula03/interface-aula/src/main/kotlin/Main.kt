package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val alimento = Alimento(1, "macarrão", 12.0, 15.0)
    val perfume = Perfume(2, "macarrão", 12.0, 15.0)
    val servico = Servico("macarrão", 200.0)

    val tributo = Tributo()
    tributo.adicionaTributavel(alimento)
    tributo.adicionaTributavel(perfume)
    tributo.adicionaTributavel(servico)

    tributo.exibeTodos()
    tributo.calculaTotalTributo()
}
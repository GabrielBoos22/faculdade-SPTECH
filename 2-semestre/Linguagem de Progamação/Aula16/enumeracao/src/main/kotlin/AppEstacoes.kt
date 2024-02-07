import java.lang.IllegalArgumentException
import javax.swing.JOptionPane
import javax.swing.JOptionPane.showInputDialog
import javax.swing.JOptionPane.showMessageDialog

fun main() {
    println("Estações disponíveis:")
    println(Estacao.values()) // este retorna um vetor(array)
    // println(Estacao.entries) // versão mais nova do Kotlin

    //iterando nos valores possíveis

    Estacao.values().forEach {
        println(it)
    }


    val menu = """
        Escolha uma das opções:
        VERAO, OUTONO, INVERNO ou PRIMAVERA
    """.trimIndent()
    val escolha = showInputDialog(menu)

    // .valueOf() -> BUSCA um valor na classe enum
    // deve-se informar uma String que seja EXATAMENTE
    // igual a um dos valores da enum
    // Caso o valor não exista ocorre um erro

    // Aqui foi feito um tratamento de exceção

    try {
        val estacaoEscolhida: Estacao = Estacao.valueOf(escolha)
        showMessageDialog(null, "Você escolheu $estacaoEscolhida")
    } catch (excecao:IllegalArgumentException){
        // }catch (excecao: Exception) { // caso não se saiba o erro
        showMessageDialog(null, "Estação inválida! ${excecao.message}")
    }

    showMessageDialog(null, "Aplicação executou com sucesso!")

}
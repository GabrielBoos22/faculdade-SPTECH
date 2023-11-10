import javax.swing.JOptionPane
import javax.swing.JOptionPane.showMessageDialog

fun main() {
    val gerente = Gerente()
    val atendente = Atendente()

    gerente.nome = "Chefe A"
    gerente.salario = 8000.0
    gerente.departamento = "Tecnologia"

    atendente.nome = "Peão X"
    atendente.salario = 2000.0
    atendente.setor = "Telemarketing"

    showMessageDialog(null, gerente.exibirDados())
    showMessageDialog(null, atendente.exibirDados())

    gerente.salario += 1000
    atendente.salario += 100

    showMessageDialog(null, gerente.exibirDados())
    showMessageDialog(null, atendente.exibirDados())

    // exemplo de POLIMOSFIRMO
    // onde um Funcionario pode ser um Funcionario, Gerente ou Atendente

    // Podemos declarar como Funcionario e instanciar como qualquer uma de suas subclasses
    val funcionario1:Funcionario = Funcionario()
    val funcionario2:Funcionario = Gerente()
    val funcionario3:Funcionario = Atendente()

    // em tempo de compilação (enquanto codificamos)
    // temos acesso aos atributos e métodos da classe declarada (do lado esquerdo)

    // em tempo de execução (quando o programa está sendo executado)
    // são usados os métodos da classe instanciada (do lado direito)

    val tipo = JOptionPane.showInputDialog("""
        Qual o tipo? 
        1 - gerente
        2 - atendente
        NDA - genérico
    """.trimIndent()).toInt()

    val funcionarioLoko:Funcionario = when (tipo) {
        1 -> Gerente()
        2 -> Atendente()
        else -> Funcionario()
    }

    funcionarioLoko.nome = "Zé Buduia"
    funcionarioLoko.salario = 2500.0

    // uso de "cast" para podermos usar os atributos específicos da subclasse
    if (funcionarioLoko is Gerente) {
        funcionarioLoko.departamento = "TI"
    }
    if (funcionarioLoko is Atendente) {
        funcionarioLoko.setor = "Telemarketing"
    }

    showMessageDialog(null, funcionarioLoko.exibirDados())

}
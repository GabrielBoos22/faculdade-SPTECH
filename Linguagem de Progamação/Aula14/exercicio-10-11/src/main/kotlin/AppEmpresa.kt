import javax.swing.JOptionPane

fun main() {
    var gerente = Gerente()
    var atendente = Atendente()

    gerente.nome = JOptionPane.showInputDialog("Qual o nome do Gerente?")
    gerente.idade = JOptionPane.showInputDialog("Qual a idade do Gerente?").toInt()
    gerente.salario = JOptionPane.showInputDialog("Qual o salário do Gerente?").toDouble()
    gerente.departamento = JOptionPane.showInputDialog("Qual o departamento do Gerente?")

    atendente.nome = JOptionPane.showInputDialog("Qual o nome do Atendente?")
    atendente.idade = JOptionPane.showInputDialog("Qual a idade do Atendente?").toInt()
    atendente.salario = JOptionPane.showInputDialog("Qual o salário do Atendente?").toDouble()
    atendente.setor = JOptionPane.showInputDialog("Qual o setor do Atendente?")

    while(true){
        var opcao = JOptionPane.showInputDialog("""
        Qual opção voce deseja executar?
        1- Exibir informação do atendente
        2- Exibir informação do gerente
        3- Aumentar salário atendente
        4- Aumentar salário gerente
        5- Sair
    """.trimIndent())

        if(opcao == "1"){
            JOptionPane.showMessageDialog(null, atendente.exibirDados())
        } else if(opcao == "2"){
            JOptionPane.showMessageDialog(null, gerente.exibirDados())
        } else if(opcao == "3"){
            atendente.aumentarSalario()
        } else if(opcao == "4"){
            gerente.aumentarSalario()
        } else {
            break
        }
    }



}
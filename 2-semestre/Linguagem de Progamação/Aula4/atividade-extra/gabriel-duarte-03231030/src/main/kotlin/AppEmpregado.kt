import java.math.BigDecimal
import javax.swing.JOptionPane

fun main() {
    var empregado1 = Empregado()

    empregado1.nome = JOptionPane.showInputDialog("Digite o nome do empregado");

    var opcao = perguntar(empregado1.nome, empregado1.cargo, empregado1.salario)
    validar(opcao, empregado1)

}

fun perguntar(nome:String, cargo:String, salario: BigDecimal): Int{
    var resposta =  JOptionPane.showInputDialog("-------------------------------------------------------------------\n" +
            "Nome: ${nome}\n" +
            "Cargo: ${cargo}\n" +
            "Salário: ${"%.2f".format(salario)}\n" +
            "\n" +
            "Digite as seguintes opções\n" +
            "1) Promover\n" +
            "2) Dar aumento\n" +
            "3) Viagem para long beach (praia grande)\n" +
            "4) Sair").toInt()
    return resposta;
    }

fun validar(opcao: Int, empregado: Empregado){
    if(opcao == 1){
        JOptionPane.showMessageDialog(null,"Parabéns, você subiu de cargo, e agora o seu salário é R$${"%.2f".format(empregado.aumentarCargo())}")
        var outraOpcao: Int = perguntar(empregado.nome, empregado.cargo, empregado.salario)
        validar(outraOpcao, empregado)
    } else if(opcao == 2){
        JOptionPane.showMessageDialog(null,"Parabéns, você recebeu um aumento, e agora o seu salário é R$${"%.2f".format(empregado.reajustarSalario())}")
        var outraOpcao: Int = perguntar(empregado.nome, empregado.cargo, empregado.salario)
        validar(outraOpcao, empregado)
    } else if(opcao == 3){
        JOptionPane.showMessageDialog(null,"Você tirou férias e tem direito a R$${"%.2f".format(empregado.tirarFerias())} (com o 13º!)!")
        var outraOpcao: Int = perguntar(empregado.nome, empregado.cargo, empregado.salario)
        validar(outraOpcao, empregado)
    }
}
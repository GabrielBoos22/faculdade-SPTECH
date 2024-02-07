import java.time.LocalDate
import javax.swing.JOptionPane
import javax.swing.JOptionPane.showMessageDialog

fun main(){
    val gerente1 = Gerente();
    gerente1.nome = "Gabriel";
    gerente1.email = "gabriel@email.com";
    gerente1.dataNascimento = LocalDate.parse("2005-05-05")
    gerente1.agencia = "1032031-14"

    val cliente1 = Cliente()
    cliente1.nome = "Cleber"
    cliente1.email = "Cleber@email.com"
    cliente1.dataNascimento = LocalDate.parse("2007-11-05")
    cliente1.numeroConta = "2042 1942 1042 1002"

    val cliente2 = Cliente()
    cliente2.nome = "Joao"
    cliente2.email = "Joao@email.com"
    cliente2.dataNascimento = LocalDate.parse("1995-10-05")
    cliente2.numeroConta = "1041 1241 1235 1022"

    showMessageDialog(null, gerente1.exibirInformacoes())
    showMessageDialog(null, cliente1.exibirInformacoes())
    showMessageDialog(null, cliente2.exibirInformacoes())

    val agencia = AgenciaBancaria()
    agencia.nome = "Banco do Brasil"
    agencia.gerente = gerente1
    agencia.adicionarCliente(cliente1)
    agencia.adicionarCliente(cliente2)

    showMessageDialog(null, agencia.detalhes())

}
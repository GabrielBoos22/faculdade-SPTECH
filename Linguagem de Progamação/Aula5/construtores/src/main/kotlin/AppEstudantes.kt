import javax.swing.JOptionPane

fun main() {
    // aqui instanciamos (criamos) um Estudante
    // usando seu construtor
    val estudante1 = Estudante("Zé Ruela", 4.5, 60.0)
    println("E1: Nome: ${estudante1.nome}, ${estudante1.media}, ${estudante1.frequencia}")

     estudante1.nome= "Joao";
    // a Média não pode ser reatribuída (alterada)
    // porque a média foi criada como val
    // estudante1.media = 92.0
    println("E1: Nome: ${estudante1.nome}, ${estudante1.media}, ${estudante1.frequencia}")

    // cadastrando vários estudantes

    // criando uma lista que só aceita estudantes
//    val estudantes = mutableListOf<Estudante >()
//
//    for (contador in 0..4){
//        val nome = JOptionPane.showInputDialog("Digite o nome")
//        val media = JOptionPane.showInputDialog("Digite a media").toDouble()
//        val freq = JOptionPane.showInputDialog("Digite a frequencia").toDouble()
//        val novoEstudante = Estudante(nome, media, freq)
//        estudantes.add(novoEstudante)
//
//    }

    // percorrendo a lista de estudantes
//    estudantes.forEach {
//        val resultado = if(it.aprovou()) "Passou!" else "Não passou"
//        JOptionPane.showMessageDialog(null,
//            "${it.nome} - Resultado: ${resultado}")
//    }
/*
Na classe estudante, crie um método registrarAtividade()
ele NÃO tem retorno e recebe um argumento do tipo texto
ao ser invocado, ele PODE aumentar a média em 0.15
(para isso, mude a média para var)
Ele aumenta a média só nas 3 primeiras vezes que é invocado.
Da 4a vez em diante, ele simplesmente não faz nada.

No App Estudante teste esse novo método criando um novo estudante
e  invocando esse método 4 vezes e exibindu sua nova média
 */

    val estudante2 = Estudante("Zé Ruela", 4.5, 60.0)
    var nomeAtividade = "Lição"
    estudante2.registrarAtividade(nomeAtividade)
    estudante2.registrarAtividade(nomeAtividade)
    estudante2.registrarAtividade(nomeAtividade)
    estudante2.registrarAtividade(nomeAtividade)
    print(estudante2.media)
    print(estudante2.listaAtividades)

}
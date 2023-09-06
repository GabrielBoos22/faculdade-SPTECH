import javax.swing.JOptionPane

fun main() {
    val cofres = mutableListOf<Cofrinho>()

    var cofrinho1 = Cofrinho()
    cofrinho1.objetivo = JOptionPane.showInputDialog("Qual o objetivo do 1 cofrinho?")
    cofrinho1.meta = JOptionPane.showInputDialog("Qual a meta do 1 cofrinho?").toDouble()
    cofres.add(cofrinho1)

    var cofrinho2 = Cofrinho()
    cofrinho2.objetivo = JOptionPane.showInputDialog("Qual o objetivo do 2 cofrinho?")
    cofrinho2.meta = JOptionPane.showInputDialog("Qual a meta do 2 cofrinho?").toDouble()
    cofres.add(cofrinho2)

    var cofrinho3 = Cofrinho()
    cofrinho3.objetivo = JOptionPane.showInputDialog("Qual o objetivo do 3 cofrinho?")
    cofrinho3.meta = JOptionPane.showInputDialog("Qual a meta do 3 cofrinho?").toDouble()
    cofres.add(cofrinho3)



    var cofreSelecionado = perguntarQualCofreIraMexer()
    mexerNoCofre(cofreSelecionado, cofres)

}

fun perguntarQualCofreIraMexer(): String{
    var cofreSelecionado = JOptionPane.showInputDialog("Em qual janela quer mexer?\r\n 1, 2 ou 3? Nenhum deles para encerrar o app.")

    return cofreSelecionado
}

fun mexerNoCofre(cofreSelecionado: String, cofres: List<Cofrinho>){
    if(cofreSelecionado == "1"){
        var valorDepositado = JOptionPane.showInputDialog("Informe quanto vai depositar do cofre 1.").toDouble()
        cofres[0].depositar(valorDepositado)

        var valorRetirada = JOptionPane.showInputDialog("Informe quanto vai retirar do cofre 1.").toDouble()
        cofres[0].retirar(valorRetirada)

        var cofreSelecionado = perguntarQualCofreIraMexer()
        mexerNoCofre(cofreSelecionado, cofres)
    } else if(cofreSelecionado == "2"){
        var valorDepositado = JOptionPane.showInputDialog("Informe quanto vai depositar do cofre 2.").toDouble()
        cofres[1].depositar(valorDepositado)

        var valorRetirada = JOptionPane.showInputDialog("Informe quanto vai retirar do cofre 2.").toDouble()
        cofres[1].retirar(valorRetirada)

        var cofreSelecionado = perguntarQualCofreIraMexer()
        mexerNoCofre(cofreSelecionado, cofres)
    } else if(cofreSelecionado == "3"){
        var valorDepositado = JOptionPane.showInputDialog("Informe quanto vai depositar do cofre 3.").toDouble()
        cofres[2].depositar(valorDepositado)

        var valorRetirada = JOptionPane.showInputDialog("Informe quanto vai retirar do cofre 3.").toDouble()
        cofres[2].retirar(valorRetirada)

        var cofreSelecionado = perguntarQualCofreIraMexer()
        mexerNoCofre(cofreSelecionado, cofres)

    } else {
        for (i in cofres){
            println(i.objetivo)
            println(i.saldo)
            JOptionPane.showMessageDialog(null,"${i.descrever()}.")
        }
    }
}
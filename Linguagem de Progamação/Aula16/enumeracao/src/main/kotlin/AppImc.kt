import javax.swing.JOptionPane

fun main(){
    val imcPego = 50.0
    try{
        val resposta =
            Imc.retornaImc(imcPego)

        println("O imc é ${resposta?.resultado} e deve ${resposta?.acao}")
    } catch (excecao: ImcInvalidoException){
        JOptionPane.showMessageDialog(null, "Valor de IMC inválido")
    }

}
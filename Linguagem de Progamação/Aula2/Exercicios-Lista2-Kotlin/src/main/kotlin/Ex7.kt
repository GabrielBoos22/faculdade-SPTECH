import javax.swing.JOptionPane

fun main() {
    val valorPorKm: Double = JOptionPane.showInputDialog("Qual o valor por km rodado?").toDouble();
    val km: Int = JOptionPane.showInputDialog("Qual a quantidade de km?").toInt();
    val volume: Int = JOptionPane.showInputDialog("Qual o volume de solicitações?").toInt();
    var valorTotal = 0.0;

    if(volume < 0 || volume > 10){
        exibeMensagem("Volume Inválido")
    } else {
        if(volume >= 0 && volume <= 2){
            valorTotal = valorPorKm * km
        } else if(volume >= 3 && volume <= 7){
            valorTotal = valorPorKm * km * 1.3
        } else if(volume >= 8 && volume <= 10){
            valorTotal = valorPorKm * km * 1.8
        }
        print(valorTotal)
        exibeMensagem("$valorTotal")
    }


}
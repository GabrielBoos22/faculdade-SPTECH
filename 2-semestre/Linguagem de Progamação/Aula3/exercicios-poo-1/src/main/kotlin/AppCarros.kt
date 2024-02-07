import javax.swing.JOptionPane

fun main() {
    val carro1 = Carro()
    var modelo:String = JOptionPane.showInputDialog("Qual o modelo do carro?");
    var marcha:Int = JOptionPane.showInputDialog("Qual a marcha do carro?").toInt();

    carro1.modelo = modelo;
    carro1.marcha = marcha;

    JOptionPane.showMessageDialog(null, "O 1º carro é um ${carro1.modelo} e está na marcha $marcha")

    if(carro1.ligado){
        JOptionPane.showMessageDialog(null, "O 1º carro esta ligado")
    } else {
        JOptionPane.showMessageDialog(null, "O 1º carro esta desligado")
    }

    carro1.ligar()
    carro1.aumentarMarcha()
    carro1.aumentarMarcha()

    JOptionPane.showMessageDialog(null, "O 1º carro é um ${carro1.modelo} e está na marcha ${carro1.marcha}")

    if(carro1.ligado){
        JOptionPane.showMessageDialog(null, "O 1º carro esta ligado")
    } else {
        JOptionPane.showMessageDialog(null, "O 1º carro esta desligado")
    }

    var carro2 = Carro()
    var modelo2:String = JOptionPane.showInputDialog("Qual o modelo do carro?");
    var marcha2:Int = JOptionPane.showInputDialog("Qual a marcha do carro?").toInt();

    carro2.modelo = modelo2;
    carro2.marcha = marcha2;

    var km:Int = JOptionPane.showInputDialog("Quantos km você quer rodar?").toInt();

    JOptionPane.showMessageDialog(null, "O 1º carro é um ${carro2.modelo} e está na marcha ${carro2.marcha} e tem ${carro2.km} km rodados")
    
    carro2.ligar()
    carro2.aumentarMarcha()
    carro2.fazerViagemCurta()

    JOptionPane.showMessageDialog(null, "O 1º carro é um ${carro2.modelo} e está na marcha ${carro2.marcha} e tem ${carro2.km} km rodados")

    carro2.aumentarMarcha()
    carro2.aumentarMarcha()
    carro2.fazerViagemCurta()
    carro2.fazerViagemCurta()
    carro2.reduzirMarcha()

    JOptionPane.showMessageDialog(null, "Você queria rodar $km km e rodou ${carro2.km} km ")

    JOptionPane.showMessageDialog(null, "O 1º carro é um ${carro2.modelo} e está na marcha ${carro2.marcha} e tem ${carro2.km} km rodados")
}


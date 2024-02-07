import javax.swing.JOptionPane

fun main() {
    var carro1 = Carro("Ford Mustang",false, 0.0 )
    carro1.ligar()
    carro1.acelerar()
    carro1.acelerar()
    carro1.acelerar()
    carro1.freiar()
    carro1.freiar()
    var velocidade = carro1.getVelocidade()
    JOptionPane.showMessageDialog(null, "Você está a $velocidade Km/h, acelera mais")

    for(i in 1..15){
        carro1.acelerar()
    }
    velocidade = carro1.getVelocidade()
    JOptionPane.showMessageDialog(null, "Você está a $velocidade Km/h, diminui ai")
    var parado = false
    while (parado == false){
        carro1.freiar()
        velocidade = carro1.getVelocidade()
        if(velocidade == 0.0){
            parado = true
        }
    }
    carro1.desligar()
    velocidade = carro1.getVelocidade()
    JOptionPane.showMessageDialog(null, "Esse é da firma! Chegou no $velocidade km/h")
}
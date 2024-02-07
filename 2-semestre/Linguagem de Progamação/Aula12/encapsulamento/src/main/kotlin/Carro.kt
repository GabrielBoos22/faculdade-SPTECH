class Carro (
    val modelo: String, private var ligado: Boolean, private var velocidade: Double
){
    fun ligar(){
        this.ligado = true
    }

    fun desligar(){
        this.ligado = false
    }

    fun acelerar(): Double{
        if(ligado){
            if(velocidade == 0.0){
                velocidade = 10.0
            } else {
                velocidade *= 1.25
                if(velocidade > 180.0){
                    velocidade = 180.0
                }
            }
        }
        return velocidade
    }

    fun freiar(){
        if(ligado){
            if(velocidade != 0.0){
                velocidade = velocidade - 3.0
            }
        }
    }

    fun getVelocidade(): Double{
        return velocidade
    }

}
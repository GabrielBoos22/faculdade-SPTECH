class Carro {
    var modelo:String = ""
    var potencia:Double = 0.0
    var km:Int = 0
    var marcha:Int = 0
    var ligado:Boolean = false

    fun ligar(){
        ligado = true
    }

    fun desligar(){
        ligado = false
    }

    fun aumentarMarcha(){
        marcha += 1
        if(marcha >= 6){
            marcha = 6
        }
    }

    fun reduzirMarcha(){
        marcha -= 1
        if(marcha <= -1){
            marcha = -1
        }
    }

    fun fazerViagemCurta(){
        when(marcha){
            in 1..2 -> km += 10
            in 3..5 -> km += 20
            6 -> km += 30
        }
    }
}

class Relogio {

    var horas:Int = 0
    var minutos:Int = 0
    var segundos:Int = 0

    fun horaAtual(){
        return "Agora são: ${horas.padStart(2, horas)}"
    }
}
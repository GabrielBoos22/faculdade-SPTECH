class Relógio {
    var modelo: String = ""
    var preco: Double = 0.0;
    var horas: Int = 0;
    var minutos: Int = 0;
    var segundos: Int = 0;

    fun zerar() {
        horas = 0
        minutos = 0
        segundos = 0
    }

    fun validar(): String{
        var errado = false
        if( minutos < 0 || minutos >= 59 ){
            minutos = 0
            errado = true
        }
        else if(segundos < 0 || segundos > 59){
            segundos = 0
            errado = true
        }
        else if(horas < 0 || horas > 23) {
            horas = 0
            errado = true
        }

        if(errado){
            return "Valores inválidos identificados. Ajustado!"
        } else {
            return "Todos os valores estavam corretos!"
        }
    }

    fun verHora(): String{
        validar()
        return "$horas:$minutos:$segundos"
    }
}
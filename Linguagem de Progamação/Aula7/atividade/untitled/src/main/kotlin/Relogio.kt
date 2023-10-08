class Relogio(var horas: Int = 0, var minutos: Int = 0, var segundos: Int = 0) {
    fun horaAtual(): String {
        val horaFormatada = horas.toString().padStart(2, '0')
        val minutoFormatado = minutos.toString().padStart(2, '0')
        val segundoFormatado = segundos.toString().padStart(2, '0')
        return "Agora são: $horaFormatada:$minutoFormatado:$segundoFormatado"
    }

    fun adicionarTempo(maisHoras: Int, maisMinutos: Int, maisSegundos: Int) {
        if(maisHoras <= 24){
            horas += maisHoras
            if(horas > 23){
                horas = horas - 24
            }
        } else if(maisMinutos <= 60){
            minutos += maisMinutos
            if(minutos > 59){
                minutos = minutos - 60
            }
        } else if(segundos <= 60){
            segundos += maisSegundos
            if(segundos > 59){
                segundos = segundos - 60
            }
        }
    }
}

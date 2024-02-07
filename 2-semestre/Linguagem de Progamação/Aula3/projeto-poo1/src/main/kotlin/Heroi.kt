class Heroi {
    /*
    Aqui nós definimos os
    ATRIBUTOS DE INSTâNCIA
     */
    var nome:String = ""
    var poderes:String = ""
    var vida:Double = 100.0
    var aposentado:Boolean = false

    fun usarPoder(){
        if(nome.isNotBlank() && poderes.isNotBlank()){
            println("${nome} usando os poderes de $poderes")
        } else {
        println("Herói sem nome e/ou sem poder")
        }
    }

    fun aposentar(){
        aposentado = true
    }

    fun apanhar(forca:Double){
        vida -= forca
        if(vida < 0){
            vida = 0.0
        }
    }
}
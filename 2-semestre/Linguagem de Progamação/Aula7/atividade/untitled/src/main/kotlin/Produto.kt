class Produto {

    var nome: String = ""
        set(value){
            if(value.length >= 4){
                field = value
            }
        }
        get(){
            if(field == ""){
                return "N/D"
            } else{
                return field
            }
        }

    var brinde: Boolean = false
        set(value){
            if(value){
                preco = 0.01
            }
        }
    var preco: Double = 0.0
        set(value){
                if(value >= 0.01) {
                    field = value
                }
        }

}

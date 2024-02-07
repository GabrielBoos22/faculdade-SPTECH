class Cidade {
    //um mesmo campo pode ter tanto  get() quanto set()
    var nome:String = ""
        set(value){
            if(value.length in 3..20){
                field = value
            }
        }
        get(){
            if(field == ""){
                return "Não Informado"
            } else{
                return field.uppercase()
            }
        }

}
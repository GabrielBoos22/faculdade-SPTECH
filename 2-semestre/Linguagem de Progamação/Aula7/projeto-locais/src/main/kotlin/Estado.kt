class Estado {
    var nome: String = ""
        get(){
            return if(field.isBlank()) "(Não informado)"
            else field
        }
    // quando um get exige mais código, usamos {}
    // e um return ao final
    // o return indical qual o valor será entrege para quem pediu

    var uf: String = ""
        get() = field.uppercase()
    // get() -> indica o valor que será retornado quando algém solicitar o uf de um estado
    // 'field" -> valor original do campo
    // OBS: O get NÃO altera o valor original do campo

    var populacao: Int = 0
        set(value){
            if(value>= 0){
                field = value
            }
        }

}
package composicao

import java.time.LocalDateTime

class ItemConta {
    val momentoPedido: LocalDateTime = LocalDateTime.now()

    var nomeItem:String = ""
    var valor:Double = 0.0
    var quantidade:Int = 0
}
package bibliotecacomposicao

class Livro {
    lateinit var titulo:String
    var anoPublicacao:Int = 0

    lateinit var autor:Autor

    fun getDescricao():String {
        return """
        Título do livro: $titulo
        Ano: $anoPublicacao
        Nome do autor: ${autor.nome}
        """.trimIndent()
    }
}
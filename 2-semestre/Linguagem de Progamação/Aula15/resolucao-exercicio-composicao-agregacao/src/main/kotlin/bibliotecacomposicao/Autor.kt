package bibliotecacomposicao

class Autor {
    lateinit var nome:String
    var idade:Int = 0

    var livros = mutableListOf<Livro>()

    /*
    Só existe livro em autor, pois um livro é criado dentro deste método
     */
    fun publicarLivro(titulo:String, anoPublicacao:Int) {
        val novoLivro = Livro()
        novoLivro.titulo = titulo
        novoLivro.anoPublicacao = anoPublicacao
        novoLivro.autor = this // "this" é este autor
        livros.add(novoLivro)
    }
}
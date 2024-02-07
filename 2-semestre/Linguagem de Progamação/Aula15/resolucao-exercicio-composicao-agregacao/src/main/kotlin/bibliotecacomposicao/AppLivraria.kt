package bibliotecacomposicao

import javax.swing.JOptionPane

fun main() {
    val autor1 = Autor()
    autor1.nome = "Scott Hahn"
    autor1.idade = 66

    autor1.publicarLivro("O banquete do cordeiro", 2014)
    autor1.publicarLivro("A alegria do mundo", 2018)
    autor1.publicarLivro("O amor vem primeiro", 2020)


    val autor2 = Autor()
    autor2.nome = "Murray Rothbard"
    autor2.idade = 97

    autor2.publicarLivro("Indivíduo, Economia e Estado", 1962)
    autor2.publicarLivro("A alegria do mundo", 1974)


    val autores = listOf(autor1, autor2)


    autores.forEach {autor -> // iterando a lista de autores. Cada autor dentro se chama "autor"
        autor.livros.forEach { livro -> // iterando a lista de livros de cada autor. Cada livro dentro se chama "livro"
            JOptionPane.showMessageDialog(null, livro.getDescricao())
        }
    }


}
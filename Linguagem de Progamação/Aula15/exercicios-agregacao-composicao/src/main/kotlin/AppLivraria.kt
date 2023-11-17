import javax.swing.JOptionPane

fun main(){

    val autor1: Autor = Autor()
    autor1.nome = "Robert Greene"
    autor1.idade = 64
    autor1.adicionarLivro("48 leis",1998,autor1)

    autor1.listarDescricao()

    val autor2: Autor = Autor()
    autor2.nome = "George Samuel Clason"
    autor2.adicionarLivro("Homem de Giz",1926,autor2)

    autor2.listarDescricao()

    autor1.livraria.clear()

    autor1.listarDescricao()

    JOptionPane.showMessageDialog(null,"Autor: ${autor1.nome}\r\n" +
            "Idade: ${autor1.idade} anos")
}
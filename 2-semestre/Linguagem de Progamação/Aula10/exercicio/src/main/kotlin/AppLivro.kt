import javax.swing.JOptionPane

fun main() {
    val jdbcTemplate = Conexao().conectar()
    val repositorio = LivroRepositorio()
    repositorio.iniciar(jdbcTemplate)
    repositorio.criarTabelas()

    while(true){
        val opcao = JOptionPane.showInputDialog("1 - Adicionar Novo Livro\n" +
                "2 - Buscar por id")
        var novoLivro = Livro()
        if (opcao == "1"){
            novoLivro.autor = JOptionPane.showInputDialog("Qual o autor do livro?")
            novoLivro.titulo = JOptionPane.showInputDialog("Qual o título do livro")
            repositorio.cadastrar(novoLivro)
        } else if(opcao == "2") {
            val id = JOptionPane.showInputDialog("Escolha o id").toInt()
            val livro = repositorio.consultar(id)

            JOptionPane.showMessageDialog(null, "Nome: ${livro.titulo}\n" +
                    "Autor: ${livro.autor}\n" +
                    "Data de criação: ${livro.dataCriacao}")
            break
        } else {
            JOptionPane.showMessageDialog(null, "Digite 1 ou 2")
        }
    }

}
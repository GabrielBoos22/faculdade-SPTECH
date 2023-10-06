import javax.swing.JOptionPane

fun main() {
    Conexao.criarTabelas();
    val repositorio = FilmeRepositorio()
    repositorio.iniciar()
    while(true){
        val opcao = JOptionPane.showInputDialog("1 - Adicionar Filme.\n" +
                "2 - Consultar Filme.\n" +
                "3 - Excluir Filme.\n" +
                "4 - Sair.\n")

        val novoFilme = Filme()
        if(opcao == "1"){
            novoFilme.nome = JOptionPane.showInputDialog("Qual o nome do filme?")
            novoFilme.diretor = JOptionPane.showInputDialog("Qual o diretor do filme?")
            novoFilme.indicadoOscar = JOptionPane.showInputDialog("O filme foi indicado Oscar? S ou N") == "S"
            novoFilme.custoProducao = JOptionPane.showInputDialog("Qual o custo de produção do filme?").toDouble()

            repositorio.cadastrar(novoFilme)
        } else if(opcao == "2"){
            val id = JOptionPane.showInputDialog("Qual id?").toInt()
            val filme = repositorio.consultar(id)

            JOptionPane.showMessageDialog(null,"Filme com o id: $id\n" +
                    "Nome: ${filme.nome}\n" +
                    "Diretor: ${filme.diretor}\n" +
                    "Indicado ao Oscar: ${filme.indicadoOscar}\n" +
                    "Custo de produção: R$ ${filme.custoProducao}")

        } else if(opcao == "3"){
            val id = JOptionPane.showInputDialog("Qual id?").toInt()
            val deletado = repositorio.deletar(id)
            JOptionPane.showMessageDialog(null,"Deletado: $deletado")
        } else{
            break
        }
    }
}
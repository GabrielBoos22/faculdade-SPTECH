import java.time.format.DateTimeFormatter
import javax.swing.JOptionPane

fun main() {
    val jdbcTemplate = Conexao().conectar()
    val repositorio = MusicaRepositorio()
    repositorio.iniciar(jdbcTemplate)
    repositorio.criarTabelas()

    while(true){
        val opcao = JOptionPane.showInputDialog("1.Adicionar nova música\n" +
                "2.Buscar por id\n" +
                "3.Excluir música por id\n" +
                "4.Sair")

        val novaMusica = Musica()
        if(opcao == "1"){
            novaMusica.titulo= JOptionPane.showInputDialog("Qual o título da música?")
            novaMusica.artista = JOptionPane.showInputDialog("Qual o artista da música?")

            repositorio.cadastrar(novaMusica)
        } else if(opcao == "2"){
            val id = JOptionPane.showInputDialog("Qual id?").toInt()
            val musica = repositorio.consultar(id)

            JOptionPane.showMessageDialog(null,"Musica com o id: $id\n" +
                    "Titulo: ${musica.titulo}\n" +
                    "Artista: ${musica.artista}\n" +
                    "Data: ${musica.dataCriacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))}\n")
        } else if(opcao == "3"){
            val id = JOptionPane.showInputDialog("Qual id?").toInt()
            val deletado = repositorio.deletar(id)
            JOptionPane.showMessageDialog(null,"Deletado: $deletado")
        } else {
            break
        }
    }
}
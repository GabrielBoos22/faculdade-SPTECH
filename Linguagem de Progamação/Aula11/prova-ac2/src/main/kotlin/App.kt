fun main() {
    val jdbcTemplate = Conexao().conectar()
    val repositorio = Repositorio()
    repositorio.iniciar(jdbcTemplate)
    repositorio.criarTabelas()
}
fun main() {
    val jdbcTemplate = Conexao().conectar()
    val repositorio = PizzaRepositorio()
    repositorio.iniciar(jdbcTemplate)
    repositorio.criarTabelas()
}
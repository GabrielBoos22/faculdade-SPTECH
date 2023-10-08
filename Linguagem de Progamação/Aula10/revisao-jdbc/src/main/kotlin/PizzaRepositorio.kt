import org.springframework.jdbc.core.JdbcTemplate

class PizzaRepositorio {
    lateinit var jdbcTemplate: JdbcTemplate

    fun iniciar(conexao: JdbcTemplate) {
        jdbcTemplate = conexao
    }

    fun criarTabelas(){
        jdbcTemplate!!.execute("""
            create table filme(
            id INT GENERATED BY DEFAULT AS IDENTITY primary key,
            nome varchar(45),
            diretor varchar(45),
            indicadoOscar boolean,
            custoProducao double
            )
        """.trimIndent())
    }
}
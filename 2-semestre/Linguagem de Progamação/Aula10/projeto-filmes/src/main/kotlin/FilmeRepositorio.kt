import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate

class FilmeRepositorio {
    lateinit var jdbcTemplate: JdbcTemplate

    fun iniciar(){
        jdbcTemplate = Conexao.jdbcTemplate!!
    }

    fun cadastrar(novoFilme: Filme){
        jdbcTemplate.execute("""
            insert into filme(nome, diretor, custoProducao,indicadoOscar)
            values
            ('${novoFilme.nome}', '${novoFilme.diretor}', ${novoFilme.custoProducao},${novoFilme.indicadoOscar})
        """)
    }

    fun consultar(id: Int):Filme{
        val filme = jdbcTemplate.queryForObject("""
            select * from filme where id = ${id}
        """.trimIndent(), BeanPropertyRowMapper(Filme::class.java))

        return filme
    }

    fun deletar(id: Int): Boolean{
        val deletado = jdbcTemplate.update(
            """
                DELETE FROM filme WHERE id = ${id}
            """.trimIndent())
        return deletado>0
    }


}
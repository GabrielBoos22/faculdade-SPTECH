import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.queryForObject

class PizzaRepositorio{
    lateinit var jdbcTemplate: JdbcTemplate

    fun iniciar(){
        // aqui usamos !! porque está com ? na Conexão
        //isso significa que aceitamos que pode ocorrer um erro
        // já que o jdbcTemplate pode estar nulo (null)
        jdbcTemplate = Conexao.jdbcTemplate!!
    }

    fun cadastrar(novaPizza: Pizza){
        jdbcTemplate.update("""
            insert into pizza(sabor, preco, quantidade)
            values
            ('${novaPizza.sabor}', ${novaPizza.preco}, ${novaPizza.quantidade})
        """.trimIndent())
    }

    fun getUltimoCodigo():Int{
        var ultimoCodigo = jdbcTemplate.queryForObject(
            """
                select max(codigo) from pizza
            """, Int::class.java
        )
        return ultimoCodigo
    }

    fun vender(codigo: Int): Boolean{
        val atualizados = jdbcTemplate.update("""
            update pizza set quantidade = quantidade-1
            where 
            codigo = $codigo
            and quantidade > 0
        """)

        return atualizados == 1
    }

    fun recuperar(codigo:Int):Pizza{
        val pizza = jdbcTemplate.queryForObject("""
            select * from pizza where codigo = $codigo
        """, BeanPropertyRowMapper(Pizza::class.java))
        return pizza
    }

    fun buscarPizzaPreco(codigo2:Int):Pizza{
        val pizza = jdbcTemplate.queryForObject("""
            select * from pizza where codigo = $codigo2
        """, BeanPropertyRowMapper(Pizza::class.java))
        return pizza
    }

    fun mudarPizzaPreco(preco:Double, codigo2: Int):Boolean{
        val novaPizza = jdbcTemplate.update("""
            update pizza SET preco = $preco
            WHERE codigo = $codigo2
        """)
        return novaPizza == 1
    }

    fun pegarNovoPreco(pizza:Pizza):Double {
        var novoPreco = jdbcTemplate.queryForObject(
            """
                SELECT preco FROM pizza where codigo = ${pizza.codigo}
            """, Double::class.java
        )
        return novoPreco
    }
}
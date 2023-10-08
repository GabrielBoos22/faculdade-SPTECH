import org.apache.commons.dbcp2.BasicDataSource
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate

fun main() {
    val dataSource = BasicDataSource();
    dataSource.driverClassName = "org.h2.Driver"

    // exemplo para MySql: "com.mysql.cj.jdbc.Driver"
    // exemplo para H2: "org.h2.Driver"

    dataSource.url = "jdbc:h2:mem:sptech"
    // exemplo para MySql: "jdbc:mysql://localhost:3306/meubanco"
    // exemplo para H2 em memória: "jdbc:h2:mem:meu-banco"
    // exemplo para H2 em em disco, na pasta do projeto: "jdbc:h2:./meu-banco"

    // login (por padrão no H2, é sa)
    dataSource.username = "sa"
    dataSource.password = ""

    // criando o objeto que permite interagir com o banco
    val jdbcTemplate = JdbcTemplate(dataSource)

    jdbcTemplate.execute("""
        CREATE TABLE musica(
            id INT PRIMARY KEY,
            nome varchar(20) NOT NULL
        )
    """)

    // aqui usamos o "update()", que executa uma instrução DML
    // DML -> Insert, delete ou update
    // ao ser executado, ele retorna o número inteiro que é quantas linhas do banco foram afetadas
    val linhasAfetadas = jdbcTemplate.update("""
        insert into musica(id, nome) values
        (1, 'Set Mago Intergalát'), (2, 'Bora Bill Do Submund'), (3, 'Dj Roca')
    """)

    println("$linhasAfetadas linhas inseridas")

    // queryForList() executa uma consulta(select)
    // o resultado é uma lista de objetos
    val musicas = jdbcTemplate.queryForList("SELECT * FROM musica")
    println(musicas)

    val listaMusicas:List<Musica> = jdbcTemplate.query(
        "select * from musica",
        BeanPropertyRowMapper(Musica::class.java)
    )

    listaMusicas.forEach{
        println("Musica ${it.id} - ${it.nome}")
    }

}
package sptech.projetojpa3.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import sptech.projetojpa3.dominio.Musica
import java.time.LocalDate
import java.util.Optional


/*
Uma Repository centraliza os comandos de acesso a banco de dados
de uma entidade (tabela)

JpaRepository<1,2>
1 - Classe da Entidade
2 - Classe do Id (PK) da Entidade

Não é necessário criar uma implementação dessa interface.
O Spring criará uma com os comandos SQL para o banco de dados que estivermos usando
 */

interface MusicaRepository : JpaRepository<Musica, Int> {

    /*
Aqui usamos uma técnica chamada Dynamic Finder
    
     */
    fun findByNome(nome:String): List<Musica>

    fun findByNomeContains(nome:String): List<Musica>

    fun findByLancamentoAfter(data: LocalDate): List<Musica>

    fun findTop1ByOrderByLancamentoDesc(): Optional<Musica>

    /*
    Na anotação @Query, por padrão, usamos uma linguagem chamada JPQL
    Ela é orientada a objetos. Portanto, nela, usamos os nomes das Entidades e atributos.
    Por isso "musica" não funcionaria.Só "mus"

    As instruções JPQL são convertidas em SQL nativo pelo JPA.
    Uma instrução JPQL pode ter parametros usando ?
    ?1, o primeiro parametro
    ?2, o segundo parametro
    ?3, o terceiro parametro
     */
    @Query("select m.foto from Musica m where m.codigo = ?1")
    fun recuperarFoto(codigo:Int):ByteArray

    fun findByCompositorCodigo(codigo: Int): List<Musica>

    /*
    Aqui consultamos todas as mu
     */
    fun findByCompositorNomeContains(nome: String): List<Musica>
}


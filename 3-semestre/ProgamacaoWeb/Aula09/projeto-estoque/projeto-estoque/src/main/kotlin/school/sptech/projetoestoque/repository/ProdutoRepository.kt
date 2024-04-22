package school.sptech.projetoestoque.repository

import jakarta.validation.constraints.Max
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import school.sptech.projetoestoque.dominio.Produto

interface ProdutoRepository : JpaRepository<Produto, Int> {
    /*
        SELECT p FROM PRODUTO p JOIN FABRICANTE f on p.fabricante.id = f.id where f.id

        findByFabricanteId
        SELECT p FROM Produto p WHERE p.fabricante.id = ?
    */
    fun findByFabricanteId(id: Int): List<Produto>

    @Query("SELECT p FROM Produto p WHERE p.fabricante.id = :id")
    fun buscaPorFabricanteId(id: Int): List<Produto>

    // busquem por quantidade de estoque entre 5 e 10
    fun findByQtdEstoqueBetween(min: Int, max: Int): List<Produto>

    @Query("SELECT p FROM Produto p WHERE p.qtdEstoque >= :qtdMin AND p.qtdEstoque <= :qtdMax")
    fun buscarEntreDuasQuantidades(qtdMin: Int, qtdMax: Int)
}
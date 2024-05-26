package school.sptech.projetoestoque.dto

data class ProdutoContabilResponse (
    var id: Int? = null,
    var nome: String? = null,
    var qtdEstoque: Int? = null,
    var preco: Double? = null
){

    fun getValorTotalEstoque(): Double{
        return qtdEstoque!! * preco!!;
    }

    fun isEsgotado():Boolean{
        return qtdEstoque!! == 0
    }
}
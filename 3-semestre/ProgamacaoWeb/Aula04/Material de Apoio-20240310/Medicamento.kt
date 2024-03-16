package school.sptech.projeto03verboshttp

data class Medicamento(
    val codigo:String,
    val nome:String,
    var valorUnd:Double,
    var quantidade:Int,
    var precisaReceita:Boolean
) {
    fun atualizar(atualizacao:PatchMedicamento) {
        valorUnd = atualizacao.novoValorUnd
        quantidade += atualizacao.quantidadeEntrada
    }
}
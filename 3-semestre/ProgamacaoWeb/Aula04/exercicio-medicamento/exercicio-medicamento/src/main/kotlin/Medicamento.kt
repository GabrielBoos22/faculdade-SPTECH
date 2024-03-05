class Medicamento (
    var codigo: String,
    var nome: String,
    var valorUnd: Double,
    var quantidade: Int,
    var precisaReceita: Boolean
){

    fun atualizaMedicamento(atualizacao: MedicamentoAlterado){
        valorUnd = atualizacao.novoValorUnd
        quantidade += atualizacao.quantidadeEntrada
    }
}
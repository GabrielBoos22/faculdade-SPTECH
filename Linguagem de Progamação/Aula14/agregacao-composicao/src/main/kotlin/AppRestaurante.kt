package composicao

fun main() {
    val conta1 = Conta()
    conta1.adicionarItem("pizza estrogonofe", 20.0, 1)
    conta1.adicionarItem("pizza 4 queijos", 25.0, 1)
    conta1.adicionarItem("suco natural", 8.0, 4)

    val conta2 = Conta()
    conta2.adicionarItem("pizza estrogonofe", 20.0, 1)
    conta2.adicionarItem("pizza 4 queijos", 25.0, 1)
    conta2.adicionarItem("suco natural", 8.0, 4)

    println()
}
fun main() {
    val banco = Banco(nome="Reis", saldo=150000.02)
    println("Depositando 2 reais")
    banco.depositar(2.0)

    println("Saldo: ${banco.getSaldo()}")
    println("Retirando 100 mil")
    val saldoAposRetirada = banco.retirar(100000.0)
    println("Saldo: ${"%.2f".format(saldoAposRetirada)}")
}
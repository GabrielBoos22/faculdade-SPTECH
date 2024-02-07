class Peixe : Animal() {
    override fun nascer() {
        println("Peixinho nascendo de uma ova")
    }

    override fun respirar() {
        println("Peixe tirando o ar da águja para, então...")
        super.respirar()
    }

    override fun comer(alimento: String, quantidade: Double): Double {
        println("Peixe beliscando e comendo ${alimento} nadando")
        return 0.99 * quantidade
    }
}
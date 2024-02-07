class Pato : Animal() {
    override fun nascer() {
        println("Patinho nascendo do ovo da Pata")
    }

    override fun comer(alimento: String, quantidade: Double): Double {
        println("Patinho bicando e comendo $alimento de pé")
        return 0.8 * quantidade
    }
}
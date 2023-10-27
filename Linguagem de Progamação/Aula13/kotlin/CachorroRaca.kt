class CachorroRaca: Cachorro() {

    override fun getMultiplicadorPesoCachorro(): Double {
        return 0.5
    }

    override fun getCorrerCachorro(): Boolean {
        return false
    }

    override fun getPrecoMedio(): Double {
        return 2000.0
    }
}
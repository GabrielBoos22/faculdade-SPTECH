class CarroPobre: Carro() {
    override fun getReacaoPessoas(): String {
        return "Nossa, essa $fabricante $modelo é Mó Paia!"
    }

    override fun getVelocidadeAceleracao(): Double {
        return 2.3
    }

    override fun getVelocidadeFreada(): Double {
        return 5.4
    }

    override fun getVelocidadeMaxima(): Double {
        return 120.0
    }
}
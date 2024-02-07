fun main() {
    /*
    Aqui estamos CRIANDO ou INSTANCIANDO um objeto do tipo Heroi
    "faça-se um Heroi! seu nome em memória será 'heroi1'"
     */
    val heroi1 = Heroi()
    println(heroi1.nome)
    println(heroi1.poderes)
    println(heroi1.vida)
    println(heroi1.aposentado)

    heroi1.nome = "Goku"
    heroi1.poderes = "Voar, teletransportar, transformar"
    heroi1.vida = 30.5

    println(heroi1.nome)
    println(heroi1.poderes)
    println(heroi1.vida)

    heroi1.usarPoder()

    val heroiB = Heroi()
    println(heroiB.nome)
    println(heroiB.poderes)
    heroiB.usarPoder()

    println("O herói1 está aposentado? ${heroi1.aposentado}")
    heroi1.aposentar()
    println("O herói1 está aposentado? ${heroi1.aposentado}")

    println("Quanto de vida o B tem? ${heroiB.vida}")
    heroiB.apanhar(5.0)
    println("Quanto de vida o B tem? ${heroiB.vida}")
    heroiB.apanhar(15.0)
    println("Quanto de vida o B tem? ${heroiB.vida}")
    heroiB.apanhar(33.0)
    println("Quanto de vida o B tem? ${heroiB.vida}")

    heroi1.apanhar(90.0)
    println("Quanto de vida o A tem? ${heroi1.vida}")
}
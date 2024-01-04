/*
Toda classe que não é abstrata, é uma classe concreta

Neste caso, dizemos que Cachorro implementa Animal
podemos ainda dizer que Cachorro extende Animal, não está errado
 */
class Cachorro : Animal() {

    override fun nascer() {
        println("Cachorro nascendo do ventre de sua mãe")
    }

    override fun comer(alimento: String, quantidade: Double): Double {
        println("Cão mastigando $alimento sentado")
        return 0.9 * quantidade
    }
}
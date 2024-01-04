/*
Classes abstratas NÃO devem ser "open"
Pq já são "open" por padrão
 */
abstract class Animal {

    var nome: String = ""

    // uma abstrata PODE ter métodos concretos
    open fun respirar(){
        println("Animal ficando com oxigênio e liberando gás carbônico")
    }

    // este é um exemplo de método abstrato. Note que ele não tem corpo
    abstract fun nascer()

    abstract fun comer(alimento: String, quantidade: Double): Double
}

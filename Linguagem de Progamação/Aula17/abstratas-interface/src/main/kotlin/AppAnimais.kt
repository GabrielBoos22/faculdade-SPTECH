fun main() {
    // o código abaixo NÃO compila porque Animal é abstrata
    // logo, não podemos criar um objeto a partir de uma classe abstrata
     // val bicho:Animal = Cachorro()
     val dog:Animal = Cachorro()
     val dog2 = Cachorro()
     val dog3:Cachorro = Cachorro()

     val duck:Animal = Pato()

     dog.nascer()
     dog.respirar()

     duck.nascer()
     duck.respirar()

     val fish:Animal = Peixe()
     fish.respirar()

     println("Cachorro engordou ${dog.comer("ração", 300.0)}kg após comer")
     println("Peixe engordou ${fish.comer("plankton", 300.0)}kg após comer")
     println("Pato engordou ${duck.comer("milho", 300.0)}kg após comer")
}
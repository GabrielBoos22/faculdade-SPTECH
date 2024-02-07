fun main() {
  var xicara = "Café";

  println("Voce tem uma xicara com $xicara")
    entregarParaAlguem(xicara)
    esquentar(xicara)
  println("\n$xicara quente")
}

fun entregarParaAlguem(xicara: String) {
    println("Voce entregou o seu $xicara para fulano esquentar e ele levou para o microondas")
}

fun esquentar(xicara: String): String {
    println("Esquentando xícara com $xicara...")
    println("Vrumm Vrumm Vrumm...")
    return "$xicara está quente!"
}
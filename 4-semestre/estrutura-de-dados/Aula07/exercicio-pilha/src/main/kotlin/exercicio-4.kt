import java.text.Normalizer
import java.util.Stack


fun ehPalindromo(frase: String): Boolean {
    val fraseSemAcento = removerAcentos(frase)
    val pilha = Stack<Char>()
    val fraseFiltrada = StringBuilder()

    // Filtra a frase: remove espaços, acentos, letras maiúsculas e outros caracteres
    for (caractere in fraseSemAcento) {
        if (caractere.isLetterOrDigit()) {
            fraseFiltrada.append(caractere.lowercaseChar())
            pilha.push(caractere.lowercaseChar())
        }
    }

    // Agora vamos verificar se a frase é igual ao seu inverso
    for (caractere in fraseFiltrada) {
        if (caractere != pilha.pop()) {
            return false
        }
    }

    return true
}

// Função principal para testar
fun main() {
    val frases = listOf(
        "radar",
        "ovo",
        "Ana",
        "subi no ônibus",
        "Socorram-me subi no ônibus em Marrocos",
        "anotaram a data da maratona",
        "a torre da derrota",
        "não é um palíndromo"
    )

    for (frase in frases) {
        if (ehPalindromo(frase)) {
            println("\"$frase\" é um palíndromo.")
        } else {
            println("\"$frase\" não é um palíndromo.")
        }
    }

}

fun removerAcentos(texto: String): String {
    return Normalizer.normalize(texto, Normalizer.Form.NFD)
        .replace(Regex("[\\p{InCombiningDiacriticalMarks}]"), "")
}

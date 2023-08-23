import kotlin.math.pow
import kotlin.reflect.typeOf

fun main() {
    println("É nois no Kotlin!");
    println("Segunda linham loka");
    println();
    println("Onde Estou");
    println("\nE eu, \nonde estou?");
    println("\r\nEra uma vez\r\num lugarzinho no meio do nada");

    var bairro = "Bela Vista";
    // variavel String (texto)
    var populacao = 5000;
    // variavel int (numero inteiro)
    var ligado = false;
    // variavel booleana
    var altura = 1.88
    // variavel double (número real)

    /*
    A interpolação (String Template) deve ser feito entre aspas duplas
    podemos usar apenas $ ou ${}. Porém apenas $ permite usar só o valor se usarmos ${}
    podemos invocar funções e executar códigos
     */

    println("No bairro ${bairro} moram ${populacao} pessoas")
    println("No bairro $bairro moram $populacao pessoas")

    println("No bairro ${bairro.uppercase()} o IDH é ${(10+ 9)/3.0}")

    // operações matemáticas básicas
    val soma = 5+5
    val multi = 3*3
    val divisao = 90/2
    val subtracao = 8 - 3
    val potencia = Math.pow(2.0, 3.0)
    val potencia2 = 2.0.pow(3)
    println("potencia 1: $potencia")
    println("potencia 1: $potencia2")

    var endereco = "rua loka, 10"
    endereco = "rua dahora, 95"

    /*
    Variáveis criadas com "var" não podem ter o valor alterado]
    Mas as criadas com "val" NÃO podem ter o valor alterado NUNCA!
     Ou seja, é uma variável IMUTÁVEL
     */

    val cpf = "12345678121"


    println(endereco)
    println(cpf)

    var idade = 12;
    /*
    As estruturas if; if-else e if-else-if
    funcionam como no JavaScript
     */
    if(idade >= 18){ // todos os operadores de comparação são os mesmos do JS
        println("maior de idade")
    } else {
        println("vai jogar PS!")
    }

    var contador = 0
    /*
    O while funciona de maneira semelhante ao JS
     */
    while(contador < 4){
        println("100 querer 20 amar")
        contador ++
    }

    idade = -99
    when(idade){
        in 0..6 -> println("bebê")
        in 7..10 -> { // para execirar +1 linha, abra chaves
            println("criancinha")
            println("não deixe ela morrer!")
        }
        14 -> println("adolescente")
        22 -> println("adulto")
        65 -> println("melhor idade")
        in 130..Int.MAX_VALUE -> println("Matusalém")
        else -> println("idade inválida")
    }

    var salario = 2500
    var classeSocial = when (salario){
        in 0..500 -> "D"
        in 501..1500 -> "C"
        in 1501..5000 -> "B"
        in 5001..50000 -> "A"
        else -> "Inválida" // else é obrigatório p/ when com atribuição
    }
    println(classeSocial)
}
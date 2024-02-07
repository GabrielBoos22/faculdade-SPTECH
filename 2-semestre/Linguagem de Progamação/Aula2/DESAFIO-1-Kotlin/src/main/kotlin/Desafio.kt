import javax.swing.JOptionPane

fun main() {
    val nome: String = JOptionPane.showInputDialog("Qual o nome do herói");
    val forca: Int = JOptionPane.showInputDialog("Qual a sua força?").toInt();

    if (forca < 0){
        exibeMensagem("Erro, força negativa")
        main()
    }

    val feitos: Int = JOptionPane.showInputDialog("Quantos feitos esse personagem tem?").toInt();
    var soma = 0
    var contador = 1

    while(contador <= feitos){
        var valor: Int = JOptionPane.showInputDialog("Qual o valor do $contador feito?").toInt()
        if(valor < 1 && valor > 50 ){
            exibeMensagem("Erro, valor de feito inválido")
        } else {
            soma = soma + valor;
            contador++
        }
    }

    var popularidade = verPopularidade()
    var pontuacao = (forca * 10) + (soma * 5) + popularidade
    var classe = ""
    when(pontuacao){
        in 0..50000 -> classe = "S"
        in 10000..50000 -> classe = "A"
        in 1000..10000 -> classe = "B"
        in 0..1000 -> classe = "C"
    }

    exibeMensagem("O herói $nome tem a pontuação de $pontuacao, estando classificado para a classe $classe ")
}

fun verPopularidade(): Int{
    val popularidade: Int = JOptionPane.showInputDialog("Qual popularidade?").toInt();
    if(popularidade < 0 && popularidade > 100){
        exibeMensagem("Popularidade inválida")
        verPopularidade()
    } else{
        return popularidade
    }
    return popularidade
}

fun exibeMensagem(frase: String) {
    JOptionPane.showMessageDialog(null, frase)
}
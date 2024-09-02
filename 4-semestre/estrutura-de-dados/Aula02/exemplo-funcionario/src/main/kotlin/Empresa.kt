package org.example

class Empresa {

    var funcionarios = mutableListOf<Funcionario>()

    fun adicionaFun (f: Funcionario) {
        funcionarios.add(f)
    }

    fun exibeTodos(){
        funcionarios.forEach {
            println(it)
        }
        println()
    }

    fun exibeTotalSalarios(){
        var total = 0.0;
        for (funcionario in funcionarios){
            total += funcionario.calcSalario()
        }
        println("Total de Salários dos" +
                "Funcionários = $total")
    }

    fun exibirEngenheiros (){
        funcionarios.forEach {
            if(it is Engenheiro){
                println(it)
            }
        }
        println()
    }
}
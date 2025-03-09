fun main() {

    // 6- Crie uma lista imutável com pelo menos 5 objetos Paciente.
    val listaPaciente = listOf(Paciente(1, "Thiago", false, "Dor de cabeça", 25, 70.0),
        Paciente(2, "Nathalia", true, "Dor de barriga", 30, 80.0),
        Paciente(3, "Ana", false, "Dor de garganta", 35, 90.0),
        Paciente(4, "Guilherme", true, "Dor de ouvido", 40, 100.0),
        Paciente(5, "Maria", false, "Dor de dente", 45, 110.0))
    // De forma funcional e sem utilizar variáveis conclua os passos a seguir...

    // 7- Filtre a lista do passo 6 para conter apenas pacientes menores que 30 anos e exiba cada item da lista
    // em uma linha separada.
    listaPaciente.filter { it.idade < 30 }.forEach { println(it) }
    // 8- Exiba a soma das idades de todos os pacientes.
    println(listaPaciente.sumOf { it.idade })
    // 9- Exiba a soma dos pesos apenas dos pacientes prioritários.
    println(listaPaciente.filter { it.prioritario }.sumOf { it.peso })
}
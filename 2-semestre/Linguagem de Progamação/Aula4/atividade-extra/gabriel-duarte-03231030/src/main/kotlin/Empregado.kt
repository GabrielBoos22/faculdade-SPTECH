import java.math.BigDecimal

class Empregado {
    var nome: String = "";
    var cargo: String = "Estagiario";
    var salario: BigDecimal = BigDecimal.valueOf(700.00);

    fun reajustarSalario(): BigDecimal{
        val aumento = BigDecimal("1.1")
        salario = salario.multiply(aumento)
        return salario;
    }

    fun aumentarCargo(): BigDecimal{
        when(cargo){
            "Estagiario" -> {cargo = "Analista Junior"
                salario = salario.multiply(BigDecimal("1.2"))
                return salario;
            }
            "Analista Junior" -> {cargo = "Analista Pleno"
                salario = salario.multiply(BigDecimal("1.3"))
                return salario;
            }
            "Analista Pleno" -> {cargo = "Analista Senior"
                salario = salario.multiply(BigDecimal("1.4"))
                return salario;
            }
            "Analista Senior" -> {cargo = "Tech Lead"
                salario = salario.multiply(BigDecimal("1.5"))
                return salario;
            }
    }
        return salario;
    }
    fun tirarFerias(): BigDecimal{
        return salario.multiply(BigDecimal(2))
    }
}
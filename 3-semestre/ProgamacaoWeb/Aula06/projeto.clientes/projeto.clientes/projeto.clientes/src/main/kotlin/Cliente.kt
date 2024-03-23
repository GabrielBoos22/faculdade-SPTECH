import jakarta.validation.constraints.*
import org.hibernate.validator.constraints.br.CNPJ
import org.hibernate.validator.constraints.br.CPF
import org.hibernate.validator.constraints.br.TituloEleitoral
import java.time.LocalDate
import javax.print.DocFlavor.STRING

data class Cliente (
    /*
    NotBlank -> rejeita null, "" e "    "
    Usado APENAS para String. Não usar para outros tipos
     */
    @field:NotBlank @field:Size(min=3, max=5)
    var codigo: String,
    var nome: String,
    @field:NotNull @field:DecimalMin("1050.00")
    var salario: Double,
    @field:Past
    var nascimento:LocalDate,
    @field:Future
    var validadeCadastro: LocalDate,
    @field:PositiveOrZero
    var filhos: Int,
    @field:Email var email: String,
    @field:CPF var cpf:String,
    @field:CNPJ var cnpj: String,
    @field:TituloEleitoral var tituloEleitor: String
    )
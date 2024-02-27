package school.sptech.projeto03verboshttp

import java.time.LocalDate
import java.time.LocalDateTime

class Musica (
        var nome: String,
        var banda: String,
        var data: LocalDateTime = LocalDateTime.now()
){
}
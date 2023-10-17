p <- 200000
n <- 15000
pop.escolaridade <- rep(c(0,1,2,3,4,5,6),p)
set.seed(20)
escolaridade.temp <- sample(pop.escolaridade, n)
escolaridade <- factor(escolaridade.temp,
                         + levels = c(0,1,2,3,4,5,6),
                         + labels = c("analfabeto", "1º grau", "2º grau", "3º grau", "mestrado"
                                      , "doutorado", "posdoc"),
                         + ordered = TRUE)

set.seed(20)
notas <- data.frame(Matricula = sample(x = 011475:012990, size = 30, replace = FALSE),
                    ac1 = sample(x = 1:10, size = 30, replace = TRUE),
                    ac2 = sample(x = 1:10, size = 30, replace = TRUE),
                    prova_final= sample(x = 1:10, size = 30, replace = TRUE))
notas.aprovados <- factor(notas,
                          levels = c(0,1,2,3,4,5,6,7,8,9,10),
                          labels = c(""))


set.seed(20)

notas <- data.frame(
  Matricula = sample(11475:12990, size = 30, replace = FALSE),
  ac1 = sample(1:10, size = 30, replace = TRUE),
  ac2 = sample(1:10, size = 30, replace = TRUE),
  prova_final = sample(1:10, size = 30, replace = TRUE)
)

notas$media <- (0.4 * notas$ac1 + 0.4 * notas$ac2 + 0.2 * notas$prova_final)

notas$aprovado <- notas$media >= 7
print(notas$aprovado)

aprovados <- sum(notas$aprovado)
print(aprovados)

# Gráfico de barras
barplot(table(notas$aprovado), main = "Alunos Aprovados e Reprovados", 
        xlab = "Situação", ylab = "Quantidade", col = c("red", "green"))
legend("topright", legend = c("Reprovados", "Aprovados"), fill = c("red", "green"))

# Insights
cat("Número de alunos aprovados:", aprovados, "\n")
cat("Número de alunos reprovados:", nrow(notas) - aprovados, "\n")
cat("Porcentagem de alunos aprovados:", (aprovados / nrow(notas)) * 100, "%\n")

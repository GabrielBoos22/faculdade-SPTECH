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
#-------------------------------------------------------------------
#Exercicio 2

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

# ------------------------------------------------------------------
# Exercicio 3 

vendedor <- c("Ana", "Flavia", "Pedro", "Mariana", "Ana", "Flavia", "Pedro", "Mariana")
dia <- c(1,1,1,1,2,2,2,2)
produto <- c("saia","casaco","vestido","meia","calcaFlaire","calcaSkinny","calcasSkinny","manta")
quantidade <- c(1,2,1,5,3,0,3,4)
quadro1 <- data.frame(vendedor, dia, produto, quantidade)
print(quadro1)

precoUnico <- c(145, 289, 320, 39, 240, 240, 240, 69)
quadro1$precoUnico <- precoUnico
quadro1

quadro1$faturamento <- quadro1$quantidade * quadro1$precoUnico

barplot(quadro1$faturamento)

# ----------------------------------------
# 4

x = 1
y = 2

if(typeof(x) != "double" || typeof(y)!="double"){
  print("Valor Incorreto")
}
if(x > y){
  print("primeiro valor é maior")
} else if (y>x) {
  print("segundo valor é maior")
} else {
  print("valores iguais")
}

# ------------------------------------------
# 5

set.seed(15)
vetorNumerico <- sample(x = 1:25, size = 800, replace = TRUE)
hist(vetorNumerico)

# -------------------------------------
# 6 
vendas <- data.frame(Qtd = sample(x = 28:52, size = 30, replace = TRUE),
                     DiaMes = seq(from=as.Date("2021-09-01"), to=as.Date("2021-09-30"), by="day"),
                     DiaSemana = weekdays(seq(from=as.Date("2021-09-01"), to=as.Date("2021-09-30"),
                                              by="day")))
plot(vendas$DiaMes, vendas$Qtd, main = "Frequência da Qtd de vendas",xlab = "Dia", ylab =
       "Qtd vendas")
varmes <- max(vendas$Qtd) - min(vendas$Qtd)

medven<- round(mean(vendas$Qtd))
hist(vendas$Qtd, main = "Frequência da Qtd de vendas",xlab = "Qtd vendas", ylab =
       "Frequência", col = "red")

# --------------------------------------
# 7
dtHoje = as.Date("2023-10-17")
dtNasc = as.Date("2005-05-05")
diferenca = dtHoje - dtNasc
anos = diferenca / 365
anos
diferenca

# -----------------------------------------------
# prova

tempo_emprego <- c("< 2 anos", "Flavia", "Pedro", "Mariana", "Ana", "Flavia", "Pedro", "Mariana")
dia <- c(1,1,1,1,2,2,2,2)
produto <- c("saia","casaco","vestido","meia","calcaFlaire","calcaSkinny","calcasSkinny","manta")
quantidade <- c(1,2,1,5,3,0,3,4)
quadro1 <- data.frame(vendedor, dia, produto, quantidade)


 # Exercício 1
exercicio1 <- factorial(5)
print(exercicio1)

# Exercicio 2
n <- 10
r <- 3
exercicio2 <- choose(n, r)
print(exercicio2)


# Exercicio 3 
n <- 5
r <- 2
exercicio3 <- choose(n, r)
print(exercicio3)

# Exercicio 4
calculate_arranjo <- function(n, r){
   if (n < r){
     return(0) # retorna 0 se n form menor que r
    } else {
       return((factorial(n))/ (factorial(n - r))
      }
  }


exercicio4 <- calculate_arranjo(6, 4)
print(exercicio4)

# Exercicio 5
n <- 6
r <- 3
exercicio5 <- choose(n,r) 
print(exercicio5)
  
#Case 1 

#a)
n <- 50 
p <- 0.75 
k <- 32
prob <- dbinom(k, size = n, prob = p)
mensagem <- paste("A probabilidade de 32 acessos com sucesso simultâneos serem processados com sucesso é de:", prob)
print(mensagem)

#b)
prob_max <- pbinom(45, size = n, prob = p)
mensagem <- paste("A probabilidade de no máximo 45 solicitações de CPU serem processadas com sucesso:", prob_max)
print(mensagem)

#c)
media_sucesso <- n * p
mensagem <- paste("A quantidade desolicitações com sucessos no processo de CPU são esperadas em média:", media_sucesso)
print(mensagem)
#d)
prob_90 <- qbinom(0.9, size=n, prob=.75)
mensagem <- paste("O número mínimo de sucessos de CPU necessário para que haja pelo menos 90% de probabilidade de
alcançá-lo no tempo estudado:", prob_90)
print(mensagem)

# Case 2
#a)
set.seed(50)
media_dados <- 40
desvio_padrao_dados <- 5

distribuicao <- rnorm(144, mean = media_dados, sd = desvio_padrao_dados)
hist(distribuicao)

#b)
probabilidade <- 1 - pnorm(45, mean = media_dados, sd = desvio_padrao_dados)
probabilidade

#c)
prob <- qnorm(0.9, mean = media_dados, sd = desvio_padrao_dados)
prob

#d)
# Crie um histograma
hist(distribuicao, breaks = 20, prob = TRUE, main = "Distribuição de Temperatura
da Placa-Mãe", xlab = "Temperatura (°C)")

# Crie a curva de densidade de probabilidade
x <- seq(20, 60, length = 100)
densidade_probabilidade <- dnorm(x, mean = 40, sd = 5)
lines(x, densidade_probabilidade, col = "red", lwd = 2)

mensagem <- paste("A probabilidade de a temperatura da placa mãe exceder 45ºC é de aproximadamente", probabilidade)
print(mensagem)

mensagem <- paste("O valor crítico acima do qual apenas 10% das observações estão é igual a aproximadamente", prob)
print(mensagem)




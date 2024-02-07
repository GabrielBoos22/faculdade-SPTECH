qp <- 200000
n <- 20000
set.seed(15)
pop.carros <- rep(c(0,1,2,3),p)
summary(pop.carros)
table(pop.carros)
prop.table(table(pop.carros))
carros <- sample(pop.carros, n)
table(carros)

pop.escolaridade <- rep(c(0, 1, 2, 3, 4, 5, 6), p)
set.seed(1234)
escolaridade.temp <- sample(pop.escolaridade, n)
escolaridade <- factor(escolaridade.temp,
                         levels = c(0, 1, 2, 3, 4, 5, 6),
                         labels = c("Analfabeto", "1º Grau", "2º Grau", "3º Grau",
                                      "Mestrado", "Doutorado", "PósDoc"),
                         ordered = TRUE)
table(escolaridade)
hist(escolaridade)
plot(escolaridade)

fumante.n <- rbinom(n, 1, 0.4)
fumante.f <- factor(fumante.n,
levels = c(0,1),
labels = c("não", "sim"),
ordered = TRUE)
table(fumante.f)

par(mfrow = c(1,2)) #mostra os dois gráficos um do lado do outro
barplot(table(escolaridade), ylab = "Número de participantes")
barplot(table(fumante.f), ylab = "Número de participantes")

par(mfrow=c(1,2))
barplot(round(prop.table(table(escolaridade)),3),
          ylab = "Proporção dos participantes")
> barplot(round(prop.table(table(fumante.f)),3),
          + ylab = "Proporção dos participantes")

p <- 200000
n <- 15000
pop.escolaridade <- rep(c(0,1,2,3,4,5,6),p)
set.seed(15)
escolaridade.temp <- sample(pop.escolaridade, n)
escolaridade <- factor(escolaridade.temp, levels = c(0,1,2,3,4,5,6),
                       labels = c("analfabeto", "1º grau", "2º grau",
                       "3º grau", "mestrado", "doutorado", "posdoc"),
                       ordered = TRUE)

set.seed(15)
fumante.n <- rbinom(n, 1, .40)
fumante.f <- factor(fumante.n,
                    levels = c(0,1),
                    labels = c("não", "sim"),
                    ordered = TRUE)

par(mfrow = c(1,2)) #mostra os dois gráficos um do lado do outro
barplot(table(escolaridade), ylab = "Número de participantes")
barplot(table(fumante.f), ylab = "Número de participantes")


                         
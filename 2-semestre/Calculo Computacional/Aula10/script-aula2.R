alt <- c(3,4,3,2,5,2,3,1,3,2,6,5,4,8,6,3,5,3,7,8)
luminosidade <- rep(c("muita","pouca"),each=10)
dados <- data.frame(alt,luminosidade)
dados

fol<-c(19,21,18,18,16,21,23,21,25,22,9,7,6,7,12,9,12,2,9,4)
dados$fol<-fol
dados

names(dados)
names(dados)<-c("altura","luz","folhas")

dados$folhas

dados[1,]
dados[1:3,]
dados[c(1,2,5),]
dados[,2]
dados[8,3]
dados[3,1:2]

subset(dados, luz =='muita')
dados[dados$altura > 3 & dados$luz =="muita", ]
subset(dados,altura > 3)
subset(dados,altura > 3 & luz == "muita" & folhas > 20
dados[1,1] <- 4
dados[dados$altura > 3,1]<-10

name <- readline(prompt="Digite seu nome: ")
print(name)
peso <- readline("Informe seu peso")
peso <- as.integer(peso)
altura <- readline("Informe sua altura")
altura <- as.double(altura)
IMC <- peso/altura**2
print(round(IMC,2))
       
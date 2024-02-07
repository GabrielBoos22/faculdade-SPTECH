p <- 200000
n <- 20000
set.seed(1234)
idade <- abs(round(rnorm(n, 35, 7), 0))
summary(idade)
hist(idade,
    main = "Histograma  da Idade",
    ylab = "Frequencia",
    xlab = "idade (em anos completos)")
    
altura <- abs(round(rnorm(n, 1.60, 0.10),2))
summary(altura)

hist(altura,
     main = "Histograma da altura",
     ylab = "Frequência",
     xlab = "Altura (em metros)")

peso <- abs(round(rnorm(n, 70, 2),2))
summary(peso)

hist(peso,
     main = "Histograma do peso",
     ylab = "Frequência",
     xlab = "Peso (em kg)")


a=12
b=2
c=3
z=c(a,b,c)

rep(2)
rep(2,4)
seq(100,10)

xvector <- c(10, 20, 20, 23, 25, 45, 4, 10)
mean(xvector)

xvector<- c(1,2,3,4,5, NA)
mean(xvector, na.rm=TRUE)

x<-(1:5)
x<- c(1,1,2,2,3,3,4,4,5,5)
vectort<-length(x)

m<-matrix(1:30, nrow=5,ncol=6)


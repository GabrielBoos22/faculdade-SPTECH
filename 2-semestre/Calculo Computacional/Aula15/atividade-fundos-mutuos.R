fundo <- c(5.27, 43.08, -1.02, 56.94, 56.71, 12.48,11.61,27.76,-12.05,4.74, -5.79, 44.74, 0.76, 14.89,14.65, 4.12, 16.93, 26.34, -8.6)
eafe <- c(-0.86, 24.61, 7.86, 56.72, 69.94, 24.93, 28.59, 10.80, -23.20, 12.5, -11.85, 32.94, 8.06, 11.55, 6.36, 2.06, 20.33, 27.30, -13.96)

plot(eafe, fundo)
modelo <- lm(fundo~eafe)
summary(modelo)
cor.test(eafe, fundo)

iiq = 26.11 - 4.21
outlier1 = 4.21 - 1.5*iiq
outlier2 = 26.11 + 1.5 * iiq
dados <- data.frame(eafe)
subset(dados, dados$eafe < outlier1)
subset(dados, dados$eafe > outlier2)

iiq = 27.05 - 2.44
outlier1 = 2.44 - 1.5*iiq
outlier2 = 27.05 + 1.5 * iiq
dados <- data.frame(fundo)
subset(dados, dados$fundo < outlier1)
subset(dados, dados$fundo > outlier2)


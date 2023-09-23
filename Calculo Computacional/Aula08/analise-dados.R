# Lê o arquivo CSV
trusted.open.hardware <- read.csv("C:/Users/Vayon24/Desktop/sptech/Downloads/OpenHardwareMonitor/trusted-open-hardware.csv", sep=";")

# Cria um gráfico de dispersão com a coluna "cpu_total"
plot(cpu_total ~ seq_along(cpu_total), data = trusted.open.hardware,
     main = "Gráfico de Dispersão da Coluna cpu_total",
     xlab = "Índice",
     ylab = "Valor da CPU Total")


trusted_coleta1_RA03231030 <- read.csv("C:/Users/Vayon24/Desktop/sptech/2-sem-SPTech/Calculo Computacional/Aula08/trusted_coleta1_RA03231030.csv", sep=";")

# Cria um gráfico de dispersão com a coluna "cpu_total"
plot(dado ~ seq_along(dado), data = trusted_coleta1_RA03231030,
     main = "Gráfico de Dispersão da Coluna cpu_total",
     xlab = "Índice",
     ylab = "Valor da CPU Total")


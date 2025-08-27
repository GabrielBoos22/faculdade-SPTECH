import numpy as np
import matplotlib.pyplot as plt
# Cria a malha de pontos (x, y)
x = np.linspace(-10, 30, 400)
y = np.linspace(-10, 30, 400)
X, Y = np.meshgrid(x, y)
# Restrições
R1 = (-X + Y) <= 5 # –x + y <= 5
R2 = (X + 4*Y) <= 45 # x + 4y <= 45
R3 = (2*X + Y) <= 27 # 2x + y <= 27
R4 = (3*X - 4*Y) <= 24 # 3x – 4y <= 24
# Interseção das regiões
region = R1 & R2 & R3 & R4
# Plot
plt.figure(figsize=(6,6))
plt.imshow(region.astype(int),
 extent=(x.min(), x.max(), y.min(), y.max()),
 origin='lower', cmap='Blues', alpha=0.5)

# Linhas das restrições
plt.plot(x, x + 5, label='-x + y = 5')
plt.plot(x, (45 - x) / 4, label='x + 4y = 45')
plt.plot(x, 27 - 2*x, label='2x + y = 27')
plt.plot(x, (3*x - 24) / 4, label='3x - 4y = 24')
# Ajustes do gráfico
plt.xlim(-2, 20)
plt.ylim(-2, 20)
plt.xlabel('x')
plt.ylabel('y')
plt.legend()
plt.show()

R1 = (-X + 2*Y) <= 4 
R2 = (X + 2*Y) <= 6 
R3 = (X + 3*Y) <= 9 

# Interseção das regiões
region = R1 & R2 & R3
# Plot
plt.figure(figsize=(6,6))
plt.imshow(region.astype(int),
 extent=(x.min(), x.max(), y.min(), y.max()),
 origin='lower', cmap='Blues', alpha=0.5)

# Linhas das restrições
plt.plot(x, (x + 4) / 2, label='-x + 2y <= 4')
plt.plot(x, (6 - x) / 2, label='x + 2y <= 6')
plt.plot(x, 27 - 2*x, label='x + 3y <= 9')

# Ajustes do gráfico
plt.xlim(-2, 20)
plt.ylim(-2, 20)
plt.xlabel('x')
plt.ylabel('y')
plt.legend()
plt.title("Gráfico 1")
plt.show()


# ------------------- Gráfico 2-------------------
# 2x1 + x2 <= 2
# x1 + 3x2 <= 3
# x1 >= 0 ; x2 >= 0
R1 = (2*X + Y) <= 2
R2 = (X + 3*Y) <= 3
R3 = X >= 0
R4 = Y >= 0
region = R1 & R2 & R3 & R4

plt.figure(figsize=(6,6))
plt.imshow(region.astype(int),
           extent=(x.min(), x.max(), y.min(), y.max()),
           origin='lower', cmap='Blues', alpha=0.5)

plt.plot(x, 2 - 2*x, label='2x1 + x2 = 2')
plt.plot(x, (3 - x)/3, label='x1 + 3x2 = 3')
plt.axhline(0, color='k', linestyle='--', label='x2 >= 0')
plt.axvline(0, color='k', linestyle='--', label='x1 >= 0')

plt.xlim(-1, 5)
plt.ylim(-1, 5)
plt.xlabel('x1')
plt.ylabel('x2')
plt.legend()
plt.title("Gráfico 2")
plt.show()

# ------------------- Gráfico 3 -------------------
# x1 + 3x2 <= 9
# -x1 + 2x2 <= 4
# x1 + x2 <= 6
# x1 >= 0 ; x2 >= 0
R1 = (X + 3*Y) <= 9
R2 = (-X + 2*Y) <= 4
R3 = (X + Y) <= 6
R4 = X >= 0
R5 = Y >= 0
region = R1 & R2 & R3 & R4 & R5

plt.figure(figsize=(6,6))
plt.imshow(region.astype(int),
           extent=(x.min(), x.max(), y.min(), y.max()),
           origin='lower', cmap='Blues', alpha=0.5)

plt.plot(x, (9 - x)/3, label='x1 + 3x2 = 9')
plt.plot(x, (4 + x)/2, label='-x1 + 2x2 = 4')
plt.plot(x, 6 - x, label='x1 + x2 = 6')
plt.axhline(0, color='k', linestyle='--')
plt.axvline(0, color='k', linestyle='--')

plt.xlim(-1, 10)
plt.ylim(-1, 10)
plt.xlabel('x1')
plt.ylabel('x2')
plt.legend()
plt.title("Gráfico 3")
plt.show()

# ------------------- Gráfico 4 -------------------
# x1 + x2 <= 20
# x1 + x2 >= 10
# 5x1 + 6x2 >= 54
# x1 >= 0 ; x2 >= 0
R1 = (X + Y) <= 20
R2 = (X + Y) >= 10
R3 = (5*X + 6*Y) >= 54
R4 = X >= 0
R5 = Y >= 0
region = R1 & R2 & R3 & R4 & R5

plt.figure(figsize=(6,6))
plt.imshow(region.astype(int),
           extent=(x.min(), x.max(), y.min(), y.max()),
           origin='lower', cmap='Blues', alpha=0.5)

plt.plot(x, 20 - x, label='x1 + x2 = 20')
plt.plot(x, 10 - x, label='x1 + x2 = 10')
plt.plot(x, (54 - 5*x)/6, label='5x1 + 6x2 = 54')
plt.axhline(0, color='k', linestyle='--')
plt.axvline(0, color='k', linestyle='--')

plt.xlim(-1, 20)
plt.ylim(-1, 20)
plt.xlabel('x1')
plt.ylabel('x2')
plt.legend()
plt.title("Gráfico 4")
plt.show()

# ------------------- Gráfico 5 -------------------
# -x1 + x2 <= 2
# x1 <= 5
# x2 <= 6
# 3x1 + 5x2 >= 15
# 5x1 + 4x2 >= 20
# x1 >= 0 ; x2 >= 0
R1 = (-X + Y) <= 2
R2 = X <= 5
R3 = Y <= 6
R4 = (3*X + 5*Y) >= 15
R5 = (5*X + 4*Y) >= 20
R6 = X >= 0
R7 = Y >= 0
region = R1 & R2 & R3 & R4 & R5 & R6 & R7

plt.figure(figsize=(6,6))
plt.imshow(region.astype(int),
           extent=(x.min(), x.max(), y.min(), y.max()),
           origin='lower', cmap='Blues', alpha=0.5)

plt.plot(x, x + 2, label='-x1 + x2 = 2')
plt.axvline(5, color='r', linestyle='-', label='x1 = 5')
plt.axhline(6, color='g', linestyle='-', label='x2 = 6')
plt.plot(x, (15 - 3*x)/5, label='3x1 + 5x2 = 15')
plt.plot(x, (20 - 5*x)/4, label='5x1 + 4x2 = 20')
plt.axhline(0, color='k', linestyle='--')
plt.axvline(0, color='k', linestyle='--')

plt.xlim(-1, 10)
plt.ylim(-1, 10)
plt.xlabel('x1')
plt.ylabel('x2')
plt.legend()
plt.title("Gráfico 5")
plt.show()



# ------------------- Exercicio fabrica -------------------
# Malha de pontos
x1 = np.linspace(0, 20, 400)
x2 = np.linspace(0, 20, 400)
X1, X2 = np.meshgrid(x1, x2)

# Restrições
R1 = (8*X1 + 2*X2) >= 16     # papel fino
R2 = (X1 + X2) >= 6          # papel médio
R3 = (2*X1 + 7*X2) >= 28     # papel grosso
R4 = (X1 >= 0)
R5 = (X2 >= 0)

# Região viável
region = R1 & R2 & R3 & R4 & R5

# Ponto ótimo encontrado
x1_opt, x2_opt = 2.8, 3.2
Z_opt = 1000*x1_opt + 2000*x2_opt

# Plot
plt.figure(figsize=(7,7))
plt.imshow(region.astype(int), 
           extent=(x1.min(), x1.max(), x2.min(), x2.max()),
           origin='lower', cmap='Blues', alpha=0.5)

# Linhas das restrições
plt.plot(x1, (16 - 8*x1)/2, label="8x1 + 2x2 = 16 (Fino)")
plt.plot(x1, 6 - x1, label="x1 + x2 = 6 (Médio)")
plt.plot(x1, (28 - 2*x1)/7, label="2x1 + 7x2 = 28 (Grosso)")

# Eixos
plt.axhline(0, color='k', linestyle='--')
plt.axvline(0, color='k', linestyle='--')

# Ponto ótimo
plt.scatter(x1_opt, x2_opt, color="red", zorder=5, label=f"Ótimo ({x1_opt:.1f}, {x2_opt:.1f})\nCusto = R$ {Z_opt:,.0f}")

# Ajustes do gráfico
plt.xlim(0, 10)
plt.ylim(0, 10)
plt.xlabel("Dias Fábrica 1 (x1)")
plt.ylabel("Dias Fábrica 2 (x2)")
plt.title("Região viável - Produção de Papéis")
plt.legend()
plt.grid(True, linestyle="--", alpha=0.7)
plt.show()

# ------------------- Exercicio investimento -------------------
# Malha
x1 = np.linspace(0, 85000, 400)
x2 = np.linspace(0, 40000, 400)
X1, X2 = np.meshgrid(x1, x2)

# Coeficientes de rendimento
cdb_rate = (1.01)**6      # 1% a.m. por 6 meses
tesouro_rate = 1 + 0.1376/2  # 6 meses
print("CDB fator:", round(cdb_rate,4))
print("Tesouro fator:", round(tesouro_rate,4))

# Restrições
R1 = (X1 + X2) <= 80000
R2 = X2 <= 32000
R3 = (cdb_rate*X1 + tesouro_rate*X2) >= 40000
R4 = (X1 >= 0)
R5 = (X2 >= 0)

region = R1 & R2 & R3 & R4 & R5

# Ponto ótimo
x1_opt, x2_opt = 48000, 32000
Z_opt = cdb_rate*x1_opt + tesouro_rate*x2_opt

# Plot
plt.figure(figsize=(8,6))
plt.imshow(region.astype(int),
           extent=(x1.min(), x1.max(), x2.min(), x2.max()),
           origin='lower', cmap='Blues', alpha=0.5)

# Linhas das restrições
plt.plot(x1, 80000 - x1, label="x1 + x2 = 80.000")
plt.axhline(32000, color='g', linestyle='-', label="x2 = 32.000")
plt.plot(x1, (40000 - cdb_rate*x1)/tesouro_rate, label="Retorno mínimo")

# Ponto ótimo
plt.scatter(x1_opt, x2_opt, color="red", s=80,
            label=f"Ótimo: (x1={x1_opt}, x2={x2_opt})\nFV=R$ {Z_opt:,.0f}")

# Ajustes
plt.xlim(0, 85000)
plt.ylim(0, 40000)
plt.xlabel("Investimento em CDB (x1)")
plt.ylabel("Investimento em Tesouro (x2)")
plt.title("Investimento ótimo no 6º mês")
plt.legend()
plt.grid(True, linestyle="--", alpha=0.6)
plt.show()

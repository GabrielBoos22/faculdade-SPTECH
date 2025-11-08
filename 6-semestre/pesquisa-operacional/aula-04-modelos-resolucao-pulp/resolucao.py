import pulp
import numpy as np
import matplotlib.pyplot as plt

# Dados
backup_total_gb = 103
custos = np.array([0.023, 0.30, 0.004])  # R$/GB/mês
latencias = np.array([0.283, 0.167, 4.000])  # horas
sistemas = ["S3 Standard", "EFS", "S3 Glacier"]

# Modelo
model = pulp.LpProblem("Backup_Optimization", pulp.LpMinimize)

# Variáveis (frações de cada sistema)
x = pulp.LpVariable.dicts("x", sistemas, lowBound=0)

# Função objetivo (minimizar custo total mensal)
model += pulp.lpSum([custos[i] * backup_total_gb * x[sistemas[i]] for i in range(len(sistemas))])

# Restrições
model += pulp.lpSum([x[s] for s in sistemas]) == 1                # todo backup
model += pulp.lpSum([latencias[i] * x[sistemas[i]] for i in range(len(sistemas))]) <= 0.3  # latência

# Resolver
model.solve()

# Resultados
distribuicao = {s: x[s].varValue for s in sistemas}
custo_total = pulp.value(model.objective)

# Exibir resultados
print("Distribuição ótima do backup:")
for s, frac in distribuicao.items():
    print(f"{s}: {frac:.2%}")
print(f"\nCusto total mensal: R$ {custo_total:.2f}")

# Gráfico
fig, ax = plt.subplots()
ax.bar(distribuicao.keys(), distribuicao.values(), color=["blue", "green", "orange"])
ax.set_ylabel("Fração do Backup")
ax.set_title("Distribuição ótima do backup entre sistemas")
plt.show()

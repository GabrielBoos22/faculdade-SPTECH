import pulp


# Variáveis de decisão
# x1 é Caminhão A
# x2 é Caminhão B
x1 = pulp.LpVariable("Caminhão A", cat="Integer")
x2 = pulp.LpVariable("Caminhão B", cat="Integer")

# Problema
prob1 = pulp.LpProblem("Modelo1", pulp.LpMinimize)

# Função objetivo
# Modelo para maximizar o retorno com base no retorno esperado de cada investimento que será alocado
prob1 += 1100 * x1 + 750 * x2

# Restrições 
# Limitação Quantidade de metros cúbicos da área refrigerada 
prob1 += x1 * 2 >= 16
# Limitação Quantidade de metros cúbicos da área não refrigerada 
prob1 += x1 * 3 >= 12
# Limitação Quantidade de metros cúbicos da área refrigerada 
prob1 += x2 * 2 >= 16
# Limitação Quantidade de metros cúbicos da área não refrigerada 
prob1 += x2 * 1 >= 12

# Resolver
prob1.solve()

print("Status:", pulp.LpStatus[prob1.status])
for v in prob1.variables():
    print(v.name, "=", v.varValue)
print("Z =", pulp.value(prob1.objective))

import pulp


# Variáveis de decisão
# x1 é Título de tesouro
# x2 é Ações Ordinárias
# x3 é Fundo de Mercado
# x4 é CDB de Mercado
x1 = pulp.LpVariable("Título de tesouro", lowBound=0, cat="Integer")
x2 = pulp.LpVariable("Ações Ordinárias", lowBound=0, cat="Integer")
x3 = pulp.LpVariable("Fundo de Mercado", lowBound=0, cat="Integer")
x4 = pulp.LpVariable("CDB de Mercado", lowBound=0, cat="Integer")

# Problema
prob1 = pulp.LpProblem("Modelo1", pulp.LpMaximize)

# Função objetivo
# Modelo para maximizar o retorno com base no retorno esperado de cada investimento que será alocado
prob1 += x1 * 1.08 + x2 * 1.06 + x3 * 1.12 + x4 * 1.09

# Restrições 
# Quantidade de valor investido em título e ações ordinárias
prob1 += x1 + x2 >= 3000000
# Quantidade de valor investido em Fundo de mercado e CDB
prob1 += x3 + x4 <= 4000000
# Valor investido total
prob1 += x1 + x2 + x3 + x4 <= 10000000
# Valor investido máximo em Título de tesouro
prob1 += x1 <= 5000000
# Valor investido máximo em Ações ordinárias 
prob1 += x2 <= 7000000
# Valor investido máximo em Fundo de mercado 
prob1 += x3 <= 2000000
# Valor investido máximo em CDB
prob1 += x4 <= 9000000

# Resolver
prob1.solve()

print("Status:", pulp.LpStatus[prob1.status])
for v in prob1.variables():
    print(v.name, "=", v.varValue)
print("Z =", pulp.value(prob1.objective))

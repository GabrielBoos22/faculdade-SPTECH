import pulp

x1 = pulp.LpVariable("Lotta", lowBound=0, cat="Integer")
x2 = pulp.LpVariable("Claire", lowBound=0, cat="Integer")
x3 = pulp.LpVariable("Finny", lowBound=0, cat="Integer")

prob1 = pulp.LpProblem("Modelo1", pulp.LpMinimize)

# Função objetivo
prob1 += x1 * 11.8 + x2 * 10.4 + x3 * 11

# Restrições 
prob1 += 6 * x1 + 2 * x2 + 14 * x3 <= 40

prob1 += 300 * x1 + 200 * x2 + 350 * x3 >= 2000

prob1 += x1 + x2 + x3 <= 8

prob1 += x1 <= 4

prob1 += x2 <= 4

prob1 += x3 <= 4

# Resolver
prob1.solve()

print("Status:", pulp.LpStatus[prob1.status])
for v in prob1.variables():
    print(v.name, "=", v.varValue)
print("Z =", pulp.value(prob1.objective))

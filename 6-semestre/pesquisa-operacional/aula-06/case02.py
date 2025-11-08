import pulp

W1 = pulp.LpVariable("Web servidor 1", lowBound=0, cat="Integer")
W2 = pulp.LpVariable("Web servidor 2", lowBound=0, cat="Integer")
W3 = pulp.LpVariable("Web servidor 3", lowBound=0, cat="Integer")
D1 = pulp.LpVariable("Database servidor 1", lowBound=0, cat="Integer")
D3 = pulp.LpVariable("Database servidor 3", lowBound=0, cat="Integer")
E1 = pulp.LpVariable("eCommerce servidor 1", lowBound=0, cat="Integer")
E2 = pulp.LpVariable("eCommerce servidor 2", lowBound=0, cat="Integer")

prob1 = pulp.LpProblem("Modelo1", pulp.LpMaximize)

# Função objetivo
prob1 += W1+W2+W3+D1+D3+E1+E2

# Restrições 
prob1 += W1 + 2.5 * D1 + 2 * E1 <= 230

prob1 += W2 + E2 * 5 <= 360

prob1 += W3 + 4 * D3 <= 160

prob1 += W1 + W2 + W3 <= 310

prob1 += D1 + D3 <= 40

prob1 += E1 + E2 <= 120

# Resolver
prob1.solve()

print("Status:", pulp.LpStatus[prob1.status])
for v in prob1.variables():
    print(v.name, "=", v.varValue)
print("Z =", pulp.value(prob1.objective))

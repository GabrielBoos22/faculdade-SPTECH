import pulp

# ------------------- Modelo 1 -------------------
print("\n--- Modelo 1 ---")
x = pulp.LpVariable("x", lowBound=0)
y = pulp.LpVariable("y", lowBound=0)
prob1 = pulp.LpProblem("Modelo1", pulp.LpMaximize)

prob1 += x + y   # Função objetivo
prob1 += -x + y <= 5
prob1 += x + 4*y <= 45
prob1 += 2*x + y <= 27
prob1 += 3*x - 4*y <= 24

prob1.solve()
print("Status:", pulp.LpStatus[prob1.status])
for v in prob1.variables():
    print(v.name, "=", v.varValue)
print("Z =", pulp.value(prob1.objective))


# ------------------- Modelo 2 -------------------
print("\n--- Modelo 2 ---")
x = pulp.LpVariable("x", lowBound=0)
y = pulp.LpVariable("y", lowBound=0)
prob2 = pulp.LpProblem("Modelo2", pulp.LpMaximize)

prob2 += 2*x + 3*y
prob2 += -x + 2*y <= 4
prob2 += x + 2*y <= 6
prob2 += x + 3*y <= 9

prob2.solve()
print("Status:", pulp.LpStatus[prob2.status])
for v in prob2.variables():
    print(v.name, "=", v.varValue)
print("Z =", pulp.value(prob2.objective))


# ------------------- Modelo 3 -------------------
print("\n--- Modelo 3 ---")
x1 = pulp.LpVariable("x1", lowBound=0)
x2 = pulp.LpVariable("x2", lowBound=0)
prob3 = pulp.LpProblem("Modelo3", pulp.LpMaximize)

prob3 += x1 + x2
prob3 += 2*x1 + x2 <= 2
prob3 += x1 + 3*x2 <= 3

prob3.solve()
print("Status:", pulp.LpStatus[prob3.status])
for v in prob3.variables():
    print(v.name, "=", v.varValue)
print("Z =", pulp.value(prob3.objective))


# ------------------- Modelo 4 -------------------
print("\n--- Modelo 4 ---")
x1 = pulp.LpVariable("x1", lowBound=0)
x2 = pulp.LpVariable("x2", lowBound=0)
prob4 = pulp.LpProblem("Modelo4", pulp.LpMaximize)

prob4 += 4*x1 + 3*x2
prob4 += x1 + x2 <= 20
prob4 += x1 + x2 >= 10
prob4 += 5*x1 + 6*x2 >= 54

prob4.solve()
print("Status:", pulp.LpStatus[prob4.status])
for v in prob4.variables():
    print(v.name, "=", v.varValue)
print("Z =", pulp.value(prob4.objective))


# ------------------- Modelo 5 -------------------
print("\n--- Modelo 5 ---")
x1 = pulp.LpVariable("x1", lowBound=0)
x2 = pulp.LpVariable("x2", lowBound=0)
prob5 = pulp.LpProblem("Modelo5", pulp.LpMaximize)

prob5 += 2*x1 + x2
prob5 += -x1 + x2 <= 2
prob5 += x1 <= 5
prob5 += x2 <= 6
prob5 += 3*x1 + 5*x2 >= 15
prob5 += 5*x1 + 4*x2 >= 20

prob5.solve()
print("Status:", pulp.LpStatus[prob5.status])
for v in prob5.variables():
    print(v.name, "=", v.varValue)
print("Z =", pulp.value(prob5.objective))


# ------------------- Exercício Fabrica -------------------
print("\n--- Exercício Fabrica ---")
x1 = pulp.LpVariable("x1", lowBound=0)
x2 = pulp.LpVariable("x2", lowBound=0)
probF = pulp.LpProblem("Fabrica", pulp.LpMinimize)  # minimização de custo

probF += 1000*x1 + 2000*x2
probF += 8*x1 + 2*x2 >= 16
probF += x1 + x2 >= 6
probF += 2*x1 + 7*x2 >= 28

probF.solve()
print("Status:", pulp.LpStatus[probF.status])
for v in probF.variables():
    print(v.name, "=", v.varValue)
print("Custo mínimo =", pulp.value(probF.objective))


# ------------------- Exercício Investimento -------------------
print("\n--- Exercício Investimento ---")
cdb_rate = (1.01)**6      # 1% a.m. por 6 meses
tesouro_rate = 1 + 0.1376/2  # 6 meses

x1 = pulp.LpVariable("CDB", lowBound=0)
x2 = pulp.LpVariable("Tesouro", lowBound=0)
probInv = pulp.LpProblem("Investimento", pulp.LpMaximize)

probInv += cdb_rate*x1 + tesouro_rate*x2
probInv += x1 + x2 <= 80000
probInv += x2 <= 32000
probInv += cdb_rate*x1 + tesouro_rate*x2 >= 40000

probInv.solve()
print("Status:", pulp.LpStatus[probInv.status])
for v in probInv.variables():
    print(v.name, "=", v.varValue)
print("Valor Futuro =", pulp.value(probInv.objective))

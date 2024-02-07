import sympy
import statistics as st
import math

import sympy as sp
m, b = sp.symbols('m b')
eq1 = sp.Eq(m*11 + b,120)
eq2 = sp.Eq(m*19 + b,150)
eq3 = sp.Eq(m*35 + b,180)
eq4 = sp.Eq(m*43 + b,210)
eq5 = sp.Eq(m*72 + b,240)
ans = sp.solve((eq1,eq2,eq3,eq4,eq5),(m,b))
print(ans)

ans1 = sp.solve((eq1,eq5),(m,b))
ans2 = sp.solve((eq2,eq4),(m,b))
ans3 = sp.solve((eq1,eq3),(m,b))
print(ans1)
print(ans2)
print(ans3)

usuarios = [10, 12, 13, 15, 25, 22, 18, 15, 20, 28, 30]
print("a media de usuarios ativos é {}".format(st.mean(usuarios)))
print("a mediana de usuários ativos é {}".format(st.median(usuarios)))
print("O desvio padrão de usuarios ativos é {:.02f}".format(st.stdev(usuarios)))


cpu = [20.0, 25.2, 30.0, 45.1, 42.7, 33.6, 31.5, 45.0, 53.1, 60.2]
print("\na media de cpu usada ativos é {}".format(st.mean(cpu)))
print("a mediana de cpu usada ativos é {}".format(st.median(cpu)))
print("O desvio padrão de cpu usada ativos é {:.02f}".format(st.stdev(cpu)))

m, b = sp.symbols('m b')
eq1 = sp.Eq(m*10 + b,20.0)
eq2 = sp.Eq(m*12 + b,25.2)
eq3 = sp.Eq(m*25 + b,45.1)
eq4 = sp.Eq(m*22 + b,42.7)
eq5 = sp.Eq(m*18 + b,33.6)
eq6 = sp.Eq(m*15 + b,31.5)
eq7 = sp.Eq(m*20 + b,45.0)
eq8 = sp.Eq(m*28 + b,53.1)
eq9 = sp.Eq(m*30 + b,60.2)
ans = sp.solve((eq1,eq2,eq3,eq4,eq5,eq6,eq7,eq8,eq9),(m,b))
print("\nNão tem relação linear pois resolvendo o sistema das equações descritas, o resultado é", ans)

ans1 = sp.solve((eq1,eq5),(m,b))
ans2 = sp.solve((eq2,eq4),(m,b))
ans3 = sp.solve((eq1,eq3),(m,b))
ans4 = sp.solve((eq5,eq9),(m,b))
ans5 = sp.solve((eq6,eq8),(m,b))
ans6 = sp.solve((eq7,eq1),(m,b))
print("\nLinhas de melhores ajustes: ",ans1,ans2,ans3,ans4,ans5,ans6)

x, y = sp.symbols('x y')
eq1 = sp.Eq(3*x + 1.7,y)
solve = sp.solve(eq1.subs(x, 20), y)
print("\nA previsão de quando usuarios é 20 é: {:.02f}".format(solve[0]), '% da CPU')

print("A relação não linear entre o uso da CPU e os usuários ativos pode ocorrer devido ao fato de ao decorrer do tempo, o numero de usuários ativos pode não ser um numero escrito na forma ax+b para chegar no valor de y, isso significa que eles não tem uma relação de linearidade.")

a, b = sp.symbols('a b')
ep1 = sp.Eq(a * (math.e**(b * 5)),10)
ep2 = sp.Eq(a * (math.e**(b * 10)),15)
ep3 = sp.Eq(a * (math.e**(b * 20)),30)
ep4 = sp.Eq(a * (math.e**(b * 30)),50)
ep5 = sp.Eq(a * (math.e**(b * 40)),70)

resposta = sp.solve((ep1,ep2),(a,b))
print(resposta)

import numpy as np
import matplotlib.pyplot as plt
from scipy.optimize import curve_fit

users = np.array([5, 10, 20, 30, 40])
cpu_usage = np.array([10, 15, 30, 50, 70])

def exponential_function(U, a, b):
 return a * np.exp(b * U)
params, covariance = curve_fit(exponential_function, users, cpu_usage, maxfev = 5000)
a_fit, b_fit = params
predicted_cpu_usage = exponential_function(users, a_fit, b_fit)
print("Fitted Parameters:")

print("a:", a_fit)
print("b:", b_fit)

plt.scatter(users, cpu_usage, label='Data')

plt.plot(users, predicted_cpu_usage, label='Fitted Curve', color='red')

plt.xlabel('Number of Active Users')
plt.ylabel('CPU Usage (%)')

plt.legend()

plt.title('CPU Usage vs. Number of Active Users (Fitted Curve)')

plt.grid()
plt.show()

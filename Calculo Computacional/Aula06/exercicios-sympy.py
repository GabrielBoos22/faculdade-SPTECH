import sympy
import statistics as st

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
print(ans)

ans1 = sp.solve((eq1,eq5),(m,b))
ans2 = sp.solve((eq2,eq4),(m,b))
ans3 = sp.solve((eq1,eq3),(m,b))
ans4 = sp.solve((eq5,eq9),(m,b))
ans5 = sp.solve((eq6,eq8),(m,b))
ans6 = sp.solve((eq7,eq1),(m,b))
print(ans1,ans2,ans3,ans4,ans5,ans6)



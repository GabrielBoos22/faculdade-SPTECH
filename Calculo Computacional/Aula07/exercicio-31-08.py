import sympy
import statistics as st
import math
from scipy import stats
import numpy as np
import matplotlib.pyplot as plt
import sympy as sp
m, b = sp.symbols('m b')
yieldY = np.array([2.9, 4.2, 3.2, 3.8, 4.0, 4.5, 3.4, 3.7, 2.1, 4.7, 4.3, 2.7, 2.5, 4.1, 2.3, 3.5, 3.2, 3.6])
print("a media da base é {}".format(st.mean(yieldY)))
print("a mediana da base é {}".format(st.median(yieldY)))
print("a media da base é {}".format(st.stdev(yieldY)))

tempoX = np.array([18.0, 5.0, 11.0, 9.0, 14.0, 6.0, 13.0, 8.0, 22.0, 15.0, 7.0, 20.0, 19.0, 16.0, 21.0, 10.0, 17.0, 12.0])

a_coef_angular, b_coef_linear = st.linear_regression(tempoX, yieldY)
print('Equação da reta: y = {:.04f}x + {:.04f}'.format(a_coef_angular, b_coef_linear))

def formula(a,b,x):
 return a*x + b

def graph(a,b):
 x = tempoX
 y = formula(a,b,x)
 plt.scatter(tempoX,yieldY)
 plt.plot(x,y)
 plt.xticks(np.arange(5, 40, step = 5))
 plt.xlabel('Tempo(anos)')
 plt.ylabel('Yield [%]')
 plt.title('inflação (IPCA+2045)')
 plt.grid()
 plt.show()

graph(a_coef_angular, b_coef_linear)

print("Com base no gráficos, pode-se analisar que a sensibilidade dos rendimentos aos períodos de vencimento para diferentes tipos de titúlos é dispersa e não linear, onde por meio da regressão linear, tem-se uma reta decrescente confome o tempo de validade é maior")
print("Para um investidor, com base nos gráficos de rendimento com o tempo, o gráfico é decrescente conforme o tempo para vencimento é maior, e quando falta 5 anos para o vencimento, o rendimento alcança seu pico. ")

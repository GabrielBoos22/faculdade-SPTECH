import sympy
import statistics as st
import math
from scipy import stats
import numpy as np
import matplotlib.pyplot as plt
import sympy as sp

print("Exercicio 1")
m, b = sp.symbols('m b')
yieldY = np.array([2.9, 4.2, 3.2, 3.8, 4.0, 4.5, 3.4, 3.7, 2.1, 4.7, 4.3, 2.7, 2.5, 4.1, 2.3, 3.5, 3.2, 3.6])
print("a media do yield é {}".format(st.mean(yieldY)))
print("a mediana do yield é {}".format(st.median(yieldY)))
print("o desvio padrão do yield é {}".format(st.stdev(yieldY)))

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
print("-----------------------------------------------------------------")
print("\nExercicio 2")
a, b = sp.symbols('a b')
velocidadeX = [1/2, 1/4, 1/8, 1/15, 1/30, 1/60, 1/125, 1/250, 1/500, 1/1000]
brilhoY = [200, 190, 175, 171, 168, 150, 148, 140, 131, 127]
print("a moda do brilho é {}".format(st.mode(brilhoY)))
print("a mediana do brilho é {}".format(st.median(brilhoY)))
print("os decils do brilho é {}".format(st.quantiles(brilhoY, n=10, method='inclusive')))
print("a variancia do brilho é {:.2f}".format(st.variance(brilhoY)))
print("o desvio padrão do brilho é {:.2f}".format(st.stdev(brilhoY)))


velocidadeX = np.array([1/2, 1/4, 1/8, 1/15, 1/30, 1/60, 1/125, 1/250, 1/500, 1/1000])
brilhoY = np.array([200, 190, 175, 171, 168, 150, 148, 140, 131, 127])

def graph2(a,b):
 x = velocidadeX
 y = formula(a,b,x)
 plt.scatter(velocidadeX,brilhoY)
 plt.plot(x,y)
 plt.xlabel('Velocidade do obturador (s)')
 plt.ylabel('Brilho')
 plt.title('Brilho das Fotografias')
 plt.grid()
 plt.show()

a_coef_angular, b_coef_linear = st.linear_regression(velocidadeX, brilhoY)
print('Equação da reta: y = {:.04f}x + {:.04f}'.format(a_coef_angular, b_coef_linear))

graph2(a_coef_angular, b_coef_linear)

print("\npode-se analisar que as configurações de abertura e velocidade do obturador afetam o brilho da imagem de maneira dispersa, onde não se tem uma linearidade dos dados, mas a partir da regressão linear, o coeficiente angular é positivo, portanto quanto maior a velocidade maior o brilho")
print("\nRecomenda-se que para uma maior quantidade de brilho na foto, tenha-se uma configuração da foto de maior velocidade. E para fotos com menor brilho, uma menor velocidade.")

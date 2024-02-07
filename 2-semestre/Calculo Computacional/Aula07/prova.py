a = (-4)**(-5)
b = pow(-4, -5)
print(a,b)

a = (-10)**(0)
b = pow(-10, 0)
print(a,b)

import statistics as st

tempo = [8.0, 8.01, 8.03, 8.04, 8.05, 8.06, 8.07, 8.08, 8.09, 8.1, 8.11, 8.12, 8.13, 8.14, 8.15, 8.16, 8.17, 8.18, 8.19, 8.20, 8.21, 8.22, 8.23, 8.24, 8.25]
memoria = [5.3669, 5.3850, 5.4076, 5.3835, 5.4025, 5.4561, 5.4197, 5.4306, 5.4700, 5.5270, 5.5752, 5.5445, 5.6290, 5.6267, 5.6937, 5.6422, 5.7013, 5.6983, 5.6562, 5.5151, 5.4860, 5.4454, 5.4566, 5.5377, 5.5709, 5.5448]

print("a media é {}".format(st.mean(memoria)))
print("a mediana é {}".format(st.median(memoria)))
print("o desvio padrão é {}".format(st.stdev(memoria)))
print("o desvio padrão da população é {}".format(st.pstdev(memoria)))
print("o 1 quartil é {}".format(st.quantiles(memoria, method='inclusive')))
print("o 3 quartil é {}".format(st.quantiles(memoria, n=4, method='inclusive')))
print("A variancia da amostra é {}".format(st.variance(memoria)))
print("A variancia da população é {}".format(st.pvariance(memoria)))

s1=  [1, 2, 3]
s2=[4, 5, 6]

print(s1+s2)

a = 4/6
b = 3/2
c = (a * b) + 1
d = pow(3,2/3)
e = pow(d,c)
f = 1.4 + e
print(round(f,3))

a = 4/6
a1 = 3/2
a = (a*a1) + 1
b = pow(a,3)
a1 = pow(3,b)
print (a)

a = 4
b = 2
c = a + b
print(type(c))

print(2*2**3)

a = 4
b = 2
c = a/b
print(type(c))
import math
print(math.ceil(5468/((18 + 8.5 * 3) * 4)))

try: 

   list = 5*[0]+5*[10] 
   x = list[9] 
   print('Done!') 
except IndexError: 
   print('Index out of Bond!') 
else: 
   print('Nothing is wrong!') 
finally: 
   print('Finally block!')

print("{:.4f}".format(((45/8)**(2+1.5))/(1-(5/7 + 6)/4) + 600))

from math import floor, ceil
altura_Bruno = 1.75
peso_Bruno = 85
IMC_Bruno = (peso_Bruno/pow(altura_Bruno, 2))
teto_IMC = floor(IMC_Bruno)
print(teto_IMC)

s1 = {1,2,3}
print(2*s1)

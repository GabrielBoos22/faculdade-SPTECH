import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import statistics as st
import sympy as sp

def formula(a, b, x):
    return a * x + b

def graph(a, b, tempoX, cpuY, title):
    x = tempoX
    y = formula(a, b, x)
    plt.scatter(tempoX, cpuY)
    plt.plot(x, y)
    plt.xticks(np.arange(2, 398, step=2))
    plt.xlabel('Tempo (segundos)')
    plt.ylabel('Total CPU (%)')
    plt.title(title)
    plt.grid()

caminho_arquivo_csv = 'C:/Users/Vayon24/Desktop/sptech/Downloads/OpenHardwareMonitor/trusted-open-hardware.csv'
# Ler o arquivo CSV no Python
df = pd.read_csv(caminho_arquivo_csv, delimiter=';')

cpu = df["cpu_total"].tolist()

m, b = sp.symbols('m b')
cpuY = np.array(cpu)

array_tempo = []

for i in range(2, 397, 2):
    array_tempo.append(i)

tempoX = np.array(array_tempo)
a_coef_angular, b_coef_linear = st.linear_regression(tempoX, cpuY)

plt.figure(figsize=(12, 6))

plt.subplot(1, 2, 1)
graph(a_coef_angular, b_coef_linear, tempoX, cpuY, 'Gráfico 1')

caminho_arquivo_csv = 'C:/Users/Vayon24/Desktop/sptech/2-sem-SPTech/Calculo Computacional/Aula08/trusted_coleta1_RA03231030.csv'
# Ler o arquivo CSV no Python
df = pd.read_csv(caminho_arquivo_csv, delimiter=';')

cpu = df["dado"].tolist()

m, b = sp.symbols('m b')
cpuY = np.array(cpu)

array_tempo = []

for i in range(2, 401, 2):
    array_tempo.append(i)

tempoX = np.array(array_tempo)
a_coef_angular, b_coef_linear = st.linear_regression(tempoX, cpuY)

plt.subplot(1, 2, 2)
graph(a_coef_angular, b_coef_linear, tempoX, cpuY, 'Gráfico 2')

plt.tight_layout()
plt.show()

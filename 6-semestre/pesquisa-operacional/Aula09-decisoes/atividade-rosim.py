import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

CSV_PATH = "C:/Users/Gabriel/Downloads/exemplos/desempenho_alunos.csv"

df = pd.read_csv(CSV_PATH, sep=";", encoding="latin1")
df.columns = df.columns.str.strip()

num_cols = ['horas_estudo', 'frequencia', 'sono', 'nota_prova']
for col in num_cols:
    df[col] = df[col].astype(str).str.replace(',', '.').astype(float)

mean = df[num_cols].mean()

plt.figure()
plt.bar(mean.index, mean.values)
plt.title("Média")
plt.xlabel("Variáveis")
plt.ylabel("Média")
plt.tight_layout()
plt.savefig("grafico_media.png", dpi=300)
plt.show()

CSV_PATH = "C:/Users/Gabriel/Downloads/exemplos/desempenho_alunos.csv"
df = pd.read_csv(CSV_PATH, sep=";", encoding="latin1")
df.columns = df.columns.str.strip()
num_cols = ["horas_estudo", "frequencia", "sono", "nota_prova"]
for c in num_cols:
    df[c] = df[c].astype(str).str.replace(",", ".").astype(float)
median_vals = df[num_cols].median()
plt.figure()
plt.bar(median_vals.index, median_vals.values)
plt.title("Mediana")
plt.xlabel("Variáveis")
plt.ylabel("Mediana")
plt.tight_layout()
plt.savefig("grafico_mediana.png", dpi=300)
plt.show()


CSV_PATH = "C:/Users/Gabriel/Downloads/exemplos/desempenho_alunos.csv"
df = pd.read_csv(CSV_PATH, sep=";", encoding="latin1")
df.columns = df.columns.str.strip()
num_cols = ["horas_estudo", "frequencia", "sono", "nota_prova"]
for c in num_cols:
    df[c] = df[c].astype(str).str.replace(",", ".").astype(float)
corr = df[num_cols].corr()
plt.figure()
plt.imshow(corr, interpolation="none")
plt.colorbar(label="Correlação")
plt.xticks(range(len(corr.columns)), corr.columns, rotation=45, ha="right")
plt.yticks(range(len(corr.columns)), corr.columns)
plt.title("Matriz de Correlação")
plt.tight_layout()
plt.savefig("grafico_correlacao.png", dpi=300)
plt.show()

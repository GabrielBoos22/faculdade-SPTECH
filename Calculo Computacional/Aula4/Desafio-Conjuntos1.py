ágora = ["Itaúsa", "Ecorodovias", 'Taesa', 'B3', 'Vale']
ativa = ["B3", "Bradesco", "BB Seguridade", 'BR Distribuidora', 'Taesa', 'CTEEP', 'Vale', 'Telefônica Brasil']
Genial = ['CPFL', 'Minerva', 'Cyrela', 'Randon', 'CTEEP']
Easynvest = ['B3', 'Brasil Agro', 'Coca-cola', 'Taesa', 'Vale', 'Copel', 'Itaúsa', 'Ambev']
Elite = ['Bradesco', 'BB Seguridade','Banrisul', 'Engie', 'Itaúsa', 'Sanepar', 'Taesa', 'CTEEP', 'Telefônica Brasil', 'Vale']
Guide = ['Alupar','Banco do Brasil','Cyrela','CPFL','Klabin','Porto seguro','Tim','Vale']
NovaFutura = ['B3','Cyrela','Gerdau','Vivo','CTEEP']
Órama = ['Banco ABC','Bradesco','Minerva','CESP','Engie']

ágora = set(ágora)
ativa = set(ativa)
Genial = set(Genial)
Easynvest = set(Easynvest)
Elite = set(Elite)
Guide = set(Guide)
NovaFutura = set(NovaFutura)
Órama = set(Órama)

print("\nAção em comum a todas a corretoras:", ágora.intersection(ativa, Genial, Easynvest, Elite, Guide, NovaFutura, Órama))

print("\nAções únicas 4 corretoras: ", ágora.intersection(ativa, Easynvest, NovaFutura))

print("\nItens únicos ",ágora ^ ativa ^ Easynvest ^ NovaFutura)

print(ágora.issubset(ativa))
print(ágora.issuperset(ativa))
print(ativa.issubset(Easynvest))
print(ativa.issuperset(Easynvest))
print(Easynvest.issubset(NovaFutura))
print(Easynvest.issuperset(NovaFutura))
print("\nNão tem subset nem superset nos portfólios")

conjuntoIncomum = ágora ^ ativa ^ Easynvest ^ NovaFutura
print("\nConjunto com todos os elementos incomuns:", conjuntoIncomum)



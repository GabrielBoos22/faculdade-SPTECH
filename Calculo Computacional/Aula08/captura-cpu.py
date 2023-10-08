from mysql.connector import connect
import psutil
import platform
import time
import mysql.connector
from datetime import datetime

def mysql_connection(host, user, passwd, database=None):
    connection = connect(
        host=host,
        user=user,
        passwd=passwd,
        database=database
    )
    return connection

connection = mysql_connection('localhost', 'root', '5505', 'MedConnect')
contador = 0
while True:
    if(contador == 200):
        break
    dado = psutil.cpu_percent(None)
    cursor = connection.cursor()
    horarioAtual = datetime.now()
    horarioFormatado = horarioAtual.strftime('%Y-%m-%d %H:%M:%S')
    
    cursor = connection.cursor()
    query = "INSERT INTO Registros (dado, fkRoboRegistro, fkComponente, HorarioDado) VALUES (%s, 1, %s, %s)"
    cursor.execute(query, (dado, 1,horarioFormatado))
    connection.commit()
    print("\nINFORMAÇÕES SOBRE PROCESSAMENTO: ")
    print('Porcentagem utilizada do Processador: ',dado)
   
    contador += 1
    time.sleep(2)

cursor.close()
connection.close()
print(contador)
    

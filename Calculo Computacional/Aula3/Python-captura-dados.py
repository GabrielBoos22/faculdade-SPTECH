import math
import psutil
import time


def converter_segundos_para_horas_minutos_segundos(segundos):
    horas = segundos // 3600  # 1 hora = 3600 segundos
    segundos_restantes = segundos % 3600
    minutos = segundos_restantes // 60
    segundos_final = math.ceil(segundos_restantes % 60)

    return horas, minutos, segundos_final

def bytes_para_gb(bytes_value):
    return bytes_value / (1024 ** 3)

print("\n-----------------------------------------")
componente = input("Qual componente você deseja monitorar? (CPU, Disco, Memória, Rede, Sensor)")

if(componente == "CPU"):
    print("\n-----------------------------------------")
    print("\nComponente selecionado = CPU\n")
    print("-----------------------------------------")

    while(True):
        
        print("\nSituação geral: ")
        print("-----------------------------------------")
        
        ps = psutil.cpu_times()
        TempoUsuarioHoras, TempoUsuarioMinutos, TempoUsuarioSegundos = converter_segundos_para_horas_minutos_segundos(ps[0])
        TempoSistemaHoras, TempoSistemaMinutos, TempoSistemaSegundos = converter_segundos_para_horas_minutos_segundos(ps[1])
        PorcentagemCpu = psutil.cpu_percent(percpu = True)
        numeroCpu = psutil.cpu_count()
        frequenciaCpu = psutil.cpu_freq(percpu=False)
        frequenciaCpuEmGhz = frequenciaCpu.current / 1e9

        print("Tempo:")
        print("Tempo de usuário:", TempoUsuarioHoras, "h", TempoUsuarioMinutos, 'm e',TempoUsuarioSegundos, 's')  
        print("Tempo de sistema:", TempoSistemaHoras, "h", TempoSistemaMinutos, 'm e',TempoSistemaSegundos, 's')      
        print()

        print("Utilização:")
        print("\nPorcentagem sendo utilizada da CPU: ", PorcentagemCpu)
        print()

        print("Outros:")
        print("\nNúmero de CPUs lógicas no sistema:", numeroCpu)
        print("\nFrequencia das CPUs no sistema:", frequenciaCpuEmGhz)
        print()
        time.sleep(20)
    
elif(componente == "Disco"):
    print("\n-----------------------------------------")
    print("\nComponente selecionado = Disco\n")
    print("-----------------------------------------")

    while(True):
        print("\nSituação geral: ")
        print("-----------------------------------------")
        particoes = psutil.disk_partitions()

        print("Partições de Disco:")
        for particao in particoes:
            print("Ponto de Montagem:", particao.mountpoint)
            print("Sistema de Arquivos:", particao.fstype)
            print("Dispositivo:", particao.device)
            print()
    
        uso_disco = psutil.disk_usage('/')
        print("Uso de Disco:")
        print(f"Total:", uso_disco.total, "bytes")
        print(f"Usado:", uso_disco.used, "bytes")
        print(f"Livre:", uso_disco.free, "bytes")
        print(f"Percentual de Uso:", uso_disco.percent,"%")
        print()

        io_disco = psutil.disk_io_counters(perdisk=True)
        print("E/S de Disco:")
        for disco, io in io_disco.items():
            print(f"Disco:", disco)
            print(f"Leituras:", io.read_count)
            print(f"Escritas:", io.write_count)
            print()
        time.sleep(20)

elif(componente == "Memória"):
    print("\n-----------------------------------------")
    print("\nComponente selecionado = Memória\n")
    print("-----------------------------------------")

    while(True):
        memoria_virtual = psutil.virtual_memory()
        print("Memória Virtual:")
        print("Total: {:.2f} GB".format(bytes_para_gb(memoria_virtual.total)))
        print("Disponível: {:.2f} GB".format(bytes_para_gb(memoria_virtual.available)))
        print("Usado: {:.2f} GB".format(bytes_para_gb(memoria_virtual.used)))
        print("Percentual de Uso:", memoria_virtual.percent,"%")
        print()

        swap = psutil.swap_memory()
        print("Swap:")
        print("Total: {:.2f} GB".format(bytes_para_gb(swap.total)))
        print("Usado: {:.2f} GB".format(bytes_para_gb(swap.used)))
        print("Livre: {:.2f} GB".format(bytes_para_gb(swap.free)))
        print("Percentual de Uso:", swap.percent,"%")
        print()
        time.sleep(20)
   
elif(componente == "Rede"):
    print("\n-----------------------------------------")
    print("\nComponente selecionado = Rede\n")
    print("-----------------------------------------")
    while(True):
        print("\nSituação geral: ")
        print("-----------------------------------------")
        io_rede = psutil.net_io_counters()
        print("Tráfego de Rede Total:")
        print("Bytes Recebidos:", io_rede.bytes_recv)
        print("Bytes Enviados:", io_rede.bytes_sent)
        print()

        time.sleep(20)

elif(componente == "Sensor"):
    print("\n-----------------------------------------")
    print("\nComponente selecionado = Sensor\n")
    print("-----------------------------------------")
    while(True):
        print("\nSituação geral: ")
        print("-----------------------------------------")
        
        
        dadosBateria = psutil.sensors_battery()
        TempoRestanteHoras, TempoRestanteMinutos, TempoRestanteSegundos = converter_segundos_para_horas_minutos_segundos(dadosBateria.secsleft)
        bateriaEstado = 'Desligado'
        if dadosBateria.power_plugged == True:
            bateriaEstado = 'Ligado'
        print("Bateria:")
        print("Porcentagem:", dadosBateria.percent, "%")
        print("Tempo restante:", TempoRestanteHoras, "h", TempoRestanteMinutos, 'm e',TempoRestanteSegundos, 's')  
        print("Carregamento:", bateriaEstado)
        print()
        
        time.sleep(20)



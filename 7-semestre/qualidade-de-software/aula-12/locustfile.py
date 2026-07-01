from locust import HttpUser, task, between
import random

CURSOS = ["ADS", "SI", "BD"]

class FormUser(HttpUser):
    """
    Simula um usuário acessando e preenchendo o formulário de inscrição.
    Cada usuário virtual:
      1. Faz GET em "/" para carregar o formulário
      2. Faz POST em "/submit" com dados aleatórios
    O tempo de espera entre tarefas varia entre 1 e 2 segundos,
    simulando o comportamento humano de leitura do formulário.
    """
    wait_time = between(1, 2)

    @task
    def preencher_formulario(self):
        # Passo 1: acessar a página do formulário
        self.client.get("/", name="GET /")

        # Passo 2: gerar dados aleatórios e enviar
        uid = random.randint(1000, 9999)
        nome = f"Teste{uid}"
        email = f"usuario{uid}@example.com"
        curso = random.choice(CURSOS)

        payload = {
            "nome": nome,
            "email": email,
            "curso": curso,
        }

        self.client.post("/submit", data=payload, name="POST /submit")

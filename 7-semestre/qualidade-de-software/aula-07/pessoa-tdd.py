class Pessoa:
    def __init__(self, nome, cpf):
        self.nome = nome
        self.cpf = cpf
        
from pessoa import Pessoa


def test_deve_criar_pessoa_corretamente():
    pessoa = Pessoa("Maria", "12345678900")

    assert pessoa.nome == "Maria"
    assert pessoa.cpf == "12345678900"

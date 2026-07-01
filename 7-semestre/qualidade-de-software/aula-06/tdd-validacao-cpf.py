import unittest
import re


# ─────────────────────────────────────────────
# IMPLEMENTAÇÃO
# ─────────────────────────────────────────────

def valida_cpf(cpf: str) -> bool:
    """
    Valida um CPF brasileiro.

    Aceita CPFs com ou sem formatação (ex.: '123.456.789-09' ou '12345678909').
    Retorna True se o CPF for válido, False caso contrário.
    """
    # 1. Remove caracteres de formatação
    cpf_limpo = re.sub(r"[.\-]", "", cpf)

    # 2. Deve conter exatamente 11 dígitos numéricos
    if not re.fullmatch(r"\d{11}", cpf_limpo):
        return False

    # 3. Rejeita sequências triviais (ex.: '00000000000', '11111111111', ...)
    if cpf_limpo == cpf_limpo[0] * 11:
        return False

    # 4. Valida o 1º dígito verificador
    soma = sum(int(cpf_limpo[i]) * (10 - i) for i in range(9))
    primeiro_digito = (soma * 10 % 11) % 10
    if primeiro_digito != int(cpf_limpo[9]):
        return False

    # 5. Valida o 2º dígito verificador
    soma = sum(int(cpf_limpo[i]) * (11 - i) for i in range(10))
    segundo_digito = (soma * 10 % 11) % 10
    if segundo_digito != int(cpf_limpo[10]):
        return False

    return True


# ─────────────────────────────────────────────
# TESTES (TDD)
# ─────────────────────────────────────────────

class TestValidaCPF(unittest.TestCase):

    # ── CICLO 1 ─────────────────────────────
    # RED  → escrevemos o teste antes de qualquer implementação
    # GREEN → implementamos apenas "return False" para passar
    # (aqui já temos a implementação final, mas a ordem conceitual é mantida)

    def test_cpf_invalido_retorna_false(self):
        """Teste inicial: CPF claramente errado deve retornar False."""
        self.assertFalse(valida_cpf("00000000000"))

    # ── CICLO 2 ─────────────────────────────
    # RED  → testamos um CPF real válido (falha com "return False")
    # GREEN → implementamos o algoritmo de dígitos verificadores

    def test_cpf_valido_retorna_true(self):
        """CPF válido bem conhecido deve retornar True."""
        self.assertTrue(valida_cpf("11144477735"))

    # ── CICLO 3 ─────────────────────────────
    # RED  → formatação pontos/hífen ainda não era suportada
    # GREEN → adicionamos remoção de formatação

    def test_cpf_formatado_valido(self):
        """CPF com pontos e hífen deve ser aceito."""
        self.assertTrue(valida_cpf("111.444.777-35"))

    # ── CICLO 4 ─────────────────────────────
    # RED  → sequências uniformes passariam no algoritmo matemático
    # GREEN → adicionamos rejeição de sequências triviais

    def test_sequencias_uniformes_sao_invalidas(self):
        """Sequências como 111...111 até 999...999 devem ser inválidas."""
        for digito in "0123456789":
            with self.subTest(digito=digito):
                self.assertFalse(valida_cpf(digito * 11))

    # ── CICLO 5 ─────────────────────────────
    # Cenários de formato inválido

    def test_cpf_com_letras_invalido(self):
        """CPF contendo letras deve retornar False."""
        self.assertFalse(valida_cpf("1114447773A"))

    def test_cpf_curto_invalido(self):
        """CPF com menos de 11 dígitos deve retornar False."""
        self.assertFalse(valida_cpf("1234567"))

    def test_cpf_longo_invalido(self):
        """CPF com mais de 11 dígitos deve retornar False."""
        self.assertFalse(valida_cpf("123456789012"))

    def test_string_vazia_invalida(self):
        """String vazia deve retornar False."""
        self.assertFalse(valida_cpf(""))

    # ── CICLO 6 ─────────────────────────────
    # Dígito verificador errado

    def test_primeiro_digito_verificador_errado(self):
        """CPF com 1º dígito verificador errado deve retornar False."""
        self.assertFalse(valida_cpf("11144477705"))  # correto seria ...35

    def test_segundo_digito_verificador_errado(self):
        """CPF com 2º dígito verificador errado deve retornar False."""
        self.assertFalse(valida_cpf("11144477730"))  # correto seria ...35

    # ── CICLO 7 ─────────────────────────────
    # Outros CPFs válidos reais (boundary / regressão)

    def test_outros_cpfs_validos(self):
        """Conjunto de CPFs válidos conhecidos."""
        cpfs_validos = [
            "52998224725",
            "111.444.777-35",
            "529.982.247-25",
        ]
        for cpf in cpfs_validos:
            with self.subTest(cpf=cpf):
                self.assertTrue(valida_cpf(cpf))

    def test_outros_cpfs_invalidos(self):
        """Conjunto de CPFs inválidos conhecidos."""
        cpfs_invalidos = [
            "12345678900",
            "111.444.777-00",
            "000.000.000-00",
        ]
        for cpf in cpfs_invalidos:
            with self.subTest(cpf=cpf):
                self.assertFalse(valida_cpf(cpf))


# ─────────────────────────────────────────────
# RUNNER
# ─────────────────────────────────────────────

if __name__ == "__main__":
    unittest.main(verbosity=2)

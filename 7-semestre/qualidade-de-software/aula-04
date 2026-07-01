import unittest
import re


# ─────────────────────────────────────────────
# IMPLEMENTAÇÃO
# ─────────────────────────────────────────────

def valida_senha(senha: str) -> bool:
    """
    Valida uma senha de acordo com as regras de segurança.

    Retorna True se a senha for válida, False caso contrário.
    """
    # Regra 1: pelo menos 8 caracteres
    if len(senha) < 8:
        return False

    # Regra 2: ao menos 1 letra maiúscula
    if not re.search(r"[A-Z]", senha):
        return False

    # Regra 3: ao menos 1 letra minúscula
    if not re.search(r"[a-z]", senha):
        return False

    # Regra 4: ao menos 1 número
    if not re.search(r"\d", senha):
        return False

    # Regra 5: ao menos 1 caractere especial
    if not re.search(r"[!@#$%^&*()_+\-=\[\]{};':\"\\|,.<>\/?`~]", senha):
        return False

    # Regra 6: sem espaços em branco
    if re.search(r"\s", senha):
        return False

    return True


# ─────────────────────────────────────────────
# TESTES (TDD)
# ─────────────────────────────────────────────

class TestValidaSenha(unittest.TestCase):

    # ── CICLO 1 ─────────────────────────────
    # RED  → senha válida completa falha com qualquer stub
    # GREEN → implementamos todas as regras de uma vez (design já conhecido)

    def test_senha_valida_completa(self):
        """Senha que atende todos os critérios deve retornar True."""
        self.assertTrue(valida_senha("Senh@123"))

    # ── CICLO 2 ─────────────────────────────
    # RED  → testamos comprimento mínimo
    # GREEN → adicionamos verificação de len < 8

    def test_senha_curta_invalida(self):
        """Senha com menos de 8 caracteres deve retornar False."""
        self.assertFalse(valida_senha("Ab1@xyz"))   # 7 chars

    def test_senha_exatamente_8_caracteres_valida(self):
        """Senha com exatamente 8 caracteres válidos deve retornar True."""
        self.assertTrue(valida_senha("Abc123@!"))

    # ── CICLO 3 ─────────────────────────────
    # RED  → testamos ausência de maiúscula
    # GREEN → adicionamos re.search(r"[A-Z]", senha)

    def test_sem_maiuscula_invalida(self):
        """Senha sem letra maiúscula deve retornar False."""
        self.assertFalse(valida_senha("senh@123"))

    # ── CICLO 4 ─────────────────────────────
    # RED  → testamos ausência de minúscula
    # GREEN → adicionamos re.search(r"[a-z]", senha)

    def test_sem_minuscula_invalida(self):
        """Senha sem letra minúscula deve retornar False."""
        self.assertFalse(valida_senha("SENH@123"))

    # ── CICLO 5 ─────────────────────────────
    # RED  → testamos ausência de número
    # GREEN → adicionamos re.search(r"\d", senha)

    def test_sem_numero_invalida(self):
        """Senha sem número deve retornar False."""
        self.assertFalse(valida_senha("Senha@abc"))

    # ── CICLO 6 ─────────────────────────────
    # RED  → testamos ausência de caractere especial
    # GREEN → adicionamos re.search com conjunto de especiais

    def test_sem_caractere_especial_invalida(self):
        """Senha sem caractere especial deve retornar False."""
        self.assertFalse(valida_senha("Senha123"))

    # ── CICLO 7 ─────────────────────────────
    # RED  → testamos presença de espaço
    # GREEN → adicionamos re.search(r"\s", senha)

    def test_com_espaco_invalida(self):
        """Senha com espaço em branco deve retornar False."""
        self.assertFalse(valida_senha("Senh@ 123"))

    def test_com_tab_invalida(self):
        """Senha com tabulação (\\t) deve retornar False."""
        self.assertFalse(valida_senha("Senh@\t123"))

    # ── CICLO 8 — Regressão / edge cases ────
    # Confirmamos que variados caracteres especiais são aceitos

    def test_varios_caracteres_especiais_aceitos(self):
        """Diferentes caracteres especiais devem ser aceitos."""
        senhas = [
            "Abc123!!", "Abc123@@", "Abc123##",
            "Abc123$$", "Abc123%%", "Abc123^^",
            "Abc123&&", "Abc123**", "Abc123(()",
        ]
        for senha in senhas:
            with self.subTest(senha=senha):
                self.assertTrue(valida_senha(senha))

    def test_string_vazia_invalida(self):
        """String vazia deve retornar False."""
        self.assertFalse(valida_senha(""))

    def test_senha_longa_valida(self):
        """Senha longa que cumpre todas as regras deve ser válida."""
        self.assertTrue(valida_senha("MinhaSenhaSegura@2024!"))


# ─────────────────────────────────────────────
# RUNNER
# ─────────────────────────────────────────────

if __name__ == "__main__":
    unittest.main(verbosity=2)

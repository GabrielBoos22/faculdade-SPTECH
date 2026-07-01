from flask import Flask, request, render_template_string
import time
import random

app = Flask(__name__)

form_html = """
<!doctype html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <title>Formulário de Inscrição</title>
  <style>
    * { box-sizing: border-box; margin: 0; padding: 0; }
    body {
      font-family: 'Segoe UI', sans-serif;
      background: #0f172a;
      min-height: 100vh;
      display: flex;
      align-items: center;
      justify-content: center;
    }
    .card {
      background: #1e293b;
      border: 1px solid #334155;
      border-radius: 12px;
      padding: 40px;
      width: 420px;
      box-shadow: 0 25px 50px rgba(0,0,0,0.5);
    }
    h1 {
      color: #f1f5f9;
      font-size: 1.6rem;
      margin-bottom: 8px;
    }
    p { color: #64748b; font-size: 0.9rem; margin-bottom: 28px; }
    label { display: block; color: #94a3b8; font-size: 0.85rem; margin-bottom: 6px; margin-top: 16px; }
    input, select {
      width: 100%;
      padding: 10px 14px;
      background: #0f172a;
      border: 1px solid #334155;
      border-radius: 8px;
      color: #f1f5f9;
      font-size: 0.95rem;
      outline: none;
      transition: border-color 0.2s;
    }
    input:focus, select:focus { border-color: #3b82f6; }
    select option { background: #1e293b; }
    button {
      margin-top: 24px;
      width: 100%;
      padding: 12px;
      background: #3b82f6;
      color: white;
      border: none;
      border-radius: 8px;
      font-size: 1rem;
      font-weight: 600;
      cursor: pointer;
      transition: background 0.2s;
    }
    button:hover { background: #2563eb; }
  </style>
</head>
<body>
  <div class="card">
    <h1>Inscrição</h1>
    <p>São Paulo Tech School — Cadastro de Aluno</p>
    <form action="/submit" method="post">
      <label for="nome">Nome completo</label>
      <input type="text" id="nome" name="nome" placeholder="Seu nome" required>

      <label for="email">E-mail</label>
      <input type="email" id="email" name="email" placeholder="seu@email.com" required>

      <label for="curso">Curso</label>
      <select name="curso" id="curso" required>
        <option value="">Selecione...</option>
        <option value="ADS">Análise e Desenvolvimento de Sistemas</option>
        <option value="SI">Sistemas de Informação</option>
        <option value="BD">Banco de Dados</option>
      </select>

      <button type="submit">Enviar Inscrição</button>
    </form>
  </div>
</body>
</html>
"""

@app.route("/", methods=["GET"])
def index():
    return render_template_string(form_html)

@app.route("/submit", methods=["POST"])
def submit():
    nome = request.form.get("nome")
    email = request.form.get("email")
    curso = request.form.get("curso")
    print(f"Recebido: {nome}, {email}, {curso}")
    return "Formulário recebido com sucesso!", 200

if __name__ == "__main__":
    app.run(debug=True, threaded=True)

import javax.swing.JOptionPane

fun main() {
    var relogio = Relógio()
    relogio.horas = 24
    relogio.minutos = 60
    relogio.segundos = 23
    relogio.modelo = "Rolex"
    relogio.preco = 25.0

    var validacao = relogio.validar()
    var hora = relogio.verHora()
    JOptionPane.showMessageDialog(null, "A hora é: $hora")
    JOptionPane.showMessageDialog(null, "${validacao}")

    var relogio2 = Relógio()
    relogio2.horas = JOptionPane.showInputDialog("Digite as horas").toInt();
    relogio2.minutos = JOptionPane.showInputDialog("Digite os minutos").toInt();
    relogio2.segundos = JOptionPane.showInputDialog("Digite os segundos").toInt();
    relogio2.modelo = JOptionPane.showInputDialog("Digite o modelo");
    relogio2.preco = JOptionPane.showInputDialog("Digite o preço").toDouble();

    validacao = relogio2.validar();
    hora = relogio2.verHora()
    JOptionPane.showMessageDialog(null, "${validacao}")
    JOptionPane.showMessageDialog(null, "Hora no 2º relógio: ${hora}")
}


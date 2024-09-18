package business.beans;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(String numero, double saldoInicial, Cliente cliente) {
        super(numero, saldoInicial, cliente);
    }

    public void rendendoJuros(double taxa, int tempoMeses) {
        this.depositar(this.getSaldo()*taxa*tempoMeses);
        System.out.println("Aplicação de juros simples a taxa de " + taxa + "%, por " + tempoMeses + " meses foi realizada com sucesso!");
    }

    public void imprimirExtrato(Cliente titular) {
        System.out.println("Extrato conta poupança: ");
        super.imprimirInfoComuns(titular);
    }
}


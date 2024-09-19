package business.beans;

public class ContaPoupanca extends RegistroContas {

    public ContaPoupanca(String numero, double saldoInicial, RegistroClientes cliente) {
        super(numero, saldoInicial, cliente);
    }

    public void rendendoJuros(double taxa, int tempoMeses) {
        this.depositar(this.getSaldo()*taxa*tempoMeses);
        System.out.println("Aplicação de juros simples a taxa de " + taxa + "%, por " + tempoMeses + " meses foi realizada com sucesso!");
    }

    public void imprimirExtrato(RegistroClientes titular) {
        System.out.println("Extrato conta poupança: ");
        super.imprimirInfoComuns(titular);
    }
}


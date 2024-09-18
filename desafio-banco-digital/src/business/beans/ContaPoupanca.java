package business.beans;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(double saldoInicial, Cliente cliente) {
        super(saldoInicial, cliente);
    }

    public void imprimirExtrato(Cliente titular) {
        System.out.println("Extrato conta poupança: ");
        super.imprimirInfoComuns(titular);
    }
}


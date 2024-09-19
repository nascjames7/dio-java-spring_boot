package business.beans;

public class ContaCorrente extends Conta {
    public ContaCorrente(String numero, double saldoInicial, Cliente clint) {
        super(numero, saldoInicial, clint);
    }

    public void imprimirExtrato(Cliente titular) {
        System.out.println("Extrato conta corrente: ");
        super.imprimirInfoComuns(titular);
    }



}

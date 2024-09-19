package business.beans;

public class ContaCorrente extends RegistroContas {
    public ContaCorrente(String numero, double saldoInicial, RegistroClientes cliente) {
        super(numero, saldoInicial, cliente);
    }

    public void imprimirExtrato(RegistroClientes titular) {
        System.out.println("Extrato conta corrente: ");
        super.imprimirInfoComuns(titular);
    }



}

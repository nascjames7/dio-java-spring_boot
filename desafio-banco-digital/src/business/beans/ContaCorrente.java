package business.beans;

import business.beans.Conta;

public class ContaCorrente extends Conta {
    public ContaCorrente(double saldoInicial, Cliente cliente) {
        super(saldoInicial, cliente);
    }

    public void imprimirExtrato(Cliente titular) {
        System.out.println("Extrato conta corrente: ");
        super.imprimirInfoComuns(titular);
    }



}

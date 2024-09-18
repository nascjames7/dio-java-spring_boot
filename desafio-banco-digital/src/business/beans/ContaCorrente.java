package business.beans;

import business.beans.Conta;

public class ContaCorrente extends Conta {
    public ContaCorrente(String numero, double saldoInicial, Cliente cliente) {
        super(numero, saldoInicial, cliente);
    }

    public void imprimirExtrato(Cliente titular) {
        System.out.println("Extrato conta corrente: ");
        super.imprimirInfoComuns(titular);
    }



}

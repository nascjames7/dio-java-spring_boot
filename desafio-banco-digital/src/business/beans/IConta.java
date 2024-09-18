package business.beans;

import business.beans.Conta;

public interface IConta{

    public void sacar(double valor);

    public void depositar(double valor);

    public void transferir(double valor, Conta contaDestino);

    public void imprimirInfoComuns(Cliente titular);

}


package business.beans;

public interface IConta{

    public void sacar(double valor);

    public void depositar(double valor);

    public void transferir(double valor, RegistroContas contaDestino);

    public void imprimirInfoComuns(RegistroClientes titular);

}


package data;

import business.beans.Cliente;
import business.beans.Conta;

public class RepositoryContaBDR implements IRepositoryConta{
    @Override
    public void cadastrar(Conta conta) {

    }

    @Override
    public void cadastrar(String numero, double saldoInicial, Cliente cliente) {

    }

    @Override
    public Conta procurar(String num) {
        return null;
    }

    @Override
    public void remover(String num) {

    }

    @Override
    public void renderJuros(String numero, int tempo) {

    }
}

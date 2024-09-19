package data;

import business.beans.RegistroClientes;
import business.beans.RegistroContas;

public class RepositoryContaBDR implements IRepositoryConta{
    @Override
    public void cadastrar(RegistroContas conta) {

    }

    @Override
    public void cadastrar(String numero, double saldoInicial, RegistroClientes cliente) {

    }

    @Override
    public RegistroContas procurar(String num) {
        return null;
    }

    @Override
    public void remover(String num) {

    }

    @Override
    public void renderJuros(String numero, int tempo) {

    }
}

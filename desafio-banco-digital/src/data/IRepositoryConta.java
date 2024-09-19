package data;

import business.beans.RegistroClientes;
import business.beans.RegistroContas;

public interface IRepositoryConta {

    void cadastrar(RegistroContas conta);
    void cadastrar(String numero, double saldoInicial, RegistroClientes cliente);
    RegistroContas procurar(String numero);
    void remover(String numero);
    void renderJuros(String numero, int tempo);
}

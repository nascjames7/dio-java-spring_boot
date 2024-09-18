package data;

import business.beans.Cliente;
import business.beans.Conta;

public interface IRepositoryConta {

    void cadastrar(Conta conta);
    void cadastrar(String numero, double saldoInicial, Cliente cliente);
    Conta procurar(String numero);
    void remover(String numero);
    void renderJuros(String numero, int tempo);
}

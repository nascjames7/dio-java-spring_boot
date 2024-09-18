package data;

import business.beans.Cliente;
import business.beans.Conta;

public interface IRepositoryConta {

    void cadastrar(Conta conta);
    void cadastrar(String numero, double saldoInicial, Cliente cliente);
    Conta procurar(String num);
    void remover(String num);
    void renderJuros(String num);
}

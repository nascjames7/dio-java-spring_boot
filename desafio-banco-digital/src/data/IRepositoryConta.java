package data;

import business.beans.Conta;

public interface IRepositoryConta {

    void cadastrar(Conta conta);
    void cadastrar(String numero, double saldoInicial);
    Conta procurar(String num);
    void remover(String num);
    void renderJuros(String num);
}

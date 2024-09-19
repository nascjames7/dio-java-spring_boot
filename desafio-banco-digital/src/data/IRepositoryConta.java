package data;

import business.beans.RegistroClientes;
import business.beans.RegistroContas;

public interface IRepositoryConta {

    /**
     * Cadastra uma nova conta no array de contas.
     *
     * @param conta
     *          A referência da conta a ser cadastrada
     */
    void cadastrarConta(Conta conta);
    void cadastrar(String numero, double saldoInicial, RegistroClientes cliente);
    RegistroContas procurar(String numero);
    void remover(String numero);
    void renderJuros(String numero, int tempo);
}

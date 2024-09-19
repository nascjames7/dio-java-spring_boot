package business.beans;

import exceptions.ContaNaoExistenteException;
import exceptions.ContaNaoPodeSerDuplicadaException;
import exceptions.SaldoIncompativelException;

public interface IBanco {

    void cadastrarCliente();

    void efetuarLogin();

    void cadastrarConta(RegistroContas conta) throws ContaNaoPodeSerDuplicadaException;

    void removerConta(String numero) throws ContaNaoExistenteException;

    RegistroContas procurarConta(String numero) throws ContaNaoExistenteException;

    void transferir(String numOrigem, String numDestino, double valor)
            throws ContaNaoExistenteException, SaldoIncompativelException;
}

package business.beans;

public interface IBanco {

    void cadastrarCliente();

    void efetuarLogin();

    void cadastrarConta(Conta conta) throws ContaJaExisteException;

    void removerConta(String numero) throws ContaNaoExisteException;

    Conta procurarConta(String numero) throws ContaNaoExisteException;

    void transferir(String numOrigem, String numDestino, double valor)
            throws ContaNaoExisteException, SaldoInsuficienteException;
}

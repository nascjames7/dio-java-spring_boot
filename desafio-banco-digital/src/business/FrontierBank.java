package business;

import business.beans.Conta;
import data.RepositoryContaArray;
import exceptions.ContaNaoExistenteException;
import exceptions.ContaNaoPodeSerDuplicadaException;
import exceptions.SaldoIncompativelException;

public class FrontierBank implements IBanco {

    private RegistroClientes clientes;
    private RegistroContas contas;
    private RegistroAdministradores adms;

    private static IBanco instance;

    // Construtor privado para evitar instanciação fora da classe.
    private FrontierBank() {
        this.contas = new RegistroContas(RepositoryContaArray.getInstance());
        this.clientes = new RegistroClientes(5);
        this.adms = new RegistroAdministradores("jan", "1234");
    }
    /**
     * Implementando padrão Singleton
     *
     * @return A instância da desta fachada
     */
    public static IBanco getInstance() {
        if (instance == null) {
            instance = new FrontierBank();
        }
        return instance;
    }

    @Override
    public void cadastrarCliente() {

    }

    @Override
    public void efetuarLogin() {

    }

    @Override
    public void cadastrarConta(RegistroContas conta) throws ContaNaoPodeSerDuplicadaException {

    }

    @Override
    public void removerConta(String numero) throws ContaNaoExistenteException {

    }

    @Override
    public RegistroContas procurarConta(String numero) throws ContaNaoExistenteException {
        return null;
    }

    @Override
    public void transferir(String numOrigem, String numDestino, double valor) throws ContaNaoExistenteException, SaldoIncompativelException {

    }



    /*public void cadastrarConta(Conta conta) throws ContaNaoPodeSerDuplicadaException {
        this.contas.cadastrarConta(conta);
    }


    public Conta procurarConta(String numero) throws ContaNaoExistenteException {
        return this.contas.procurarConta(numero);
    }


    public void transferir(double valor, Conta destino)
            throws ContaNaoExistenteException, SaldoIncompativelException {
        contas.transferir(valor, destino);
    }


    public void removerConta(String num) throws ContaNaoExisteException {
        this.contas.remover(num);
    }


    public void efetuarLogin() {
        this.logins.efetuarLogin();
    }

    @Override
    public void cadastrarConta(RegistroContas conta) throws ContaNaoPodeSerDuplicadaException {
*/
}

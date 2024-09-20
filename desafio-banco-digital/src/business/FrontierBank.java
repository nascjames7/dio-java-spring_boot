package business;

import business.beans.Conta;
import exceptions.ContaNaoPodeSerDuplicadaException;

public class FrontierBank implements IBanco {

    private RegistroClientes clientes;
    private RegistroContas contas;
    private RegistroAdministradores adms;

    private static IBanco instance;

    // Construtor privado para evitar instanciação fora da classe.
    private FrontierBank() {
        this.contas = new RegistroContas(RepositoryContaArray.getInstance());
        this.clientes = new RegistroClientes();
        this.adms = new RegistroAdministradores();
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

    /*
     * (non-Javadoc)
     *
     * @see br.ufrpe.sistema_bancario.negocio.IFachada#cadastrarCliente()
     */
    public void cadastrarCliente() {
        this.clientes.cadastrarCliente();
    }

    /*
     * (non-Javadoc)
     *
     * @see br.ufrpe.sistema_bancario.negocio.IFachada#cadastrarConta(br.ufrpe.
     * sistema_bancario.negocio.beans.Conta)
     */
    public void cadastrarConta(Conta conta) throws ContaNaoPodeSerDuplicadaException {
        this.contas.cadastrarConta(conta);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * br.ufrpe.sistema_bancario.negocio.IFachada#procurarConta(java.lang.String)
     */
    public Conta procurarConta(String num) throws ContaNaoExisteException {
        return this.contas.procurar(num);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * br.ufrpe.sistema_bancario.negocio.IFachada#transferir(java.lang.String,
     * java.lang.String, double)
     */
    public void transferir(String numOrigem, String numDestino, double valor)
            throws ContaNaoExisteException, SaldoInsuficienteException {
        contas.transferir(numOrigem, numDestino, valor);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * br.ufrpe.sistema_bancario.negocio.IFachada#removerConta(java.lang.String)
     */
    public void removerConta(String num) throws ContaNaoExisteException {
        this.contas.remover(num);
    }

    /*
     * (non-Javadoc)
     *
     * @see br.ufrpe.sistema_bancario.negocio.IFachada#efetuarLogin()
     */
    public void efetuarLogin() {
        this.logins.efetuarLogin();
    }

    @Override
    public void cadastrarConta(RegistroContas conta) throws ContaNaoPodeSerDuplicadaException {

    }
}

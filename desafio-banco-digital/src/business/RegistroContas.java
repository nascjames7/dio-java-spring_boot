package business;

import business.beans.Conta;
import business.beans.ContaEspecial;
import business.beans.ContaPoupanca;
import data.IRepositoryConta;
import exceptions.ContaNaoExistenteException;
import exceptions.ContaNaoPodeSerDuplicadaException;
import exceptions.SaldoIncompativelException;

public class RegistroContas {
    private IRepositoryConta repository;
    //Variável relacionada ao cálculo dos juros relacionada a conta poupança.
    public static final double TAXA_JUROS_POUPANCA = 0.01;
    //Variável relacionada ao cálculo dos juros relacionada a conta especial.
    public static final double TAXA_JUROS_ESPECIAL = 0.08;

    public RegistroContas(IRepositoryConta instanciaRepositorio) {
        this.repository = instanciaRepositorio;
    }

    //Verifica se o numero da conta já existe.
    public boolean existe(String numero) {
        return this.repository.existe(numero);
    }

    //Procura conta pelo número da conta.
    public Conta procurarConta(String numero) throws ContaNaoExistenteException {
        return this.repository.procurarConta(numero);
    }

    //Remove conta do repositório.
    public void removerConta(String numero) throws ContaNaoExistenteException {
        this.repository.removerConta(numero);
        this.repository.salvarArquivo();
    }

    //Remove uma conta anteriormente registrda.
    public void removerRegistroDeConta(String numero) throws ContaNaoExistenteException {
        //Procura o numero da conta a ser removida no repositório de contas.
        Conta conta = this.repository.procurarConta(numero);
        //Verififica se a conta é nula e se o saldo é zero.
        if (conta != null && conta.getSaldo() == 0) {
            //Caso positivo, remove a conta e salva as alterações
            this.repository.removerConta(numero);
            this.repository.salvarArquivo();
        } else {
            //Se a conta não for encontrada, lança a exceção.
            throw new ContaNaoExistenteException(numero);
        }
    }

    //Realiza o registro de uma conta.
    public void registrarConta(Conta conta) throws ContaNaoPodeSerDuplicadaException {
        /**
         * Verifica se a String não é nula.
         * Caso seja nula, lança uma exceção.
         */
        if (conta == null) {
            throw new IllegalArgumentException("Parâmetro inválido");
        } else {
            /**
             * Verifica se o número da conta já existe.
             * Caso não exista, realiza o registro e salva.
             * Se o número já existe, lança uma exceção.
             */
            if (!this.existe(conta.getNumero())) {
                this.repository.registrarConta(conta);
                this.repository.salvarArquivo();
            } else {
                throw new ContaNaoPodeSerDuplicadaException(conta.getNumero());
            }
        }
    }

    /**
     * Procura a conta cujo número é passado como parâmetro e credita o valor
     * também passado como par�metro
     *
     * @param numero
     *            N�mero da conta a ser procurada
     * @param valor
     *            Valor a ser creditado na conta encontrada
     * @throws ContaNaoExistenteException
     */
    public void depositar(String numero, double valor)
            throws ContaNaoExistenteException {
        Conta contaCredito = this.repository.procurarConta(numero);
        if (contaCredito != null) {
            contaCredito.depositar(valor);
            this.repository.salvarArquivo();
        }
    }

    /**
     * Procura a conta cujo número é passado como parâmetro e debita o valor
     * também passado como parâmetro.
     *
     * @param numero Número da conta a ser procurada
     * @param valor  Valor a ser debitado na conta encontrada
     * @throws ContaNaoExistenteException
     * @throws SaldoIncompativelException
     */

    //Realiza o saque de determinado valor.
    public void sacar(String numero, double valor)
            throws ContaNaoExistenteException, SaldoIncompativelException {
        //Procura a conta no repositório atravé do número.
        Conta contaDebito = this.repository.procurarConta(numero);
        //Verifica se a conta não é nula e realiza o saque.
        if (contaDebito != null) {
            contaDebito.sacar(valor);
            this.repository.salvarArquivo();
        }
    }

    /**
     * Realiza transfer�ncia de valores entre as duas contas a partir dos
     * n�meros das contas passados como par�metro
     *
     * @param numeroContaDebitada
     *            Número da conta origem
     * @param numeroContaCreditada
     *            Número da conta destino
     * @param valor
     *            Valor a ser transferido
     * @throws ContaNaoExistenteException
     * @throws SaldoIncompativelException
     */
    public void transferir(String numeroContaDebitada, String numeroContaCreditada, double valor)
            throws ContaNaoExistenteException, SaldoIncompativelException {
        //Encontra as contas envolvidas na operação de transferência.
        Conta origem = this.repository.procurarConta(numeroContaDebitada);
        Conta destino = this.repository.procurarConta(numeroContaCreditada);
        //Verifica a nulidade das contas e realiza a operação.
        if (origem != null && destino != null && origem.getSaldo() >= valor) {
            origem.sacar(valor);
            destino.depositar(valor);
            this.repository.salvarArquivo();
        }
    }

    //Retorna o saldo de uma determinada conta.
    public double getSaldo(String numero) throws ContaNaoExistenteException {
        Conta conta = this.repository.procurarConta(numero);
        return conta.getSaldo();
    }


    //Cálcula o rendimento de juros na conta poupança.
    public void rendendoJuros(String numero, int tempoMeses) throws ContaNaoExistenteException {
        //Encontra uma determinada conta no repositório.
        Conta conta = this.repository.procurarConta(numero);
        //Verifica se a conta é do tipo poupança e realiza a operação do cálculo de juros.
        if (conta instanceof ContaPoupanca) {
            ((ContaPoupanca) conta).rendendoJuros(TAXA_JUROS_POUPANCA, tempoMeses);
            this.repository.salvarArquivo();
        } else {
            throw new ContaNaoExistenteException(numero);
        }
    }
}

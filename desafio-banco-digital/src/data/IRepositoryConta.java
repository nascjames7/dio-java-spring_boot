package data;

import business.beans.Cliente;
import business.beans.Conta;
import exceptions.ContaNaoPodeSerDuplicadaException;
import exceptions.ContaNaoExistenteException;

public interface IRepositoryConta {

    /**
     * Cadastra uma nova conta no array de contas.
     *
     * @param conta
     *          A referência da conta a ser cadastrada
     */
    void registrarConta(Conta conta);
    /**
     * Cria o objeto da conta com o n�mero e saldo inicial passados como par�metro
     * e cadastra a conta no array de contas. Observe o reuso entre os m�todos
     * sobrecarregados "cadastrar"
     *
     * @param numero
     *          N�mero da conta a ser criada e cadastrada
     * @param saldoInicial
     *          Saldo inicial da conta a ser criada e cadastrada
     * @param clint
     *          Cliente que possue a respectiva conta.
     */
    void registrar(String numero, double saldoInicial, Cliente clint);
    /**
     * Procurar uma conta baseado no n�mero dado como par�metro
     *
     * @param numero
     *          O n�mero da conta a ser procurada
     * @return A conta encontrada ou null se o n�mero de conta passado com
     *         par�metro n�o existir
     * @throws ContaNaoPodeSerDuplicadaException Exceção é levantada quando a conta procurada
     *                                 não existe
     */
    Conta procurarConta(String numero);
    boolean existe(String numero);
    /**
     * Removendo a conta cujo n�mero � passado como par�metro
     *
     * @param numero
     *          N�mero da conta a ser removida.
     * @throws ContaNaoExistenteException
     */
    void removerConta(String numero);
    void renderJuros(String numero, int tempo);
    /**
     * Método que procura por contas cujo saldo é maior do que 1000 e retorna em
     * formato de Array
     *
     * @return Array de Conta com saldo maior do que 1000
     */
    Conta[] retornaContasVIP();

    /**
     * Método responsável por salvar todo o repositório em um arquivo específico,
     * apagando o conteúdo salvo anteriormente no arquivo ou criando um novo
     * arquivo se o mesmo não existir.
     *
     */
    void salvarArquivo();
}

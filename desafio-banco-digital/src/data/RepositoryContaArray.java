package data;

import business.beans.Cliente;
import business.beans.Conta;

public class RepositoryContaArray implements IRepositoryConta{

    private static final double TAXA_JUROS = 0.75;
    private Conta[] contas;
    private int proxima;
    /**
     * Construtor público
     * @param tamanho Tamanho inicial do array de contas a ser construido
     */
    public RepositoryContaArray(int tamanho) {
        //Instancia uma conta de tamanho definido.
        this.contas = new Conta[tamanho];
        this.proxima = 0;
    }

    //Método que cadastra contas.
    @Override
    public void cadastrar(Conta conta) {
        //Adiona a conta no Array contas.
        this.contas[this.proxima] = conta;
        //Incremento da posição do Array para cadastrar a próxima conta.
        this.proxima += 1;
        /**
         * Implementação de estrutura condicional que duplica o tamanho do Array
         * caso seja atingido sua capacidade.
         */
        if (this.proxima == this.contas.length) {
            //Chamada de método que duplica o tamanho do Array.
            this.duplicarArrayContas();
        }
        System.out.println("LOG: Nova conta cadastrada de número: " + conta.getNumero());
    }

    //Método que dupplica o tamanho do Array ao encontrar sua posição final.
    private void duplicarArrayContas() {
        //Implementação de estrutura condicional que verifica se o Array não está vazio.
        if (this.contas != null && this.contas.length > 0) {
            //Instanciação do Array com tamanho duplicado.
            Conta[] arrayDuplicado = new Conta[this.contas.length * 2];
            //Implementação do laço para realocar os dados do Array anterior para o novo array duplicado.
            for (int contador = 0; contador < this.contas.length; contador++) {
                //Realocação do array menor para o maior.
                arrayDuplicado[contador] = this.contas[contador];
            }
            //Atribuição do nome do Array anterior ao novo Array.
            this.contas = arrayDuplicado;
        }
    }

    /**
     * Sobrecarga do método cadastrar.
     * Cria o objeto da conta com o número e saldo inicial passados como
     * parâmetro e cadastra a conta no array de contas. Sobreacrga do método cadastrar.
     *
     * @param numero Número da conta a ser criada e cadastrada
     * @param saldoInicial Saldo inicial da conta a ser criada e cadastrada
     */
    @Override
    public void cadastrar(String numero, double saldoInicial, Cliente cliente) {
        //Instanciação do objeto da classe Conta através dos parâmetros acima.
        Conta conta = new Conta(numero, saldoInicial, cliente);
        this.cadastrar(conta);
    }

    /**
     * Método que encontra uma determinada conta com base em seu número.
     *
     * @param numero O nÚmero da conta a ser procurada
     * @return A conta encontrada ou null se o número de conta passado com
     *         parâmetro não existir
     */
    @Override
    public Conta procurar(String numero) {

        int indice = this.procurarIndice(numero);
        Conta resultado = null;
        if (indice != this.proxima) {
            resultado = this.contas[indice];
        }
        return resultado;
    }

    /**
     * M�todo auxiliar para procurar o índice de uma conta no array.
     *
     * @param numero Número da conta da qual deseja-se encontrar o índice no array
     *        de contas
     * @return Um inteiro correspondente ao índice da conta encontrada.
     */
    private int procurarIndice(String numero) {
        //Definição da variável índice.
        int indice = 0;
        //Definição da varíavel booleana.
        boolean achou = false;
        //Implementação do laço para encontrar o indice referente ao número da conta.
        while ((!achou) && (indice < this.proxima)) {
            //Implementação da estrutura condicional que compara o numero das contas com o numero procurado.
            if (numero.equals(this.contas[indice].getNumero())) {
                //Alteração da variávei booleana achou.
                achou = true;
            } else {
                //Incremento da varíavel índice.
                indice++;
            }
        }
        //Retorna o indice procurado.
        return indice;
    }

    @Override
    public void remover(String num) {

    }

    @Override
    public void renderJuros(String num) {

    }
}

package data;

import business.beans.Cliente;
import business.beans.Conta;
import business.beans.ContaPoupanca;
;

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

    //Método que duplica o tamanho do Array ao encontrar sua posição final.
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
        //Definição da variável indice.
        int indice = this.procurarIndice(numero);
        //Instanciação de uma conta nula (vazia).
        Conta resultado = null;
        //Implementação da estrutura condicional que encontra a conta através do número.
        if (indice != this.proxima) {
            //Define a conta procurada na variável resultado.
            resultado = this.contas[indice];
        }
        //Retorna a conta procurada.
        return resultado;
    }

    /**
     * Método auxiliar para procurar o índice de uma conta no array.
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

    /**
     * Removendo a conta cujo número foi passado como parâmetro
     *
     * @param numero Número da conta a ser removida.
     */
    @Override
    public void remover(String numero) {
        //Definição da variável e chamada do método procurarIndice(numero).
        int indice = this.procurarIndice(numero);
        //Implementação de estrutura condicional para verificar a conta procurada.
        if (indice != this.proxima) {
            //Alteração do valor da variável contas[].
            this.contas[indice] = this.contas[this.proxima - 1];
            //Esvazia a conta armazenada no local de indice: this.proxima - 1.
            this.contas[this.proxima - 1] = null;
            //Alteração do valor do índice.
            this.proxima = this.proxima - 1;
            System.out.println("LOG: Conta " + numero + " removida");
        } else {
            System.out.println("LOG: Conta com número " + numero + " não existe.");
        }
    }

    @Override
    public void renderJuros(String numero, int tempo) {
        //Atribuição de uma conta.
        Conta conta = this.procurar(numero);
        //Implementação de estrutura condicional de verificação.
        if (conta instanceof ContaPoupanca) {
            ((ContaPoupanca) conta).rendendoJuros(this.TAXA_JUROS, tempo);
        }
    }
}

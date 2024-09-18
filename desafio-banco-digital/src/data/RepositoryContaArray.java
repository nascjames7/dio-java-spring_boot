package data;

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

    @Override
    public void cadastrar(String numero, double saldoInicial) {

    }

    @Override
    public Conta procurar(String num) {
        return null;
    }

    @Override
    public void remover(String num) {

    }

    @Override
    public void renderJuros(String num) {

    }
}

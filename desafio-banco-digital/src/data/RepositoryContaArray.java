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
            this.duplicaArrayContas();
        }
        System.out.println("LOG: Nova conta cadastrada de número: " + conta.getNumero());
    }

    private void duplicaArrayContas() {
        if (this.contas != null && this.contas.length > 0) {
            Conta[] arrayDuplicado = new Conta[this.contas.length * 2];
            for (int i = 0; i < this.contas.length; i++) {
                arrayDuplicado[i] = this.contas[i];
            }
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

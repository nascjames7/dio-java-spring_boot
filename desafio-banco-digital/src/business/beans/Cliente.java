package business.beans;

public class Cliente {

    private String nome;
    private String cpf;
    private Cliente[] clientes;
    private int proxima;

    public Cliente(String nome, String cpf, int tamanho) {
        this.nome = nome;
        this.cpf = cpf;
        this.clientes = new Cliente[tamanho];
        this.proxima = 0;
    }

    //Método que cadastra clientes.
    public void cadastrarCliente(Cliente cliente) {
        //Adiona um cliente no Array contas.
        this.clientes[this.proxima] = cliente;
        //Incremento da posição do Array para cadastrar a próxima conta.
        this.proxima++;
        /**
         * Implementação de estrutura condicional que duplica o tamanho do Array
         * caso seja atingido sua capacidade.
         */
        if (this.proxima == this.clientes.length) {
            //Chamada de método que duplica o tamanho do Array.
            this.duplicarArrayClientes();
        }
        System.out.println("Novo cliente cadastrado! Nome: " + cliente.getNome() + "cpf: " + cliente.getCpf());
    }

    //Método que duplica o tamanho do Array ao encontrar sua posição final.
    private void duplicarArrayClientes() {
        //Implementação de estrutura condicional que verifica se o Array não está vazio.
        if (this.clientes != null && this.clientes.length > 0) {
            //Instanciação do Array com tamanho duplicado.
            Cliente[] arrayDuplicado = new Cliente[this.clientes.length * 2];
            //Implementação do laço para realocar os dados do Array anterior para o novo array duplicado.
            for (int contador = 0; contador < this.clientes.length; contador++) {
                //Realocação do array menor para o maior.
                arrayDuplicado[contador] = this.clientes[contador];
            }
            //Atribuição do nome do Array anterior ao novo Array.
            this.clientes = arrayDuplicado;
        }
    }
    /**
     * Método auxiliar para procurar o índice de um cliente no array.
     *
     * @param cpf Cpf da conta da qual deseja-se encontrar o índice no array
     *        de clientes
     * @return Um inteiro correspondente ao índice do cliente encontrado.
     */
    private int procurarIndiceCliente(String cpf) {
        //Definição da variável índice.
        int indice = 0;
        //Definição da varíavel booleana.
        boolean achou = false;
        //Implementação do laço para encontrar o indice referente ao cpf do cliente.
        while ((!achou) && (indice < this.proxima)) {
            //Implementação da estrutura condicional que compara o cpf do cliente com o cpf procurado.
            if (cpf.equals(this.clientes[indice].getCpf())) {
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
     * Removendo o cliente cujo cpf foi passado como parâmetro
     *
     * @param cpf Cpf do cliente a ser removido.
     */

    public void removerCliente(String cpf) {
        //Definição da variável e chamada do método procurarIndice(cpf).
        int indice = this.procurarIndiceCliente(cpf);
        //Implementação de estrutura condicional para verificar a conta procurada.
        if (indice != this.proxima) {
            //Alteração do valor da variável contas[].
            this.clientes[indice] = this.clientes[this.proxima - 1];
            //Esvazia a conta armazenada no local de indice: this.proxima - 1.
            this.clientes[this.proxima - 1] = null;
            //Alteração do valor do índice.
            this.proxima = this.proxima - 1;
            System.out.println("Cliente " + cpf + " removido.");
        } else {
            System.out.println("Cliente com cpf " + cpf + " não existe.");
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
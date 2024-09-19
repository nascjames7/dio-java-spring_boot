package business.beans;

public class RegistroAdministradores {

    private String login;
    private String senha;
    private RegistroAdministradores[] adms;
    private int proxima;
    private int tamanho = 10;

    public RegistroAdministradores(String login, String senha) {
        this.login = login;
        this.senha = senha;
        this.adms = new RegistroAdministradores[tamanho];
        this.proxima = 0;
    }

    // Método para realizar login
    public boolean efetuarLogin(String login, String senha){
        //Implementação do laço para efetuar o login.


        return false;
    }

    // Método ilustrativo para cadastrar um novo usuário com login e senha.
    public void cadastrarNovoAdministrador(String login, String senha) {
        //Instanciação do objeto da classe Login através dos parâmetros acima.
        RegistroAdministradores lg = new RegistroAdministradores(login, senha);
        //Adiona a conta no Array logins.
        this.adms[this.proxima] = lg;
        //Incremento da posição do Array para cadastrar o próximo usuário.
        this.proxima += 1;
        /**
         * Implementação de estrutura condicional que duplica o tamanho do Array
         * caso seja atingido sua capacidade.
         */
        if (this.proxima == this.adms.length) {
            //Chamada de método que duplica o tamanho do Array.
            this.duplicarArrayLogins();
        }
        System.out.println("Novo usuário cadastrado de login: " + lg.getLogin());
    }

    //Método que duplica o tamanho do Array ao encontrar sua posição final.
    private void duplicarArrayLogins() {
        //Implementação de estrutura condicional que verifica se o Array não está vazio.
        if (this.adms != null && this.adms.length > 0) {
            //Instanciação do Array com tamanho duplicado.
            RegistroAdministradores[] arrayDuplicado = new RegistroAdministradores[this.adms.length * 2];
            //Implementação do laço para realocar os dados do Array anterior para o novo array duplicado.
            for (int contador = 0; contador < this.adms.length; contador++) {
                //Realocação do array menor para o maior.
                arrayDuplicado[contador] = this.adms[contador];
            }
            //Atribuição do nome do Array anterior ao novo Array.
            this.adms = arrayDuplicado;
        }
    }

    /**
     * Método que encontra um determinado login com base em seu login.
     *
     * @param login e @param senha O número da conta a ser procurada
     * @return A conta encontrada ou null se o número de conta passado com
     *         parâmetro não existir
     */
    public RegistroAdministradores procurar(String login) {
        //Definição da variável indice.
        int indice = this.procurarIndiceAdministrador(login);
        //Instanciação de um usuário nulo (vazio).
        RegistroAdministradores resultado = null;
        //Implementação da estrutura condicional que encontra a conta através do número.
        if (indice != this.proxima) {
            //Define o usuário procurado na variável resultado.
            resultado = this.adms[indice];
        }
        //Retorna a conta procurada.
        return resultado;
    }

    /**
     * Método auxiliar para procurar o índice de um usuário no array.
     *
     * @param login Login do usuário da qual deseja-se encontrar o índice no array
     *        de contas
     * @return Um inteiro correspondente ao índice da conta encontrada.
     */
    private int procurarIndiceAdministrador(String login) {
        //Definição da variável índice.
        int indice = 0;
        //Definição da varíavel booleana.
        boolean achou = false;
        //Implementação do laço para encontrar o indice referente ao número da conta.
        while ((!achou) && (indice < this.proxima)) {
            //Implementação da estrutura condicional que compara o login dos usuarios com o numero procurado.
            if (login.equals(this.adms[indice].getLogin())) {
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
     * Removendo a usuário cujo login foi passado como parâmetro
     *
     * @param login Login do usuário a ser removida.
     */

    public void removerAdninistrador(String login) {
        //Definição da variável e chamada do método procurarIndice(numero).
        int indice = this.procurarIndiceAdministrador(login);
        //Implementação de estrutura condicional para verificar a conta procurada.
        if (indice != this.proxima) {
            //Alteração do valor da variável contas[].
            this.adms[indice] = this.adms[this.proxima - 1];
            //Esvazia a conta armazenada no local de indice: this.proxima - 1.
            this.adms[this.proxima - 1] = null;
            //Alteração do valor do índice.
            this.proxima = this.proxima - 1;
            System.out.println("Login " + login + " removida");
        } else {
            System.out.println("Usuário com login " + login + " não existe.");
        }
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
}

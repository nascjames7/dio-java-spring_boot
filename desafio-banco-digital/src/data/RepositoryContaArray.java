package data;

import business.RegistroClientes;
import business.RegistroContas;
import business.beans.Cliente;
import business.beans.Conta;
import business.beans.ContaPoupanca;

import java.io.*;

public class RepositoryContaArray implements IRepositoryConta{

    private static final double TAXA_JUROS = 0.75;
    private Conta[] contas;
    private int proxima;

    private static RepositoryContaArray instance;
    /**
     * Construtor público
     * @param tamanho Tamanho inicial do array de contas a ser construido
     */
    public RepositoryContaArray(int tamanho) {
        //Instancia uma conta de tamanho definido.
        this.contas = new Conta[tamanho];
        this.proxima = 0;
    }

    public static IRepositoryConta getInstance() {
        //Verifica se a intancia de uma interface IRepositoryConta é nula.
        if (instance == null) {
            instance = lerDoArquivo();
        }
        return instance;
    }

    private static RepositoryContaArray lerDoArquivo() {
        //Instanciação de um objeto da classe RepositorioContaArray.
        RepositoryContaArray instanciaLocal = null;

        File in = new File("contas.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            instanciaLocal = (RepositoryContaArray) o;
        } catch (Exception e) {
            instanciaLocal = new RepositoryContaArray(100);
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {/* Silent exception */
                }
            }
        }
        return instanciaLocal;
    }

    public void salvarArquivo() {
        if (instance == null) {
            return;
        }
        File out = new File("contas.dat");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(out);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(instance);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    /* Silent */}
            }
        }
    }

    /*
     * (non-Javadoc)
     */
    public boolean existe(String numero) {
        boolean existe = false;
        int indice = this.procurarIndice(numero);
        if (indice != proxima) {
            existe = true;
        }
        return existe;
    }

    /*
     * (non-Javadoc)
     *
     * sistema_bancario.negocio.classes_basicas.Conta)
     */

    //Método que cadastra contas.
    @Override
    public void registrarConta(Conta conta) {
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
    public void registrarConta(String numero, double saldoInicial, Cliente cliente) {
        //Instanciação do objeto da classe Conta através dos parâmetros acima.
        Conta conta = new Conta(numero, saldoInicial, cliente);
        this.registrarConta(conta);
    }

    /**
     * Método que encontra uma determinada conta com base em seu número.
     *
     * @param numero O nÚmero da conta a ser procurada
     * @return A conta  é encontrada ou null se o número de conta passado com
     *         parâmetro não existir
     */
    @Override
    public Conta procurarConta(String numero) {
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
    public void removerConta(String numero) {
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
        Conta conta = this.procurarConta(numero);
        //Implementação de estrutura condicional de verificação.
        if (conta instanceof ContaPoupanca) {
            ((ContaPoupanca) conta).rendendoJuros(this.TAXA_JUROS, tempo);
        }
    }

    /*
     * (non-Javadoc)
     *
     */
    public Conta[] retornaContasVIP() {
        Conta[] contasVIP = new Conta[this.proxima];
        int posicaoAtual = 0;
        for (int contador = 0; contador < this.proxima; contador++) {
            if (this.contas[contador].getSaldo() > 1000) {
                contasVIP[posicaoAtual] = this.contas[contador];
                posicaoAtual++;
            }
        }
        return contasVIP;
    }

}

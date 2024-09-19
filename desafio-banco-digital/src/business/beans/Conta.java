package business.beans;
//Importação da biblioteca para serilizar/deserializar.
import exceptions.SaldoIncompativelException;
import java.util.ArrayList;
import java.util.List;

public class Conta {

    private static final int AGENCIA_PADRAO = 1;
    private int agencia;

    protected String numero;
    protected double saldo;
    protected Cliente clint;
    //Construtor da classe Conta.
    public Conta(String numero, double saldo, Cliente clint) {
        this.agencia = this.AGENCIA_PADRAO;
        this.numero = numero;
        this.saldo = saldo;
        this.clint = clint;
    }

    //Getters and Setters
    public String getNumero() {return numero;}
    public double getSaldo() {return saldo;}
    public Cliente getClint() {return clint;}

    private void setNumero(String numero) {
        //Verifica se a String que guarda o numero referente a conta não é nulo.
        if (numero != null) {
            this.numero = numero;
        } else {
            //Caso seja nulo, imprime a mensagem abaixo.
            System.out.println("Número inválido!");
        }
    }
    private void setClint(Cliente clint) {
        //Verifica se o cliente existe.
        if ((clint != null) && (clint.getNome() != null) && (clint.getCpf() != null)) {
            this.clint = clint;
        } else {
            //Caso cliente em questão não exita, imprime a mensagem abaixo.
            System.out.println("Cliente inválido!");
        }
    }
    private void setCliente(String numero) {
        //Verifica se a String que guarda o numero referente a conta não é nulo.
        if (numero != null) {
            this.numero = numero;
        } else {
            //Caso seja nulo, imprime a mensagem abaixo.
            System.out.println("Número inválido!");
        }
    }
    public boolean depositar(double valor) {
        //Declaração da variável booleana resultado.
        boolean resultado;
        //Verifica se o valor a ser depositado faz sentido (valor não nulo e positico).
        if (valor > 0) {
            this.saldo += valor;
            resultado = true;
        } else {
            resultado = false;
        }
        //Retorna true caso operação seja realizadacom sucesso.
        return resultado;
    }
    public void sacar(double valor) throws SaldoIncompativelException {
        if (this.saldo >= valor) {
            this.saldo -= valor;
        } else {
            //Instanciação de objeto da classe SaldoIncompativelException, uma exceção.
            //Caso saldo seja insuficiente para realização da operação.
            SaldoIncompativelException sie = new SaldoIncompativelException(this.saldo, this.numero);
            throw sie;
        }
    }
    public void transferir(double valor, Conta contaDestino) throws SaldoIncompativelException {
        this.sacar(valor);
        contaDestino.depositar(valor);
        System.out.println("O valor de " + valor + " foi retirado da conta "
                + this.toString() + " e foi depositado na conta " + contaDestino.toString());

    }

    public void imprimirInfoComuns(Cliente titular) {
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("numero: %s", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
        System.out.println(String.format("Cliente: %s", this.clint.getNome()));
    }

    @Override
    public String toString() {
        return "Conta: [" +
                "agencia: " + agencia +
                ", numero: " + numero +
                ", saldo: " + saldo + " reais " +
                ", cliente: " + clint.getNome() + "]";
    }

    //Método principal para teste.
    /*public static void main(String[] args) {

        //Instanciação de Cliente.

        //Instanciação de uma lista de contas usando ArrayList.
        List<Conta> contas = new ArrayList<Conta>();
        //Instanciação de duas contas utilizando o método add.
        contas.add(new Conta("125-04", 12500));
        contas.add(new Conta("912-87", 75500));

       /*File f = new File("meuArquivo.dat");
       ObjectOutputStream ous = null;
        try {
            FileOutputStream fos = new FileOutputStream(f);
           ous = new ObjectOutputStream(fos);

           ous.writeObject(contas);
            ous.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (ous != null) {
                try {
                    ous.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("contas escritas no arquivo");/*

        /*File f = new File("meuArquivo.dat");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            List<Conta> contas = (List<Conta>) ois.readObject();

            for (Conta conta : contas) {
                System.out.println(conta.getNumero());
                System.out.println(conta.getSaldo());
                System.out.println("=========");
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/


}



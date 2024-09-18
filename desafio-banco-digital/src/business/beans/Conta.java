package business.beans;

public class Conta implements IConta {

    //Toda instância de conta receberá como agência a agência padrão.
    private static final int AGENCIA_PADRAO = 1;

    private int agencia;
    private String numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(String numero, double saldoInicial, Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO; //Outra forma: this.agencia = agencia.
        this.numero = numero;
        this.saldo = saldoInicial;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public void sacar(double valor) {
        //Implementação da estrutura condicional para permissão de operação de saque.
        if(this.saldo - valor >= 0) {
            this.saldo -= valor;
            System.out.println("Operação de débito realizada com sucesso! Saldo disponível na conta: " + this.saldo + " reais.");
        } else System.out.println("Saldo insuficiente para este valor de saque. O valor máximo disponível para esta operação é: " +this.saldo + "reais.");
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Crédito realizado na conta " + this.numero
                + ", no valor de: " + valor + " reais.");
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public void imprimirInfoComuns(Cliente titular) {
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
        System.out.println(String.format("Cliente: %s", this.cliente.getNome()));
    }

    @Override
    public String toString() {
        return "Conta[" +
                "agencia " + agencia +
                ", numero " + numero +
                ", saldo " + saldo + " reais " +
                ", cliente " + cliente.getNome() + "]";
    }
}

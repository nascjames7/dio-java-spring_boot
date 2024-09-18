package business.beans;

public abstract class Conta implements IConta {

    //Toda instância de conta receberá como agência a agência padrão.
    private static final int AGENCIA_PADRAO = 1;
    public static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void sacar(double valor) {
        //Implementação da estrutura condicional para permissão de operação de saque.
        if(this.saldo - valor >= 0) {
            this.saldo -= valor;
        } else System.out.println("Saldo insuficiente para este valor de saque. O valor máximo disponível para esta operação é: " +this.saldo + "reais.");
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public void imprimirInfoComuns() {
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("business.beans.Conta: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    @Override
    public String toString() {
        return "business.beans.Conta{" +
                "agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }
}

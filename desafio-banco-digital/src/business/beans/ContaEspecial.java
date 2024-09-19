package business.beans;

public class ContaEspecial extends RegistroContas {
    private double valorLimite;
    private static final double TAXA_JUROS = 0.08;

    public ContaEspecial(String numero, double saldoInicial, RegistroClientes cliente) {
        super(numero, saldoInicial, cliente);
        //Definição do limite máximo.
        this.valorLimite = 10000.0;
    }

    public void aumentarLimite(double valor) {
        this.valorLimite += valor;
        System.out.println("O valor do limite máximo será de: " + valorLimite + " reais.");
    }

    public double getLimite() {
        return this.valorLimite;
    }

    public void sacar(double valor) {
        //Implementação da estrutura condicional para realização da operação de débito.
        if((this.saldo + this.valorLimite) - valor >= 0) {
            this.saldo -= valor;
            System.out.println("Operação de débito realizada com sucesso! Saldo disponível na conta: " + this.saldo + " reais.");
        } else System.out.println("Saldo insuficiente para este valor de saque. O valor máximo disponível para esta operação é: " +this.saldo + "reais.");
    }
    public void calcularJuros() {
        //Implementação da estrutura condicional que verifica se o saldo está negativo.
        if (this.saldo < 0) {
            //Calculando o valor absoluto dos juros.
            double juros = Math.abs(this.saldo * TAXA_JUROS);
            this.sacar(juros);
            System.out.println("Saldo atual da conta: " + (this.saldo - juros) + " reais.");
        }
    }

}


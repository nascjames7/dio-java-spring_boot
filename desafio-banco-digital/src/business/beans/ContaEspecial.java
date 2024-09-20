package business.beans;
import business.beans.Cliente;
import exceptions.SaldoIncompativelException;

public class ContaEspecial extends Conta {
    private double valorLimite;
    private static final double TAXA_JUROS = 0.08;

    public ContaEspecial(String numero, double saldoInicial, Cliente clint) {
        super(numero, saldoInicial, clint);
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

    public void sacar(double valor) throws SaldoIncompativelException {
        //Implementação da estrutura condicional para realização da operação de débito.
        if((this.saldo + this.valorLimite) - valor >= 0) {
            this.saldo -= valor;
            System.out.println("Operação de débito realizada com sucesso! Saldo disponível na conta: " + this.saldo + " reais.");
        } else {
            //Caso o saldo seja insuficiente, ocorre a geração de uma exceção.
            SaldoIncompativelException sie = new SaldoIncompativelException(this.saldo, this.getNumero());
            throw sie;
        }
    }
    public void calcularJuros() throws SaldoIncompativelException {
        //Implementação da estrutura condicional que verifica se o saldo está negativo.
        if (this.saldo < 0) {
            //Calculando o valor absoluto dos juros.
            double juros = Math.abs(this.saldo * TAXA_JUROS);
            this.sacar(juros);
            System.out.println("Saldo atual da conta: " + (this.saldo - juros) + " reais.");
        }

    }

    public void imprimirExtrato(Cliente titular) {
        System.out.println("Extrato conta especial: ");
        super.imprimirInfoComuns(titular);
    }

    public static void main(String[] args) {
        try {
            Cliente cli = new Cliente("Paulo", "15683848-89");
            Cliente cel = new Cliente("Ana", "12893848-89");
            Conta contae = new ContaEspecial("2134-5", 1000, cli);
            contae.depositar(500.0);
            contae.sacar(550.0);
            ((ContaEspecial) contae).aumentarLimite(100.0);
            contae.sacar(75.0);
            ((ContaEspecial) contae).calcularJuros();
            System.out.println(contae.getSaldo());

            Conta c = new Conta("1239-7", 55.0, cel);
            c.getClass();
        } catch (SaldoIncompativelException e) {
            System.out.println(e.getMessage());
        }
    }

}


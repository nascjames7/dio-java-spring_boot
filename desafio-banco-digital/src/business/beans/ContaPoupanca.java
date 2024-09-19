package business.beans;

public class ContaPoupanca extends Conta {

    //Construtor da classe ContaPoupanca.
    public ContaPoupanca(String numero, double saldo, Cliente clint) {
        super(numero, saldo, clint);
    }
    //Método que rende juros simples a uma determinada taxa.
    public void rendendoJuros(double taxa, int tempoMeses) {
        this.depositar(this.getSaldo()*taxa*tempoMeses);
        System.out.println("Aplicação de juros simples a taxa de " + taxa + "%, por " + tempoMeses + " meses foi realizada com sucesso!");
        System.out.println("O valor dos juros: " + this.getSaldo()*taxa*tempoMeses + " reais.");
        System.out.println("O montante da conta: " + (this.getSaldo()*(1 + taxa*tempoMeses)) + " reais.");
    }
    public void imprimirExtrato(Cliente titular) {
        System.out.println("Extrato conta poupança: ");
        super.imprimirInfoComuns(titular);
    }

}


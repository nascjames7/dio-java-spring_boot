package exceptions;

public class SaldoIncompativelException extends Exception{
    private String numero;
    private double saldo;

    public SaldoIncompativelException(double saldo, String numero) {
        super("O saldo da conta de número " + numero + " é insuficiente "
                + "para realizar a transação. Saldo atual: " + saldo);
        this.numero = numero;
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }
}

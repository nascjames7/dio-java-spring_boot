public class ContaPopanca extends Conta {
    public ContaPopanca(Cliente cliente) {
        super(cliente);
    }

    public void imprimirExtrato() {
        System.out.println("Extrato conta poupança: ");
        super.imprimirInfoComuns();
    }
}


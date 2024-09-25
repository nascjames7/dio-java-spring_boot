package business;

import business.beans.*;
import exceptions.SaldoIncompativelException;

public class Principal{
    public static void main(String[]args) throws SaldoIncompativelException {

        //Instanciação dos objeto dos tipos business.beans.Cliente, business.beans.ContaCorrente e ContaPoupanca usando Polimorfismo.
        Cliente c1 = new Cliente("James", "045684488-89");
        Cliente c2 = new Cliente("Peter", "045564818-15");

        Conta cc = new ContaCorrente("134-456",7500, c1);
        Conta poupanca = new ContaPoupanca("787-456",1500, c2);

        //Chamada do método setNome.
        c1.setNome("James Anderson");

        //Chamada de método depositar.
        cc.depositar(2000);
        poupanca.depositar(5000);

        //Chamada de método transferir.
        cc.transferir(500, poupanca);
        poupanca.transferir(2500, cc);

        //Chamada de método imprimirExtrato.
        ((ContaCorrente)cc).imprimirExtrato(c1);
        ((ContaPoupanca)poupanca).imprimirExtrato(c2);

        //Testando as funcionalidades da classe ContaEspecial.
        Conta special = new ContaEspecial("785-155", 5000, c1);
        special.depositar(2500.0);
        special.sacar(900.0);
        ((ContaEspecial) special).aumentarLimite(1500.0);
        special.sacar(3000.0);
        ((ContaEspecial) special).calcularJuros();
        System.out.println(special.getSaldo());



        }
}

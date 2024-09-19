package business;

import business.beans.*;

public class Principal{
    public static void main(String[]args){

        //Instanciação dos objeto dos tipos business.beans.Cliente, business.beans.ContaCorrente e ContaPoupanca usando Polimorfismo.
        RegistroClientes james = new RegistroClientes();
        RegistroClientes pedro = new RegistroClientes();

        RegistroContas cc = new ContaCorrente("134-456",7500, james);
        RegistroContas poupanca = new ContaPoupanca("787-456",1500, james);

        //Chamada do método setNome.
        james.setNome("James Anderson");

        //Chamada de método depositar.
        cc.depositar(2000);
        poupanca.depositar(5000);

        //Chamada de método transferir.
        cc.transferir(500, poupanca);
        poupanca.transferir(2500, cc);

        //Chamada de método imprimirExtrato.
        ((ContaCorrente)cc).imprimirExtrato(james);
        ((ContaPoupanca)poupanca).imprimirExtrato(james);

        //Testando as funcionalidades da classe ContaEspecial.
        RegistroContas special = new ContaEspecial("785-155", 5000, pedro);
        special.depositar(2500.0);
        special.sacar(900.0);
        ((ContaEspecial) special).aumentarLimite(1500.0);
        special.sacar(3000.0);
        ((ContaEspecial) special).calcularJuros();
        System.out.println(special.getSaldo());

        }
}

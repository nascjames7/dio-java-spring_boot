import business.beans.Cliente;
import business.beans.Conta;
import business.beans.ContaCorrente;
import business.beans.ContaPopanca;

public class Principal{
    public static void main(String[]args){

        //Instanciação dos objeto dos tipos business.beans.Cliente, business.beans.ContaCorrente e ContaPoupanca usando Polimorfismo.
        Cliente james = new Cliente();
        Conta cc = new ContaCorrente(james);
        Conta poupanca = new ContaPopanca(james);

        //Chamada do método setNome.
        james.setNome("James Anderson");

        //Chamada de método depositar.
        cc.depositar(2000);
        poupanca.depositar(5000);

        //Chamada de método transferir.
        cc.transferir(500, poupanca);
        poupanca.transferir(2500, cc);

        //Chamada de método imprimirExtrato.
        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
        }
}

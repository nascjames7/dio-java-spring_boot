
import java.util.Scanner;
public class ContaTerminal {

    public static void main(String[] args) {

        //Instância da classe Scanner;
        Scanner sc = new Scanner(System.in);

        //Solicitação e leitura dos dados da conta.
        System.out.println("Digite o número da conta bancaria: ");
        int numeroConta = sc.nextInt(); //variável inteira;
        System.out.println("Digite a identificação da agência da conta bancária: ");
        sc.nextLine();//Chamada vazia para não pular a sequência.
        String agenciaBancaria = sc.nextLine(); //variável texto;
        System.out.printf("Digite o nome do cliente da conta bancária " + numeroConta + ": ");
        String nomeCliente = sc.nextLine(); //variável texto;
        System.out.println("Digite o saldo da conta bancária: ");
        double saldoConta = sc.nextDouble(); //variável real;

        //Resposta final.
        System.out.printf("Ola " + nomeCliente + ". Obrigado por criar uma conta em nosso banco. ");
        System.out.printf("Sua agência é " + agenciaBancaria + ", conta número " + numeroConta + " e seu saldo de " + saldoConta + " já está disponível para saque.");

    }
}

/**
 *                              ## Controle de Fluxo - Desafio

        Vamos exercitar todo o conteúdo apresentado no módulo de Controle de Fluxo codificando o seguinte cenário.

        O sistema deverá receber dois parâmetros via terminal que representarão dois números inteiros, com estes dois números você deverá obter a quantidade de interações (for) e realizar a impressão no console (System.out.print) dos números incrementados, exemplo:

        * Se você passar os números 12 e 30, logo teremos uma interação (for) com 18 ocorrências para imprimir os números, exemplo: `"Imprimindo o número 1"`, `"Imprimindo o número 2"` e assim por diante.
        * Se o primeiro parâmetro for MAIOR que o segundo parâmetro, você deverá lançar a exceção customizada chamada de `ParametrosInvalidosException` com a segunda mensagem: "O segundo parâmetro deve ser maior que o primeiro"


        1. Crie o projeto `DesafioControleFluxo`
        2. Dentro do projeto, crie a classe `Contador.java` para realizar toda a codificação do nosso programa.
        3. Dentro do projeto, crie a classe `ParametrosInvalidosException` que representará a exceção de negócio no sistema.


 */
import java.util.Scanner;

public class Contador {

    public static void main(String[] args) {

        //Instanciação da classe Scanner.
        Scanner terminal = new Scanner(System.in);

        //Solicitação, declaração e leitura das variáveis.
        System.out.println("Digite o primeiro parâmetro: ");
        int parametroUm = terminal.nextInt();
        //Linha vazia.
        terminal.nextLine();
        System.out.println("Digite o segundo parâmetro: ");
        int parametroDois = terminal.nextInt();

        //Implementação do tratamento da exceção.
        try {
            //Chamando do método contendo a lógica de contagem.
            contar(parametroUm, parametroDois);

        }catch (ParametrosInvalidosException exception) {
            System.out.println("O segundo parâmetro deve ser maior que o primeiro.");
            //Mostra a pilha que explicita a exceção.
            exception.printStackTrace();
        }

    }
    //Método estático que trata a exceção se necessário.
    static void contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException {

        //Definição da variável que calcula a diferença entre os parâmetros.
        int contagem = parametroDois - parametroUm;
        //Definição da varíavel de controle booleana.
        boolean parametroValidos = false;

        //Implementação do fluxo condicional para verificar se parametroUm é maior que parametroDois e lançar a exceção.
        if(parametroUm < parametroDois) {
            //Alteração da variável booleana.
            parametroValidos = true;
            System.out.println("Os parâmetros foram validados!");

        }else {
            //Mensaegm de aviso.
            System.out.println("Os parâmtros são inválidos!");
            //Lançamento/chamada de tratamento de exceção.
            throw new ParametrosInvalidosException();
        }

        //Implementação do laço para imprimir os números com base na variável contagem.
        for (int number = 0; number < contagem; number++) {

            System.out.println("Imprimindo o número " + (number + 1) + ".");
        }
    }
}
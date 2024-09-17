/**
 * Você foi contratado para desenvolver um sistema que calcule a velocidade média de conexão de internet de um
 * cliente durante um período. O sistema deve ler os registros recebidos como entrada, processar os dados e
 * calcular a velocidade média de conexão em megabits por segundo (Mbps) ao longo do turno.
 *
 * Entrada
 * A entrada é uma string contendo uma lista de valores representando a velocidade de conexão em megabits
 * por segundo (Mbps), separados por vírgulas.
 *
 * Saída
 * A saída do programa deve ser a velocidade média de conexão em Mbps.
 * O sistema deve somar todos os valores da lista de entrada, calcular a média dividindo o total pelo número de
 * registros, e exibir o resultado.
 */

import java.util.Scanner;

public class VelocidadeMedia {

    // Função para calcular a velocidade média de conexão de internet
    public static double calcularVelocidadeMedia(String[] velocidades) {
        //Declaração da variável total.
        int total = 0;
        int soma = 0;

        //Realiza a soma ds velocidades registradas.
        for(int contador = 0; contador < velocidades.length; contador++) {
            //Conversão das Strings em inteiros.
            soma += Integer.parseInt(velocidades[contador]);
        }
        //Cálculo da mádia.
        total = (soma/velocidades.length);

        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitando ao usuário a lista de velocidades de conexão registradas a cada hora
        String input = scanner.nextLine();

        // Convertendo a entrada em uma lista de strings
        String[] velocidades = input.split(",");

        // Calculando a velocidade média de conexão
        double velocidadeMedia = calcularVelocidadeMedia(velocidades);

        // Exibindo a velocidade média de conexão
        System.out.println((int)velocidadeMedia + " Mbps");

        scanner.close();
    }
}
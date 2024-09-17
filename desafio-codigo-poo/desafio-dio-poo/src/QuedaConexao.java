/**
 * Descrição
 *
 * Implemente um programa que verifique se houve queda de conexão em um dia.
 * A queda de conexão é definida como qualquer velocidade registrada igual a 0 Mbps.
 * O sistema deve ler os registros de velocidade de conexão, processar os dados e determinar se ocorreu queda
 * de conexão durante o dia.
 *
 * Entrada
 * A entrada deve receber uma lista de valores inteiros representando a velocidade de conexão em Mbps separados
 * por vírgulas.
 *
 * Saída
 * Deverá retornar "Queda de Conexao" se houver pelo menos uma velocidade registrada igual a 0 Mbps, e "Sem Quedas" caso contrário.
 */

import java.util.Scanner;

class QuedaConexao {
    // TODO: Preencha a função para verificar queda de conexão
    public static String verificarQuedaConexao(String[] velocidades) {

        //Definição das varíaveis.
        String resultado = "";
        int contador= 0;

        //Implementação do laço para verificação da conexao.
        for(int i = 0; i < velocidades.length; i++) {

            //System.out.println("Entrei no laço.");

            //Conversão das Strings em inteiros e defibição da variável velocidade.
            int velocidade = Integer.parseInt(velocidades[i]);

            //Implementação da estrutura condicional que verificao valor da velocidade.
            if(velocidade == 0) {
                //System.out.println("Achei um zero!");
                contador++;
            }
        }

        //Implementação da estrutura condicional para estabelecer o resultado.
        if(contador == 0) {
            resultado  = "Sem Quedas";
        }else resultado = "Queda de Conexao";

        //System.out.println("O contador eh: "+ contador);
        return resultado;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitando ao usuário a lista de velocidades de conexão registradas a cada hora
        String input = scanner.nextLine();

        // Convertendo a entrada em uma lista de strings
        String[] velocidades = input.split(",");

        // Verificando se houve queda de conexão
        String resultado = verificarQuedaConexao(velocidades);

        // Exibindo o resultado da verificação
        System.out.println(resultado);

        scanner.close();
    }


}

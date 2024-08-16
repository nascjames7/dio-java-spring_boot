/**
 * Princípios Básicos
 *
 *Descrição: Implemente um sistema que verifique se um cliente de uma empresa de
 *telecomunicações contratou um combo completo de serviços. Um combo completo inclui
 *os três serviços principais oferecidos pela empresa: telefonia móvel, banda larga e
 *TV por assinatura. O sistema deve ler uma lista de serviços contratados pelo cliente
 *e determinar se todos os serviços necessários estão incluídos. Caso todos os três
 *serviços estejam presentes, o sistema deve retornar "Combo Completo". Se faltar
 *qualquer um dos serviços, o sistema deve retornar "Combo Incompleto".
 *
 *Entrada: A entrada consiste em uma string contendo uma lista de serviços contratados
 *pelo cliente, separados por vírgula. Os serviços possíveis são "movel" para telefonia
 *móvel, "banda larga" para serviços de internet e "tv" para TV por assinatura.
 *
 *Saída: A saída do programa deve ser uma única linha contendo:
 *
 * "Combo Completo" se o cliente contratou todos os três serviços.
 * "Combo Incompleto" caso contrário.
 *
 */


import java.util.Scanner;

public class PrincipiosBasicos {

    //Função para verificar se o cliente contratou um combo completo.
    public static String verificarComboCompleto(String[] servicosContratados) {
        //Variáveis booleanas para verificar a contratação de cada serviço
        boolean movelContratado = false;
        boolean bandaLargaContratada = false;
        boolean tvContratada = false;

        //Definição de contador para verificar a exitência dos serviços contratados.
        int contador = 0;
        //Definição de Array com todos os serviços que podem ser contratados.
        String [] pacoteCompleto = {"movel", "banda larga", "tv"};

        //Implementação do laço para contagem dos serviços contratados.
        for (String servico : servicosContratados) {

            //Implementação do fluxo condicional para contagem dos serviços contratados.
            if(servico.equals(pacoteCompleto[0]) || servico.equals(pacoteCompleto[1])
            || servico.equals(pacoteCompleto[2])) {

                //Incremento do contador.
                contador++;
            }
        }

        //Implementação do fluxo condicional para retornar resposta final.
        if (contador == 3) {
            return "Combo Completo";
        } else {
            return "Combo Incompleto";
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Solicitando ao usuário a lista de serviços contratados.
        String input = scanner.nextLine();

        //Convertendo a entrada em uma lista de strings.
        String[] servicosContratados = input.split(",");

        //Verificando se o cliente contratou um combo completo.
        String resultado = verificarComboCompleto(servicosContratados);

        //Exibindo o resultado.
        System.out.println(resultado);

        //Fechando o scanner.
        scanner.close();
    }
}

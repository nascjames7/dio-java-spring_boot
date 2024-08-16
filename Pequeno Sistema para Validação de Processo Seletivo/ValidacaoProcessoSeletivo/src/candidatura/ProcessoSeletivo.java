/**
 * Programa de validação de processo seletivo que obedece as seguintes regras de negócio:
 * 1-Apenas 5 candidatos podem ser selecionados para a entrevista.
 * 2-Os candidatos selecionados para a entrevista precisam pretender salário inferior ao salário base.
 * 3-O salário base é 2000.0 reais.
 * 4-Imprimir a lista dos candiadtos selecionados para que o RH possa entrar em contao com eles.
 * 5-O RH deve fazer 3 tentativas de contato com o candidato através de ligação telefônica e imprimir a situação.
 */
package candidatura;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class ProcessoSeletivo {

    //Definição do salário base que não varia.
    static final double SALARIO_BASE = 2000.0;
    public static void main(String[] args) {
        //Chamada do  método selecaoCandidatos().
        selecaoCandidatos();

    }

    //Método estático (pois se encontra na classe principal) que seleciona os candidatos.
    static void selecaoCandidatos() {
        //Defição das variáveis.
        //Definição do Array de candidatos.
        String candidatos[] = {"Felipe", "Márcia", "Júlia", "Paulo", "Augusto", "Mônica", "Fabrício", "Mirela", "Daniela", "João"};
        //Definição do Array de candidatos aprovados na seleção com 10 posições possivéis do tipo String.
        String candidatosAprovados[] = new String[10];
        //Definição da variável que guarda o número de candidatos selecionados durante toda a seleção.
        int candidatosSelecionados = 0;
        //Definição da variável que indica a posição do candidato a ser analisado no  Array de candidatos.
        int candidatoAtual = 0;
        //Definição da variável que indica a posição do candidato a ser alocado no  Array de candidatos aprovados.
        int indiceCandidatoAprovado = 0;

        //Implementação do laço para contagem dos candidatos selecionados para a entrevista.
        //O laço para quando o número de candidatos selecionados atinge o valor 5 ou quando finaliza a lista de candidatos no Array.
        while((candidatosSelecionados < 5) && (candidatoAtual < candidatos.length)) {
            //Definição da variável que guarda o nome do candidato que está sendo analisado no momento.
            String candidato = candidatos[candidatoAtual];
            //Definição da variável que guarda o salário pretendido, passando a chamar o método: valorPretendido().
            double salarioPretendido = valorPretendido();
            //Impressão para simples acompanhamento.
            System.out.println("O candidato " + candidato + " solicitou o salário de "+ salarioPretendido + ".");

            //Implementação do fluxo condicional para incremento do número de candidatos selecionados.
            if(salarioPretendido < SALARIO_BASE) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
                //Preenchimento do Array de candidatos aprovados.
                candidatosAprovados[indiceCandidatoAprovado] = candidato;
                //Incremento do número de candidatos selecionados.
                candidatosSelecionados++;
            }else {
                System.out.println("O candidato " + candidato + " não foi selecionado para a vaga");
                //Preenchimento do Array de candidatos aprovados.
                candidatosAprovados[indiceCandidatoAprovado] = "REPROVADO";
            }

            //Incremento da posição no Array de candidatos.
            candidatoAtual++;
            //Incremento do índice de candidatosAprovados.
            indiceCandidatoAprovado++;
        }
        //Impressão da lista de candidatos selecionados.
        //Definição de Array para utilização do método equals.
        String candidatosReprovados[] = new String [10];
        int contadorAprovados = 0;
        //Definição de Array para os candidatos aprovados que receberão as ligações do RH.
        String apenasAprovados[] = new String [candidatosSelecionados];

        //Implementação do laço para preenchimento do vetor de String candidatosReprovados.
        for (int indice = 0; indice < candidatosReprovados.length; indice++) {
            candidatosReprovados[indice] = "REPROVADO";
        }
        System.out.println("\nImprimindo a lista de candidatos selecionados com o índice:\n");

        //Implementação do laço para impressão da lista de candidatos selecionados.
        for (int indice = 0; indice < candidatosAprovados.length; indice++) {

            //Implementação do fluxo condicional para impressão dos candidatos aprovados.
            if((candidatosReprovados[indice]).equals(candidatosAprovados[indice])) {
                //Impressão apenas dos candidatos aprovados.
            }else {
                System.out.println("O candidato de número " + (indice + 1) + " é o " + candidatosAprovados[indice]);
                //Implementação do vetor que possui apenas os candidatos aprovados.
                apenasAprovados[contadorAprovados] = candidatosAprovados[indice];
                //Incremento do contador.
                contadorAprovados++;
            }
        }

        //Implementação do laço para verificar se o candidato selecionado atendeu as tentativas de contato.
        for(String candidato: apenasAprovados) {
            //Chamada do método entrandoEmContato(candidato);
            entrandoEmContato(candidato);
        }
    }

    //Método estático que calcula o valor do salário pretendido por determinado candidato.
    static double valorPretendido () {

        //Retorna um valor real calculado de forma aleatória usando [ThreadLocalRandom.current().nextDouble].
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }

    //Método estático que analisa os candidatos em relação ao salário pretendido.
    static void analisarCandidato (double salarioPretendido) {

        //Implementação de fluxo condicional para análise dos candidatos.
        //Caso pretenção seja menor que o salário base.
        if(SALARIO_BASE > salarioPretendido) {
            System.out.println("Ligar para o candidato.");
        //Caso pretenção seja igual ao salário base.
        }else if(SALARIO_BASE == salarioPretendido) {
            System.out.println("Ligar para o candidato com uma contra proposta.");
        //Caso pretenção seja maior que o salário base.
        }else System.out.println("Aguardando o resultado dos demais candidatos.");
    }

    //Método auxiliar que verifica se o candidato atendeu o telefone em alguma das 3 tentavas de contato.
    static boolean atender() {

        //Retorna true se atendeu e false caso contrário.
        return new Random().nextInt(3)==1;
    }
    //Método estático que retorna o número de tentativas ao se entrar em contato com um candidato.
    static void entrandoEmContato(String candidato) {

        //Declaração da variável que contabiliza o número de tentativas.
        int tentativasRealizadas = 1;
        //Declaração de variáveis de controle booleanas.
        boolean continuarTentando = true;
        boolean atendeu = false;

        //Implementação do laço.
        do {
            //Chamada do método atender.
            atendeu = atender();
            //A variável abaixo assume o valor oposto da variável acima, para que o laço finalize.
            continuarTentando = !atendeu;

            //Implementação do fluxo condicional para contabilizar as tentativas realizadas.
            if(continuarTentando) {
                //Incremento do contador.
                tentativasRealizadas++;
            }else System.out.println("Contato realizado com sucesso!");
        //Condição de parada.
        }while(continuarTentando && tentativasRealizadas < 3);

        //Implementação do fluxo condicional para imprimir o número de tentativas ao entrar em contato com os aprovados na seleção.
        if(atendeu) {
            System.out.println("Conseguimos contato com o candidato " + candidato + " na " + tentativasRealizadas + "º tentativa.");
        }else System.out.println("Não conseguimos contato com o candidato " + candidato + "; número máximo de " + tentativasRealizadas + " tentativas.");
    }
}

package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {
    private List<Tarefa> tarefaList;

    /**Construtor instancia um ArrayList vazio cada vez
     * que eu instanciar uma lista de tarefas.
     */
    public ListaTarefa() {
        this.tarefaList = new ArrayList<>();
    }
    
    //Método que adiciona uma tarefa.
    public void adicionarTarefa(String descricao) {
        tarefaList.add(new Tarefa(descricao));
    }

    //Método que remove uma tarefa.
    public void removerTarefa(String descricao) {

        //Instanciação de uma lista de tarefas.
        List<Tarefa> tarefasParaRemover = new ArrayList<>();

        //Implementação do laço para detectar a tarefa a ser removida.
        for(Tarefa tarefa : tarefaList) {

            //Implementação da estrutura condicional para verficação da tarefa procurada.
            if(tarefa.getDescricao().equalsIgnoreCase(descricao)) {

                //Adicão da tarefa a ser removida para a lista tarefasParaRemover.
                tarefasParaRemover.add(tarefa);
            }
        }
        //Remoção da tarefa da lista tarefaList.
        tarefaList.removeAll(tarefasParaRemover);
    }

    //Método que retorna o número total de tarefas.
    public int obterNumeroTotalTarefas() {
        //Retorna o tamanho da lista.
        return tarefaList.size();
    }

    //Método que imprime a lista de tarefas a qualquer momento.
    public void obterDescricaoTarefas() {
        //Imprime a lista.
        System.out.println(tarefaList);
    }

    //Método que testa as impementações realizadas.
    public static void main(String[] args) {

        //Instanciação.
        ListaTarefa listaTarefa = new ListaTarefa();
        //Impressao do numero total de tarefas.
        System.out.println("O número total de elementos da lista é: " + listaTarefa.obterNumeroTotalTarefas());
        //Adicionando tarefa a lista vazia.
        listaTarefa.adicionarTarefa("Tarefa01");
        System.out.println("O número total de elementos da lista é: " + listaTarefa.obterNumeroTotalTarefas());
        listaTarefa.adicionarTarefa("Tarefa01");
        System.out.println("O número total de elementos da lista é: " + listaTarefa.obterNumeroTotalTarefas());
        listaTarefa.adicionarTarefa("Tarefa02");
        System.out.println("O número total de elementos da lista é: " + listaTarefa.obterNumeroTotalTarefas());
        //Remoção da Tarefa01.
        //listaTarefa.removerTarefa("Tarefa01");
        System.out.println("O número total de elementos da lista é: " + listaTarefa.obterNumeroTotalTarefas());
        //Obtenção da lista de descrições.
        listaTarefa.obterDescricaoTarefas();

    }
}

package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {

    private List<Item> itemList;
    /**Construtor instancia um ArrayList vazio cada vez
     * que eu instanciar uma lista de tarefas.
     */
    public CarrinhoCompras() {
        this.itemList = new ArrayList<>();
    }
    //Método que adiciona um item.
    public void adicionarItem(String nome, double preco, int quantidade) {
        itemList.add(new Item(nome, preco, quantidade));
    }

    //Método que remove uma item.
    public void removerItem(String nome, double preco, int quantidade) {

        //Instanciação de uma lista de itens.
        List<Item> itensParaRemover = new ArrayList<>();

        //Implementação do laço para detectar o item a ser removido.
        for(Item item : itemList) {

            //Implementação da estrutura condicional para verficação do item procurado.
            if((item.getNome().equalsIgnoreCase(nome)) && (item.getPreco() == preco) && (item.getQuantidade() == quantidade)){

                //Adicão do item a ser removido para a lista itensParaRemover.
                itensParaRemover.add(item);
            }
        }
        //Remoção do item da lista itemList.
        itemList.removeAll(itensParaRemover);
    }

    //Método que retorna o número total de itens.
    public int obterNumeroTotalItens() {
        //Retorna o tamanho da lista.
        return itemList.size();
    }

    //Método que imprime a lista de itens a qualquer momento.
    public void obterDescricaoItens() {
        //Imprime a lista.
        System.out.println(itemList);
    }

    //Método que testa as impementações realizadas.
    public static void main(String[] args) {

        //Instanciação.
        CarrinhoCompras carrinhoCompras = new CarrinhoCompras();
        //Impressao do numero total de tarefas.
        System.out.println("O número total de elementos da lista é: " + carrinhoCompras.obterNumeroTotalItens());
        //Adicionando tarefa a lista vazia.
        carrinhoCompras.adicionarItem("calculadora", 56.75, 10);
        System.out.println("O número total de elementos da lista é: " + carrinhoCompras.obterNumeroTotalItens());
        carrinhoCompras.adicionarItem("computador", 4556.75, 20);
        System.out.println("O número total de elementos da lista é: " + carrinhoCompras.obterNumeroTotalItens());
        carrinhoCompras.adicionarItem("carro", 56000.75, 25);
        System.out.println("O número total de elementos da lista é: " + carrinhoCompras.obterNumeroTotalItens());
        //Remoção da Item02.
        carrinhoCompras.removerItem("computador", 4556.75, 20);
        System.out.println("O número total de elementos da lista é: " + carrinhoCompras.obterNumeroTotalItens());
        //Obtenção da lista de descrições.
        carrinhoCompras.obterDescricaoItens();

    }
}

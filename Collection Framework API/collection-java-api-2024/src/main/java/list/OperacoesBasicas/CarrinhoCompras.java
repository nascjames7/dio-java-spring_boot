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

    //Método que retorna o valor total de itens do carrinho de compras.
    public double calcularValorTotal() {
        //Declaração da variável valorTotal.
        double valorTotal = 0.0;
        //Implementação do laço para o cálculo do valor total.
        for(Item item: itemList) {
            valorTotal += (item.getPreco()*item.getQuantidade());
        }
        return valorTotal;
    }

    //Método que imprime a lista de itens a qualquer momento.
    public void exibirItens() {
        //Imprime a lista.
        System.out.println(itemList);
    }

    //Método que testa as impementações realizadas.
    public static void main(String[] args) {

        //Instanciação.
        CarrinhoCompras carrinhoCompras = new CarrinhoCompras();
        //Impressao do numero total de tarefas.
        System.out.println("O valor total de elementos da lista é: " + carrinhoCompras.calcularValorTotal());
        //Adicionando tarefa a lista vazia.
        carrinhoCompras.adicionarItem("calculadora", 56.75, 10);
        System.out.println("O valor total de elementos da lista é: " + carrinhoCompras.calcularValorTotal());
        carrinhoCompras.adicionarItem("computador", 4556.75, 20);
        System.out.println("O valor total de elementos da lista é: " + carrinhoCompras.calcularValorTotal());
        carrinhoCompras.adicionarItem("carro", 56000.75, 25);
        System.out.println("O valor total de elementos da lista é: " + carrinhoCompras.calcularValorTotal());
        //Remoção da Item02.
        carrinhoCompras.removerItem("computador", 4556.75, 20);
        System.out.println("O valor total de elementos da lista é: " + carrinhoCompras.calcularValorTotal());
        //Obtenção da lista de descrições.
        carrinhoCompras.exibirItens();

    }
}

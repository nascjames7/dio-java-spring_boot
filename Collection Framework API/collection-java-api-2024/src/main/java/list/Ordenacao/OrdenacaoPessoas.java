package main.java.list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoas {
    private List<Pessoa> pessoaList;

    public OrdenacaoPessoas() {
        this.pessoaList = new ArrayList<>();
    }

    //Método que adiciona pessoa.
    public void adicionarPessoa(String nome, int idade, double altura) {
        pessoaList.add(new Pessoa(nome, idade, altura));
    }

    //Método que ordena por idade.
    public List<Pessoa> ordenarPorIdade() {

        //Instanciação da lista.
        //Duplica a lista para que seja ordenada.
        List<Pessoa> pessoaPorIdade = new ArrayList<>(pessoaList);

        //Chamada do método de ordenação: Collections.sort
        Collections.sort(pessoaPorIdade);
        return pessoaPorIdade;
    }

    public List<Pessoa> ordenarPorAltura() {
        //Instanciação da lista.
        //Duplica a lista para que seja ordenada.
        List<Pessoa> pessoaPorAltura = new ArrayList<>(pessoaList);
        //A coleção (lista de pesoas) sera ordenada por altura pela Comparator.
        Collections.sort(pessoaPorAltura, new ComparatorPorAltura());
        return pessoaPorAltura;
    }
    //Método principal para testes.
    public static void main(String[] args) {
        //Instanciação da classe OrdenacaoPessoa.
        OrdenacaoPessoas op = new OrdenacaoPessoas();

        //Adição de objetos do tipo Pessoa.
        op.adicionarPessoa("Alan", 15, 1.78);
        op.adicionarPessoa("Allisson", 51, 1.65);
        op.adicionarPessoa("Davi", 90, 1.54);
        op.adicionarPessoa("Leila", 10, 1.48);
        op.adicionarPessoa("Felipe", 25, 1.89);
        op.adicionarPessoa("Gabriela", 70, 1.70);
        op.adicionarPessoa("Josias", 42, 1.45);

        System.out.println(op.pessoaList);
        System.out.println("-----------------------------------");
        System.out.println(op.ordenarPorAltura());
        System.out.println("-----------------------------------");
        System.out.println(op.ordenarPorIdade());
    }




}

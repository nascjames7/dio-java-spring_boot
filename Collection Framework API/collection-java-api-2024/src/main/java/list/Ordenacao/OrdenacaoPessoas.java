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
    public List<Pessoa> ordenarPorIdade(int idade) {

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
        Collections.sort(pessoaPorAltura, new ComparatorPorAltura());
        return pessoaPorAltura;
    }

}

package main.java.list.Ordenacao;

import java.util.Comparator;

public class Pessoa implements Comparable<Pessoa> {
    private String nome;
    private int idade;
    private double altura;

    public Pessoa(String nome, int idade, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public String toString() {
        return "Pesssoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", altura=" + altura +
                '}';
    }


    //Método da interface Comparable qu compara as idades.
    @Override
    public int compareTo(Pessoa p) {
        return Integer.compare(idade, p.getIdade());
    }
}

//Implementação da Classe ComparatorPorAltura
class ComparatorPorAltura implements Comparator<Pessoa> {
    @Override
    //Chamada do método que compara a altura de 2 pessoas.
    public int compare(Pessoa p1, Pessoa p2) {
        return Double.compare(p1.getAltura(), p2.getAltura());
    }
}




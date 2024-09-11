package main.java.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> livroList;

    public CatalogoLivros() {
        this.livroList = new ArrayList<>();
    }

    //Método que adiciona uma livro.
    public void adicionarLivro(String titulo, String autor, int ano) {
        //Adiciona o livro a lista.
        livroList.add(new Livro(titulo, autor, ano));

    }

    //Encontra livros de um determinado autor.
    public List<Livro> pesquisarPorAutor(String autor) {
        /**Implementação da estrutura condicional para verificar
         * se a lista está vazia.
         */
        //Instanciação de uma lista.
        List<Livro> livrosPorAutor = new ArrayList<>();
        //Verifica se a lista está vazia.
        if(!livroList.isEmpty()) {
            //Implementação do laço para localizar livro.
            for(Livro livro : livroList) {
                //Implementação da estrutura condicional de comparação.
                if(livro.getAutor().equalsIgnoreCase(autor)) {
                    //Adiciona o livro caso seja encontrado.
                    livrosPorAutor.add(livro);
                }
            }
        }
        //Retorna a lista de livros com o mesmo autor.
        return livrosPorAutor;
    }

    //Encontra livros dentro de um determinado intrevalo de anos.
    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {
        //Instanciação de uma lista.
        List<Livro> livrosPorIntervaloAnos = new ArrayList<>();
        //Verifica se a lista está vazia.
        if(!livroList.isEmpty()) {
            //Implementação do laço para localizar livro.
            for(Livro livro : livroList) {
                //Implementação da estrutura condicional de comparação.
                if(livro.getAno() >= anoInicial && livro.getAno() <= anoFinal) {
                    //Adiciona o livro caso seja encontrado.
                    livrosPorIntervaloAnos.add(livro);
                }
            }
        }
        //retorna livros dentro d o intervalo de anos estipulado.
        return livrosPorIntervaloAnos;
    }

    //Encontra livros com um determinado titulo.
    public Livro pesquisarPorTitulo(String titulo) {
        /**Implementação da estrutura condicional para verificar
         * se a lista está vazia.
         */
        //Instanciação de um livro.
        Livro livroPorTitulo = null;
        //Verifica se a lista está vazia.
        if(!livroList.isEmpty()) {
            //Implementação do laço para localizar livro.
            for(Livro livro : livroList) {
                //Implementação da estrutura condicional de comparação.
                if(livro.getTitulo().equalsIgnoreCase(titulo)) {
                    //Adiciona o livro caso seja encontrado.
                    livroPorTitulo = livro;
                    //Saída do laço.
                    break;
                }
            }
        }
        //Retorna o livro com o título especificado.
        return livroPorTitulo;
    }
    //Método principal que verifica a execução dos métodos implementados.
    public static void main(String[] args) {

        //Intanciação de lista de () livros
        CatalogoLivros catalogoLivros = new CatalogoLivros();

        //Adicionando livros.
        catalogoLivros.adicionarLivro("Biblia de Estudos", "King James", 1850);
        catalogoLivros.adicionarLivro("Coração de Tinta", "Harrison Ford", 1999);
        catalogoLivros.adicionarLivro("Meu Deus e Eu", "Oprah Winsley", 2010);
        catalogoLivros.adicionarLivro("Coração de Tinta", "Harrison Ford", 1999);

        //Impressao de listas de pesquisa.
        System.out.println(catalogoLivros.pesquisarPorAutor("Oprah Winsley"));
        System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(1900, 2012));
        System.out.println(catalogoLivros.pesquisarPorTitulo("Coração de Tinta"));    }
}



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
    public List<Livro> pesquisarPorInte(String autor) {
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

}

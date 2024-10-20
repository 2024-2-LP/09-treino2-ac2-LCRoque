package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;
import school.sptech.exception.LivroNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nome;
    private List<Livro> livros;

    public Biblioteca(String nome) {
        this.nome = nome;
        this.livros = new ArrayList<>();
    }

    public Biblioteca() {

    }

    public void adicionarLivro(Livro livro){
            if(livro == null || livro.getTitulo() == null || livro.getTitulo().isBlank() || livro.getAutor() == null || livro.getAutor().isBlank() || livro.getDataPublicacao() == null){
                throw new ArgumentoInvalidoException("Livro inválido");
            }
            livros.add(livro);
    }

    public void removerLivroPorTitulo(String titulo){
        if(titulo == null || titulo.isBlank()){
            throw new ArgumentoInvalidoException("Livro Inválido");
        }
            for (int i = 0; i < livros.size(); i++) {
                Livro livroAtual = livros.get(i);

                if(livroAtual.getTitulo().equalsIgnoreCase(titulo)){
                    livros.remove(livroAtual);
                    return;
                }
            }
        throw new LivroNaoEncontradoException("Livro não encontrado");
        }

    public Livro buscarLivroPorTitulo(String titulo){
        if(titulo == null || titulo.isBlank()){
            throw new ArgumentoInvalidoException("Titulo inválido");
        }
        for (int i = 0; i < livros.size(); i++) {
            Livro livroAtual = livros.get(i);

            if(livroAtual.getTitulo().equalsIgnoreCase(titulo)){
                return livroAtual;
            }
        }
        throw new LivroNaoEncontradoException("Livro não encontrado");
    }

    public Integer contarLivros(){
        return livros.size();
    }

    public List<Livro> obterLivrosAteAno(Integer ano){
        List<Livro> listaLivrosAno = new ArrayList<>();

        if (ano == null || ano < 0) {
            throw new ArgumentoInvalidoException("Ano inválido.");
        }

        for (int i = 0; i < livros.size(); i++) {
            Livro livroAtual = livros.get(i);
            if(livroAtual.getDataPublicacao().getYear() <= ano){
                listaLivrosAno.add(livroAtual);
            }
        }
        return listaLivrosAno;
    }

    public List<Livro> retornarTopCincoLivros() {
        List<Livro> listaCincoLivros = new ArrayList<>();

        if (livros.isEmpty()) {
            return listaCincoLivros;
        }

        for (int i = 0; i < livros.size(); i++) {
            Livro livroAtual = livros.get(i);

            listaCincoLivros.add(livroAtual);
        }

        listaCincoLivros.sort((livro1, livro2) -> Double.compare(livro2.calcularMediaAvaliacoes(), livro1.calcularMediaAvaliacoes()));

        if (listaCincoLivros.size() > 5) {
            return listaCincoLivros.subList(0, 5);
        }
        return listaCincoLivros;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

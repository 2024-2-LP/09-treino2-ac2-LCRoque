package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livro {
        private String autor;
        private String titulo;
        private LocalDate dataPublicacao;
        private List<Avaliacao> avaliacoes;

        public Livro() {
                this.avaliacoes = new ArrayList<>();
        }

        public Livro(String autor, String titulo, LocalDate dataPublicacao) {
                this.autor = autor;
                this.titulo = titulo;
                this.dataPublicacao = dataPublicacao;
                this.avaliacoes = new ArrayList<>();
        }

        public String getAutor() {
                return autor;
        }

        public void setAutor(String autor) {
                this.autor = autor;
        }

        public String getTitulo() {
                return titulo;
        }

        public void setTitulo(String titulo) {
                this.titulo = titulo;
        }

        public LocalDate getDataPublicacao() {
                return dataPublicacao;
        }

        public void setDataPublicacao(LocalDate dataPublicacao) {
                this.dataPublicacao = dataPublicacao;
        }

        public List<Avaliacao> getAvaliacoes() {
                return avaliacoes;
        }

        public void setAvaliacoes(List<Avaliacao> avaliacoes) {
                this.avaliacoes = avaliacoes;
        }

        public void adicionarAvaliacao(String descricao, Double qtdEstrelas){
                if(descricao == null || descricao.isBlank() || qtdEstrelas == null ||qtdEstrelas < 0 || qtdEstrelas > 5){
                        throw new ArgumentoInvalidoException("Avaliacao inválida");
                } else {
                        Avaliacao avaliacao = new Avaliacao(descricao, qtdEstrelas);
                        avaliacoes.add(avaliacao);
                }
        }

        public Double calcularMediaAvaliacoes(){
                if(avaliacoes.isEmpty()){
                        return 0.0;
                }
                Double somar = 0.0;
                for (int i = 0; i < avaliacoes.size(); i++) {
                        Avaliacao avaliacaoAtual = avaliacoes.get(i);
                        somar += avaliacaoAtual.getQtdEstrelas();
                }

                return somar/avaliacoes.size();
        }

        @Override
        public String toString() {
                return "Livro{" +
                        "autor='" + autor + '\'' +
                        ", titulo='" + titulo + '\'' +
                        ", dataPublicacao=" + dataPublicacao +
                        ", avaliacoes=" + avaliacoes +
                        '}';
        }
}

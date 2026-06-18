public class Livro {

    private int codigo;
    private String titulo;
    private String autor;
    private int ano;

    public Livro(int codigo, String titulo, String autor, int ano) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    @Override
    public String toString() {
        return codigo + " - " + titulo + " | " + autor + " | " + ano;

    }
}
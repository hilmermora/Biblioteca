package model;


 //Representa um livro no sistema BookTracker.

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int ano;
    private String genero;
    private String status;

    // Construtores,
    public Livro() {}

    public Livro(int id, String titulo, String autor, int ano, String genero, String status) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.genero = genero;
        this.status = status;
    }

    // GETTERS
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAno() { return ano; }
    public String getGenero() { return genero; }
    public String getStatus() { return status; }

    //SETTERS

    public void setStatus(String status) { this.status = status; }
    public void setId(int id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAno(int ano) { this.ano = ano; }
    public void setGenero(String genero) { this.genero = genero; }

}

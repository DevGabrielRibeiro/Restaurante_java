package model;

public class Garcom {
    private String nome;
    private int codigo;
    private String telefone;
    private String email;

    // Construtores, getters e setters
    public Garcom(String nome, int codigo, String telefone, String email) {
        this.nome = nome;
        this.codigo = codigo;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

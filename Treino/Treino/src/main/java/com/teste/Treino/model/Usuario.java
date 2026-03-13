package com.teste.Treino.model;

public class Usuario {

    private long id;
    private String nome;
    private String email;
    private int idade;
    private double peso;
    private double altura;

    public Usuario(long id, String nome, String email, int idade, double peso, double altura) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
    }

    public Usuario(String nome, String email, int idade, double peso, double altura) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}

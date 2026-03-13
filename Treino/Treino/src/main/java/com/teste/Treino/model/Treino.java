package com.teste.Treino.model;

public class Treino {

    private long id;
    private String tipo;
    private String descricao;

    public Treino(long id, String tipo, String descricao) {
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public Treino(String tipo, String descricao) {
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

package com.teste.Treino.model;

public class Dieta {

    private long id;
    private String nomeDieta;
    private String detalhesDieta;

    public Dieta(long id, String nomeDieta, String detalhesDieta) {
        this.id = id;
        this.nomeDieta = nomeDieta;
        this.detalhesDieta = detalhesDieta;
    }

    public Dieta(String nomeDieta, String detalhesDieta) {
        this.nomeDieta = nomeDieta;
        this.detalhesDieta = detalhesDieta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeDieta() {
        return nomeDieta;
    }

    public void setNomeDieta(String nomeDieta) {
        this.nomeDieta = nomeDieta;
    }

    public String getDetalhesDieta() {
        return detalhesDieta;
    }

    public void setDetalhesDieta(String detalhesDieta) {
        this.detalhesDieta = detalhesDieta;
    }
}

package br.com.rafael.projetoweb;

import java.util.Date;

public class Tarefa {
    private String nome;
    private int prioridade;
    private Date dataCadastro;

    public Tarefa(){
        this.dataCadastro = new Date();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

}

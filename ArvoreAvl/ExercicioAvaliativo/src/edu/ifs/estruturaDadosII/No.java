package edu.ifs.estruturaDadosII;


public class No {
    private int valor;
    private No direita;
    private No esquerda;
    private No pai;
    private int balanco;

    public No() {

    }
    public No(int valor) {
        this.valor = valor;

    }

    public No(int valor,No esquerda,No direita){
        this.valor = valor;
        this.direita = direita;
        this.esquerda = esquerda;
        this.pai = null;
        this.direita.pai = this;
        this.esquerda.pai =this;
    }
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public No getDireita() {
        return direita;
    }

    public No setDireita(No direita) {
        this.direita = direita;
        return direita;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public No setEsquerda(No esquerda) {
        this.esquerda = esquerda;
        return esquerda;
    }

    public No getPai() {
        return pai;
    }

    public No setPai(No pai) {
        this.pai = pai;
        return pai;
    }

    public int getBalanco() {
        return balanco;
    }

    public void setBalanco(int balanco) {
        this.balanco = balanco;
    }



}

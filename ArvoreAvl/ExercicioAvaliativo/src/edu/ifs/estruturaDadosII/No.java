package edu.ifs.estruturaDadosII;


public class No {
    public int valor;
    public No direita;
    public No esquerda;
    public No pai;
    public int balanco;

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

}

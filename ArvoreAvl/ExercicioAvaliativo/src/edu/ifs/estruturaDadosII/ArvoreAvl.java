package edu.ifs.estruturaDadosII;

public class ArvoreAvl {
    private No raiz;

    public void inserir(int valor) {
        No no = new No(valor);
        inserirAVL(this.raiz, no);
    }

    public void inserirAVL(No compararNo, No novoNo) {

        if (compararNo == null) {
            this.raiz = novoNo;
        } else {
            if (novoNo.getValor() < compararNo.getValor()) {
                if (compararNo.getEsquerda() == null) {
                    compararNo.setEsquerda(novoNo);
                    novoNo.setPai(compararNo);
                    ajustarBalanco(compararNo);

                } else {
                    inserirAVL(compararNo.getEsquerda(), novoNo); // recussão
                }
            } else if (novoNo.getValor() > compararNo.getValor()) {
                if (compararNo.getDireita() == null) {
                    compararNo.setDireita(novoNo);
                    novoNo.setPai(compararNo);
                    ajustarBalanco(compararNo);
                } else {
                    inserirAVL(compararNo.getDireita(), novoNo); // recussão
                }
            } else {
                // valor igual
            }
        }
    }

    public void ajustarBalanco(No noAtual) {
        setNoBalanco(noAtual);
        int balanceamento = noAtual.getBalanco();

        if (balanceamento == -2) {

            if (getNoaltura(noAtual.getEsquerda().getEsquerda()) >= getNoaltura(noAtual.getEsquerda().getDireita())) {
                noAtual = rotacaoRR(noAtual);

            } else {
                noAtual = rotacaoLR(noAtual);
            }

        } else if (balanceamento == 2) {

            if (getNoaltura(noAtual.getDireita().getDireita()) >= getNoaltura(noAtual.getDireita().getEsquerda())) {
                noAtual = rotacaoLL(noAtual);

            } else {
                noAtual = rotacaoRL(noAtual);
            }
        }

        if (noAtual.getPai() != null) {
            ajustarBalanco(noAtual.getPai());
        } else {
            this.raiz = noAtual;
        }
    }
    // -- ROTAÇÕES
    public No rotacaoRR(No noAlvo) {

        No noEsquerda = noAlvo.getEsquerda();
        noEsquerda.setPai(noAlvo.getPai());

        noAlvo.setEsquerda(noEsquerda.getDireita());

        if (noAlvo.getEsquerda() != null) {
            noAlvo.getEsquerda().setPai(noAlvo);
        }

        noEsquerda.setDireita(noAlvo);
        noAlvo.setPai(noEsquerda);

        if (noEsquerda.getPai() != null) {

            if (noEsquerda.getPai().getDireita() == noAlvo) {
                noEsquerda.getPai().setDireita(noEsquerda);

            } else if (noEsquerda.getPai().getEsquerda() == noAlvo) {
                noEsquerda.getPai().setEsquerda(noEsquerda);
            }
        }

        setNoBalanco(noAlvo);
        setNoBalanco(noEsquerda);

        return noEsquerda;
    }
    public No rotacaoLL(No noAlvo) {

        No noDireita = noAlvo.getDireita(); // pega o filho direito do alvo
        noDireita.setPai(noAlvo.getPai()); // seta o pai do alvo como pai do filho direito

        noAlvo.setDireita(noDireita.getEsquerda()); // seta a esquerda do filho direito como filho esquerdo do alvo

        if (noAlvo.getDireita() != null) {
            noAlvo.getDireita().setPai(noAlvo);
        }

        noDireita.setEsquerda(noAlvo);
        noAlvo.setPai(noDireita);

        if (noDireita.getPai() != null) {

            if (noDireita.getPai().getDireita() == noAlvo) {
                noDireita.getPai().setDireita(noDireita);

            } else if (noDireita.getPai().getEsquerda() == noAlvo) {
                noDireita.getPai().setEsquerda(noDireita);
            }
        }

        setNoBalanco(noAlvo);
        setNoBalanco(noDireita);

        return noDireita;
    }
    public No rotacaoLR(No noAlvo) {
        noAlvo.setEsquerda(rotacaoLL(noAlvo.getEsquerda()));
        return rotacaoRR(noAlvo);
    }
    public No rotacaoRL(No noAlvo) {
        noAlvo.setDireita(rotacaoRR(noAlvo.getDireita()));
        return rotacaoLL(noAlvo);
    }
    // -- ROTAÇÕES

    // -- FERRAMENTAS
    private void setNoBalanco(No no) {
        no.setBalanco(getNoaltura(no.getDireita()) - getNoaltura(no.getEsquerda()));
    }
    private int getNoaltura(No no) {
        if (no == null) {
            return -1;
        }

        if (no.getEsquerda() == null && no.getDireita() == null) { // é nó folha
            return 0;

        } else if (no.getEsquerda() == null) { // possui filho esquerda
            return 1 + getNoaltura(no.getDireita());

        } else if (no.getDireita() == null) { // possui filho direita
            return 1 + getNoaltura(no.getEsquerda());

        } else {
           return 1 + Math.max(getNoaltura(no.getEsquerda()), getNoaltura(no.getDireita()));
        }

    }
    // -- FERRAMENTAS



}

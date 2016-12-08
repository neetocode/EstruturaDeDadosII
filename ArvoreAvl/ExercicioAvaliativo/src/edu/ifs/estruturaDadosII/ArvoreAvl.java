package edu.ifs.estruturaDadosII;

public class ArvoreAvl {
    private No raiz;

    // -- FUNCOES
    public void inserir(int valor) throws Exception {
        No no = new No(valor);
        inserirAVL(this.raiz, no);
    }
    private void inserirAVL(No compararNo, No novoNo) throws Exception {

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
                throw new Exception("No já existe na árvore");
            }
        }
    }

    public void remover(int valor) {
        removerAVL(this.raiz, valor);
    }
    private void removerAVL(No compararNo, int valor) {
        if (compararNo == null) {
            return;

        } else {

            if (compararNo.getValor() > valor) {
                removerAVL(compararNo.getEsquerda(), valor);

            } else if (compararNo.getValor() < valor) {
                removerAVL(compararNo.getDireita(), valor);

            } else if (compararNo.getValor() == valor) {
                removeNo(compararNo);
            }
        }
    }
    private void removeNo(No noAlvo) {
        No noAux;

        if (noAlvo.getEsquerda() == null || noAlvo.getDireita() == null) {

            if (noAlvo.getPai() == null) {
                this.raiz = null;
                noAlvo = null;
                return;
            }
            noAux = noAlvo;

        } else {
            noAux = sucessor(noAlvo);
            noAlvo.setValor(noAux.getValor());
        }

        No noAux2;
        if (noAux.getEsquerda() != null) {
            noAux2 = noAux.getEsquerda();
        } else {
            noAux2 = noAux.getDireita();
        }

        if (noAux2 != null) {
            noAux2.setPai(noAux.getPai());
        }

        if (noAux.getPai() == null) {
            this.raiz = noAux2;
        } else {
            if (noAux == noAux.getPai().getEsquerda()) {
                noAux.getPai().setEsquerda(noAux2);
            } else {
                noAux.getPai().setDireita(noAux2);
            }
            setNoBalanco(noAux.getPai());
        }
        noAux = null;
    }
    // -- FUNCOES



    // -- ROTAÇÕES
    private No rotacaoRR(No noAlvo) {

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
    private No rotacaoLL(No noAlvo) {

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
    private No rotacaoLR(No noAlvo) {
        noAlvo.setEsquerda(rotacaoLL(noAlvo.getEsquerda()));
        return rotacaoRR(noAlvo);
    }
    private No rotacaoRL(No noAlvo) {
        noAlvo.setDireita(rotacaoRR(noAlvo.getDireita()));
        return rotacaoLL(noAlvo);
    }
    // -- ROTAÇÕES

    // -- FERRAMENTAS
    private void ajustarBalanco(No noAtual) {
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
    private No sucessor(No q) {
        if (q.getDireita() != null) {
            No r = q.getDireita();
            while (r.getEsquerda() != null) {
                r = r.getEsquerda();
            }
            return r;
        } else {
            No p = q.getPai();
            while (p != null && q == p.getDireita()) {
                q = p;
                p = q.getPai();
            }
            return p;
        }
    }
    // -- FERRAMENTAS



}

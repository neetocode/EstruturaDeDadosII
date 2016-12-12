package edu.ifs.estruturaDadosII;

public class ArvoreAvl {
    private No raiz;

    // -- FUNCOES
    public No inserir(No novoNo) throws Exception {
        return inserirAVL(this.raiz, novoNo);
    }
    public No inserir(int valor) throws Exception {
        No no = new No(valor);
        return inserirAVL(this.raiz, no);
    }
    public No localizar(int valor) throws Exception{
        return localizarAVL(this.raiz,valor);
    }
    private No inserirAVL(No compararNo, No novoNo) throws Exception {

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
                throw new NoAlreadyExistException("Impossível inserir dois ou mais nós com o mesmo valor (chave)");
            }
        }
        return novoNo;
    }
    private No localizarAVL(No compararNo, int valor) throws Exception {
        if(compararNo.getValor() == valor){
            return compararNo;
        }else if(compararNo.getEsquerda() != null && compararNo.getEsquerda().getValor() >= valor) {
            return localizarAVL(compararNo.getEsquerda(),valor);
        }else if(compararNo.getDireita() != null && compararNo.getDireita().getValor() <= valor){
             return localizarAVL(compararNo.getDireita(),valor);
        }else{
            throw new NoNotFoundException("Valor (chave) não encontrada");
        }
    }
    public void remover(int valor) throws Exception {
        removerAVL(this.raiz, valor);
    }
    public void remover(No noAlvo) throws Exception {
        removerAVL(this.raiz, noAlvo.getValor());
    }
    private void removerAVL(No compararNo, int valor) throws Exception {
        if (compararNo.getValor() == valor) {
            removerNo(compararNo);
        } else if (compararNo.getEsquerda() != null && compararNo.getValor() >= valor) {
            removerAVL(compararNo.getEsquerda(), valor);
        } else if (compararNo.getDireita() != null && compararNo.getValor() <= valor) {
            removerAVL(compararNo.getDireita(), valor);
        }else{
            throw new NoNotFoundException("No não encontrado");
        }
    }
    private void removerNo(No noAlvo) {
        No noHerdeiro,noHerdeiro2;

        if(noAlvo.getEsquerda() == null && noAlvo.getDireita() == null){
            // é no folha
            if(this.raiz == noAlvo){
                this.raiz = null;
                return;
            }
            if(noAlvo.getPai().getEsquerda() == noAlvo){
                noAlvo.getPai().setEsquerda(null);
            }else{
                noAlvo.getPai().setDireita(null);
            }
            noAlvo.setPai(null);
        }else{
            // possui filhos na esquerda ou direita


            noHerdeiro = noHerdeiro(noAlvo);

            if(noHerdeiro.getEsquerda() != null){
                noHerdeiro2 = noHerdeiro.getEsquerda();
            }else{
                noHerdeiro2 = noHerdeiro.getDireita();
            }

            if(noHerdeiro2 != null){
                noHerdeiro2.setPai(noHerdeiro);
            }

            if (noHerdeiro.getPai() == null) {
                this.raiz = noHerdeiro2;
            } else {
                if (noHerdeiro == noHerdeiro.getPai().getEsquerda()) {
                    noHerdeiro.getPai().setEsquerda(noHerdeiro2);
                } else {
                    noHerdeiro.getPai().setDireita(noHerdeiro2);
                }
                if(this.raiz == noAlvo){
                    if(this.raiz.getEsquerda() != null){
                        this.raiz.getEsquerda().setPai(noHerdeiro);
                        noHerdeiro.setEsquerda(this.raiz.getEsquerda());
                    }
                    if(this.raiz.getDireita() != null){
                        this.raiz.getDireita().setPai(noHerdeiro);
                        noHerdeiro.setDireita(this.raiz.getDireita());
                    }
                    this.raiz = noHerdeiro;
                    noHerdeiro.setPai(null);
                    setNoBalanco(noHerdeiro);
                }else{
                    if(noAlvo.getPai().getEsquerda() == noAlvo){
                        noAlvo.getPai().setEsquerda(noHerdeiro);
                    }else{
                        noAlvo.getPai().setDireita(noHerdeiro);
                    }

                    if(noAlvo.getDireita() != null){
                        noHerdeiro.setDireita(noAlvo.getDireita());
                        noAlvo.getDireita().setPai(noHerdeiro);
                    }
                    noHerdeiro.setPai(noAlvo.getPai());
                    setNoBalanco(noHerdeiro.getPai());
                }

            }

        }
        // não é no folha



//        if (noAlvo.getEsquerda() == null || noAlvo.getDireita() == null) {
//            // é no folha
//            if (noAlvo.getPai() == null) {
//                // é raiz de uma arvore com um no
//                this.raiz = null;
//                return;
//            }
//            noAux = noAlvo;
//
//        } else {
//            // possui esqueda ou direita
//            noAux = sucessor(noAlvo);
//            //noAlvo = noAux;
//
//        }
//
//        No noAux2;
//        if (noAux.getEsquerda() != null) {
//            noAux2 = noAux.getEsquerda();
//        } else {
//            noAux2 = noAux.getDireita();
//        }
//
//        if (noAux2 != null) {
//            noAux2.setPai(noAux);
//        }
//
//        if (noAux.getPai() == null) {
//            this.raiz = noAux2;
//        } else {
//            if (noAux == noAux.getPai().getEsquerda()) {
//                noAux.getPai().setEsquerda(noAux2);
//            } else {
//                noAux.getPai().setDireita(noAux2);
//            }
//            setNoBalanco(noAux.getPai());
//        }

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
    private No noHerdeiro(No noAlvo) {
        if (noAlvo.getEsquerda() != null) {
            No noAux = noAlvo.getEsquerda();
            while (noAux.getDireita() != null) {
                noAux = noAux.getDireita();
            }
            return noAux;
        } else {
            No noPai = noAlvo.getPai();
            while (noPai != null && noAlvo == noPai.getEsquerda()) {
                noAlvo = noPai;
                noPai = noAlvo.getPai();
            }
            return noPai;
        }
    }
    // -- FERRAMENTAS



}

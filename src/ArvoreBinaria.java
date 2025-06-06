public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria(int valor) {
        raiz = new No(valor);
    }

    public boolean estaVazia() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public void inserir(int valor) {
        No novoNo = new No(valor);
        if (estaVazia()) {
            raiz = novoNo;
        } else {
            No aux = this.raiz;
            while (true) {
                if (novoNo.getValor() > aux.getValor()) {
                    if (aux.getDireita() == null) {
                        aux.setDireita(novoNo);
                        return;
                    } else {
                        aux = aux.getDireita();
                    }
                } else {
                    if (aux.getEsquerda() == null) {
                        aux.setEsquerda(novoNo);
                        return;
                    } else {
                        aux = aux.getEsquerda();
                    }
                }

            }
        }
    }

    public void inserirRecursivoRedirecionamentoOtimizado(int conteudo) {
        No novoNo = new No(conteudo);
        this.raiz = inserirRecursivoOtimizado(this.raiz, novoNo);
    }

    private No inserirRecursivoOtimizado(No aux, No novoNo) {
        if (aux == null) {
            return novoNo;
        } else if (novoNo.getValor() > aux.getValor()) {
            aux.setDireita(inserirRecursivoOtimizado(aux.getDireita(), novoNo));
        } else {
            aux.setEsquerda(inserirRecursivoOtimizado(aux.getEsquerda(), novoNo));
        }

        return aux;
    }

    public void visualizar() {
        //preOrdem(this.raiz);
        //posOrdem(this.raiz);
        emOrdem(this.raiz);
    }

    public void preOrdem(No no) {
        if (no == null) {
            return;
        }
        System.out.println(no.getValor());
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }

    public void emOrdem(No no) {
        if (no == null) {
            return;
        }
        emOrdem(no.getEsquerda());
        System.out.println(no.getValor());
        emOrdem(no.getDireita());
    }

    public void posOrdem(No no) {
        if (no == null) {
            return;
        }
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.println(no.getValor());
    }

    public void inserirRecursivoRedirecionamento2(int conteudo) {
        No novoNo = new No(conteudo);
        inserirRecursivo2(this.raiz, novoNo);
    }

    private void inserirRecursivo2(No aux, No novoNo) {
        if (estaVazia()) {
            this.raiz = novoNo;
            return;
        }
        if (novoNo.getValor() > aux.getValor()) {
            if (aux.getDireita() == null) {
                aux.setDireita(novoNo);
                return;
            } else {
                aux = aux.getDireita();
            }
        } else {
            if (aux.getEsquerda() == null) {
                aux.setEsquerda(novoNo);
                return;
            } else {
                aux = aux.getEsquerda();
            }
        }
        inserirRecursivo2(aux, novoNo);
    }

    //remoção
    public void buscar(int valor) {
        No atual = raiz;
        No pai = null;

        //procura do valor na árvore
        while (atual != null) {
            pai = atual;
            pai = atual; //guarda o pai do nó que está atual
            if (valor < atual.getValor()) {
                atual = atual.getEsquerda(); //anda pra esquerda se for menor
            } else {
                atual = atual.getDireita(); //anda pra direita se for maior
            }
        }
        if (atual == null) {
            System.out.println("Valor não encontrado");
            return;
        }
        System.out.println(atual.getValor() + "Nóo encontrado");
    }
}

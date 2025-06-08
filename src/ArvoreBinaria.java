public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    public boolean estaVazia() {
        return raiz == null;
    }

    public void inserir(int valor) {
        No novoNo = new No(valor);
        if (estaVazia()) {
            raiz = novoNo;
        } else {
            No aux = raiz;
            while (true) {
                if (valor < aux.getValor()) {
                    if (aux.getEsquerda() == null) {
                        aux.setEsquerda(novoNo);
                        return;
                    }
                    aux = aux.getEsquerda();
                } else {
                    if (aux.getDireita() == null) {
                        aux.setDireita(novoNo);
                        return;
                    }
                    aux = aux.getDireita();
                }
            }
        }
    }

    public void emOrdem() {
        emOrdem(raiz);
    }

    private void emOrdem(No no) {
        if (no == null) return;
        emOrdem(no.getEsquerda());
        System.out.println(no.getValor());
        emOrdem(no.getDireita());
    }

    public void preOrdem() {
        preOrdem(raiz);
    }

    private void preOrdem(No no) {
        if (no == null) return;
        System.out.println(no.getValor());
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }

    public void posOrdem() {
        posOrdem(raiz);
    }

    private void posOrdem(No no) {
        if (no == null) return;
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.println(no.getValor());
    }

    public void buscar(int valor) {
        if (raiz != null && raiz.getValor() == valor) {
            removerRaiz();
            return;
        }

        No atual = raiz;
        No pai = null;

        while (atual != null && atual.getValor() != valor) {
            pai = atual;
            if (valor < atual.getValor()) {
                atual = atual.getEsquerda();
            } else {
                atual = atual.getDireita();
            }
        }

        if (atual == null) {
            System.out.println("Valor não encontrado.");
            return;
        }

        System.out.println("Valor encontrado: " + atual.getValor());

        if (atual.getEsquerda() == null && atual.getDireita() == null) {
            removerFolha(pai, atual);
        } else if (atual.getEsquerda() == null || atual.getDireita() == null) {
            removerCom1Filho(pai, atual);
        } else {
            removerCom2Filhos(pai, atual);
        }
    }

    // remover raíz
    public void removerRaiz() {
        if (raiz == null) { //se árvore vazia, retorna
            System.out.println("A árvore está vazia.");
            return;
        }

        //1º caso- raíz é uma folha, quando não tem filhos
        if (raiz.getEsquerda() == null && raiz.getDireita() == null) {
            raiz = null;
            System.out.println("A folha que foi removida é a raíz");

        //2º caso- a raíz tem 1 filho na esquerda, OU 1 na direita
        } else if (raiz.getEsquerda() == null || raiz.getDireita() == null) {
        //se tem filho na esquerda, ele vira a raíz. Se não, o da direita que vira.
            raiz = (raiz.getEsquerda() != null) ? raiz.getEsquerda() : raiz.getDireita();
            System.out.println("A raíz com 1 filho foi removida");

        //3º caso- a raíz tem 2 filhos
        } else {
        //busca o menor da subárvore direita "sucessor in order"
            No sucessorPai = raiz;
            No sucessor = raiz.getDireita();

            //caminha até encontrar o menor valor
            while (sucessor.getEsquerda() != null) {
                sucessorPai = sucessor;
                sucessor = sucessor.getEsquerda();
            }

            //guarda o valor do sucessor
            int valorSucessor = sucessor.getValor();

            //se sucessor não é um filho direto da raíz, arruma os ponteiros do pai
            if (sucessorPai != raiz) {
                sucessorPai.setEsquerda(sucessor.getDireita());
            } else {
                //se o sucesso é o filho direito direto da raíz
                sucessorPai.setDireita(sucessor.getDireita());
            }

            //substitui o valor da raíz, pelo valor do sucessor
            raiz.setValor(valorSucessor);
            System.out.println("A raíz com 2 filhos foi removida e substituída pelo sucessor: " + valorSucessor);
        }
    }

    // remoção de folha, sem filhos
    public void removerFolha(No pai, No atual) {
    //se o nó atual é filho a esquerda ou se é a direita do pai
        if (pai.getEsquerda() == atual) {
            pai.setEsquerda(null); //remove o da esquerda
        } else {
            pai.setDireita(null); //remove o da direita
        }
        System.out.println("Folha removida: " + atual.getValor());
    }

    //remoção de nó com 1 filho
    public void removerCom1Filho(No pai, No atual) {
        //procura se o filho é da esquerda ou da direita
        No filho = (atual.getEsquerda() != null) ? atual.getEsquerda() : atual.getDireita();
    //substitui o nó atual pelo filho (esq ou dir)
        if (pai.getEsquerda() == atual) {
            pai.setEsquerda(filho);
        } else {
            pai.setDireita(filho);
        }
        System.out.println("Nó com 1 filho removido: " + atual.getValor());
    }

    // remoção de nó com 2 filhos
    public void removerCom2Filhos(No pai, No atual) {
        //caçar o sucessor do nó atual, menor da subárvore direita
        No sucessorPai = atual;
        No sucessor = atual.getDireita();

        //caminha até o final, pra achar o menor valor
        while (sucessor.getEsquerda() != null) {
            sucessorPai = sucessor;
            sucessor = sucessor.getEsquerda();
        }

        //guarda o valor do sucessor
        int valorSucessor = sucessor.getValor();

        //atualiza os apontamentos/ponteiros do pai do sucessor
        if (sucessorPai != atual) {
            sucessorPai.setEsquerda(sucessor.getDireita());
        } else {
            //se o sucessor for o filho direto do nó atuaç
            sucessorPai.setDireita(sucessor.getDireita());
        }

        //substitui o valor do nó atual pelo valor do sucessor
        atual.setValor(valorSucessor);
        System.out.println("Nó com 2 filhos removido. Sucessor foi: " + valorSucessor);
    }
}

public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria(int valor) {
        raiz = new No(valor);
    }

    public boolean estaVazia() {
        return raiz == null;

    }
}
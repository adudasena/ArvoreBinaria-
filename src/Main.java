import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArvoreBinaria arvore = new ArvoreBinaria();

        //pra já começar com um fixo também
        int[] valoresIniciais = {50, 30, 70, 20, 40, 60, 80};
        for (int valor : valoresIniciais) {
            arvore.inserir(valor);
        }

        while (true) {
            System.out.println("\n==== MENU ====");
            System.out.println("1- Inserir elementos");
            System.out.println("2- Remover elementos");
            System.out.println("3- Exibir em ordem");
            System.out.println("4- Exibir em pré-ordem");
            System.out.println("5- Exibir em pós-ordem");
            System.out.println("6- Encerrar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser inserido: ");
                    int valorInserir = scanner.nextInt();
                    arvore.inserir(valorInserir);
                    break;

                case 2:
                    System.out.print("Digite o valor a ser removido: ");
                    int valorRemover = scanner.nextInt();
                    arvore.buscar(valorRemover);
                    break;

                case 3:
                    System.out.println("Em ordem:");
                    arvore.emOrdem();
                    break;

                case 4:
                    System.out.println("Pré-ordem:");
                    arvore.preOrdem();
                    break;

                case 5:
                    System.out.println("Pós-ordem:");
                    arvore.posOrdem();
                    break;

                case 6:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}

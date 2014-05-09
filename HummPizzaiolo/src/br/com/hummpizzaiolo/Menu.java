package br.com.hummpizzaiolo;

/**
 *
 * @author marcos.vcnmarcos
 */
import java.util.Scanner;

public class Menu {

    static Scanner leia = new Scanner(System.in);

    static void exibirMenu() {

        int listaOpcoes;

        do {

            System.out.print(" --- HUMM PIZZAIOLO --- ");

            System.out.print("\nDigite uma das opções a seguir:  ");
            System.out.print("\n1 - PEDIDOS\n2 - CLIENTES\n3 - ITENS\n4 - FINALIZAR PROGRAMA\n");

            listaOpcoes = leia.nextInt();

            switch (listaOpcoes) {
                case 1:
                    Menu.pedidosMenu();
                    int pedidos;
                    pedidos = leia.nextInt();
                    switch (pedidos){
                        case 1:
                            
                            break;
                        case 2:
                            
                            break;
                        case 3:
                            
                            break;
                        case 4:
                            
                            break;
                        default:
                            System.out.print("OPÇÃO INEXISTENTE");
                            listaOpcoes = 0;
                    break;
                    }
                    break;
                case 2:
                    Menu.clientesMenu();
                    break;
                case 3:
                    Menu.itensMenu();
                    break;
                case 4:
                    Menu.sairMenu();
                    break;
                default:
                    System.out.print("OPÇÃO INEXISTENTE");
                    listaOpcoes = 0;
                    break;
            }

        } while (listaOpcoes < 5);
    }

    static void pedidosMenu() {
        System.out.print("          PEDIDOS\nDigite uma das opções a seguir:");
        System.out.print("\n1 - CADASTRAR\n2 - ALTERAR\n3 - EXCLUIR");
        int listaOpcoes = leia.nextInt();
    }

    static void clientesMenu() {
        System.out.print("          CLIENTES\nDigite uma das opções a seguir:");
        System.out.print("\n1 - CADASTRAR\n2 - ALTERAR\n3 - EXCLUIR");
        int listaOpcoes = leia.nextInt();
    }

    static void itensMenu() {
        System.out.print("          ITENS\nDigite uma das opções a seguir:");
        System.out.print("\n1 - CADASTRAR\n2 - ALTERAR\n3 - EXCLUIR");
        int listaOpcoes = leia.nextInt();
    }
    
    static void sairMenu(){
        System.out.print("Sair");
        int listaOpcoes = leia.nextInt();
        
    }

}

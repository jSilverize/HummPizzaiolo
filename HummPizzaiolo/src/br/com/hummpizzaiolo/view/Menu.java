package br.com.hummpizzaiolo.view;

/**
 *
 * @author marcos.vcnmarcos
 */
import java.util.Scanner;

public class Menu {

    static Scanner leia = new Scanner(System.in);

   public static void exibir() {

        int listaOpcoes;

        do {

            System.out.print(" --- HUMM PIZZAIOLO --- ");

            System.out.print("\n1 - PEDIDOS\n2 - CLIENTES\n3 - ITENS\n4 - FINALIZAR PROGRAMA\n");
            System.out.print("\nDigite uma das opções acima ↑: \n");

            listaOpcoes = leia.nextInt();

            switch (listaOpcoes) {
                case 1:
                    Menu.pedidosMenu();
                    int pedidos;
                    pedidos = leia.nextInt();
                    switch (pedidos){
                        case 0:
                            pedidos = 0;
                        case 1:
                            
                            break;
                        case 2:
                            
                            break;
                        case 3:
                            
                            break;
                        case 4:
                            
                            break;
                        default:
                            System.out.print("OPÇÃO INEXISTENTE\n");
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
                    System.out.print("OPÇÃO INEXISTENTE\n");
                    listaOpcoes = 0;
                    break;
            }

        } while (listaOpcoes > 0);
    }

    static void pedidosMenu() {
        System.out.print(" --- PEDIDOS --- ");
        Menu.miniMenu();
        int listaOpcoes = leia.nextInt();
    }

    static void clientesMenu() {
        System.out.print(" --- CLIENTES --- ");
        Menu.miniMenu();

        int listaOpcoes = leia.nextInt();
    }

    static void itensMenu() {
        System.out.print(" --- ITENS --- ");
        Menu.miniMenu();
        int listaOpcoes = leia.nextInt();
    }
    
    static void sairMenu(){
        System.out.print("Sair");
        int listaOpcoes = leia.nextInt();
        
    }
    static void miniMenu(){
         System.out.print("\n1 - CADASTRAR\n2 - ALTERAR\n3 - EXCLUIR\n0 MENU PRINCIPAL");
         System.out.print("\nDigite uma das opções acima ↑: \n");
    }
}


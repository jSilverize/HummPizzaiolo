package br.com.hummpizzaiolo;

import br.com.hummpizzaiolo.model.Item;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * @author jsilverize & markaotribe
 */
public class HummPizzaiolo {

  public static void main(String[] args) throws FileNotFoundException {
    
    Item [] prateleira = new Item[50];

    int listaOpcoes;

    do {

      System.out.println("\n -------- HUMM PIZZAIOLO -------- ");
      System.out.println("\n\t  MENU PRINCIPAL");

      System.out.println("\n1 - PEDIDOS\n2 - CLIENTES\n3 - ITENS\n\n0 - FINALIZAR PROGRAMA\n");

      System.out.print("Digite uma das opções: ");
      listaOpcoes = leia.nextInt();

      switch (listaOpcoes) {
        case 0:
          break;
        case 1:
          pedidosMenu();
          break;
        case 2:
          clientesMenu();
          break;
        case 3:
          prateleira = Item.menu();
          break;
        default:
          System.out.println("Favor digitar uma opcao valida.\n");
          listaOpcoes = 1;
          break;
      }

    } while (listaOpcoes > 0);

  }

  public static Scanner leia = new Scanner(System.in);

  static void pedidosMenu() {

    System.out.println("EM CONSTRUCAO\n\n");

    int listaOpcoes;

    do {
      System.out.println("\n -------- HUMM PIZZAIOLO -------- ");
      System.out.println("\n\t     PEDIDOS\n");

      System.out.println("1 - BUSCAR\n2 - CADASTRAR\n3 - ALTERAR\n4 - EXCLUIR\n\n0 - MENU PRINCIPAL");
      System.out.print("\nDigite uma das opções: ");
      listaOpcoes = leia.nextInt();
      switch (listaOpcoes) {
        case 0:
          // VOLTAR para o MENU PRINCIPAL
          break;
        case 1:
          // buscarPedido();
          break;
        case 2:
          // cadastrarPedido();
          break;
        case 3:
          // alterarPedido();
          break;
        case 4:
          // excluirPedido();
          break;
        default:
          System.out.println("Favor digitar uma opcao valida.\n");
          listaOpcoes = 0;
          break;
      }
    } while (listaOpcoes > 0);

  }

  static void clientesMenu() {
    System.out.println("EM CONSTRUCAO\n\n");

    int listaOpcoes;

    do {
      System.out.println("\n -------- HUMM PIZZAIOLO -------- ");
      System.out.println("\n\t      CLIENTES\n");

      System.out.println("1 - BUSCAR\n2 - CADASTRAR\n3 - ALTERAR\n4 - EXCLUIR\n\n0 - MENU PRINCIPAL");
      System.out.print("\nDigite uma das opções: ");
      listaOpcoes = leia.nextInt();
      switch (listaOpcoes) {
        case 0:
          // VOLTAR para o MENU PRINCIPAL
          break;
        case 1:
          // buscarCliente();
          break;
        case 2:
          // cadastrarCliente();
          break;
        case 3:
          // alterarCliente();
          break;
        case 4:
          // excluirCliente();
          break;
        default:
          System.out.println("Favor digitar uma opcao valida.\n");
          listaOpcoes = 0;
          break;
      }
    } while (listaOpcoes > 0);
  }

}

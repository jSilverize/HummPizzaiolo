package br.com.hummpizzaiolo.view;

import br.com.hummpizzaiolo.HummPizzaiolo;
import static br.com.hummpizzaiolo.HummPizzaiolo.leia;
import br.com.hummpizzaiolo.model.Item;
import java.util.Scanner;

/*
 * @author jsilverize & markaotribe
 */
public class Menu {

  static Scanner leia = new Scanner(System.in);

  public static void exibir() {

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
          Item.menu();
          break;
        default:
          System.out.println("Favor digitar uma opcao valida.\n");
          listaOpcoes = 1;
          break;
      }

    } while (listaOpcoes > 0);
  }

  //FUNÇÕES 
  static void pedidosMenu() {
    System.out.print(" --- PEDIDOS --- ");
    Menu.crudMenu();
    int listaOpcoes = leia.nextInt();
  }

  static void clientesMenu() {
    System.out.print(" --- CLIENTES --- ");
    Menu.crudMenu();
    int listaOpcoes = leia.nextInt();
  }

  static void itensMenu() {
    System.out.print(" --- ITENS --- ");
    Menu.crudMenu();
    int listaOpcoes = leia.nextInt();
  }

  static int crudMenu() {
    System.out.println("1 - CADASTRAR\n2 - ALTERAR\n3 - EXCLUIR\n4 - PROCURA DE ITENS\n\n0 - MENU PRINCIPAL");
    System.out.print("\nDigite uma das opções: ");
    return HummPizzaiolo.leia.nextInt();
  }
}

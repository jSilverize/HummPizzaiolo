package br.com.hummpizzaiolo;

import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * @author jsilverize & markaotribe
 */
public class HummPizzaiolo {

  public static void main(String[] args) {    

    int listaOpcoes;

    do {

      System.out.println("\n-------- HUMM PIZZAIOLO, oi --------");
      System.out.println("\n\t  MENU PRINCIPAL");
      System.out.println("\n1 - PEDIDOS\n2 - CLIENTES\n3 - ITENS\n\n0 - FINALIZAR PROGRAMA\n");
      System.out.print("Digite uma das opções: ");
      listaOpcoes = leia.nextInt();

      switch (listaOpcoes) {
        case 0:
          break;
        case 1:
          Pedido.menu();
          break;
        case 2:
          Cliente.menu();
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

  public static Scanner leia = new Scanner(System.in);

}

package br.com.hummpizzaiolo;

import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

/*
 * @author jsilverize & markaotribe
 */
public class Pedido {
  
  int id;
  Cliente cliente = new Cliente();
  Item[] itens = new Item[15];
  float totalPedido;

  static String xml = lerXML();

  static Pedido[] fila = deserializarXML(xml);

  static int ultimo = verificarArray(fila);

  public static void menu() {

    int listaOpcoes;

    do {
      System.out.println("\n-------- HUMM PIZZAIOLO --------");
      System.out.println("\n\t       PEDIDOS\n");

      System.out.println("1 - CADASTRAR\n2 - ALTERAR\n3 - EXCLUIR\n4 - LISTA DE PEDIDOS\n\n0 - MENU PRINCIPAL");
      System.out.print("\nDigite uma das opções: ");
      listaOpcoes = HummPizzaiolo.leia.nextInt();

      int pos;

      switch (listaOpcoes) {
        case 1:
          // adicionar pedido
          Pedido it = lerPedido(ultimo);
          adicionarPedido(fila, ultimo, it);
          ultimo++;
          break;
        case 2:
          //altera os dados de um pedido
          // busca o pedido a ser alterado
          /*
           pos = buscarPedido(fila, ultimo);
           if (pos > -1) {
           alterarPedido(fila, ultimo, pos);
           System.out.println("Pedido Alterado!");
           } else {
           System.out.println("Pedido Inexistente!");
           }
           */
          break;
        case 3:
          // remove um pedido
          // busca o pedido a ser removido
          /*
           pos = buscarPedido(fila, ultimo);
           if (pos > -1) {
           removerPedido(fila, ultimo, pos);
           ultimo--;
           System.out.println("Pedido Removido!");
           } else {
           System.out.println("Pedido Inexistente!");
           }
           */
          break;
        case 4:
          //lista pedidos
          listarPedidos(fila, ultimo);
          break;
        default:
          System.out.println("Opcao Invalida!");
        case 0:
          // salva um arquivo XML com todos os itens registrados
          salvarPedidos(fila);
          break;
      }

    } while (listaOpcoes > 0);

  }

  // FUNÇÕES de PEDIDO
  static Pedido lerPedido(int ultimo) {
    Pedido pedido = new Pedido();
    System.out.println("\n------ Novo Pedido ------");
    pedido.id = ultimo;
    pedido.totalPedido = 0;
    byte opcaoMenu, i = 0;
    do {
      pedido.itens[i] = Item.prateleira[Item.buscarItem()];
      pedido.totalPedido += pedido.itens[i].preco;
      i++;      
      System.out.print("\n0 - FINALIZAR PEDIDO\n1 - ADICIONAR ITEM\n\nDigite sua opção: ");
      opcaoMenu = leia.nextByte();
    } while (opcaoMenu > 0);
    pedido.cliente = Cliente.lista[Cliente.buscarCliente()];
    return pedido;
  }

  static void adicionarPedido(Pedido[] fila, int pos, Pedido it) {
    fila[pos] = it;
  }

  static void listarPedidos(Pedido[] fila, int ultimo) {
    System.out.println("\n------ Lista de Pedidos ------");
    for (int i = 0; i < ultimo; i++) {
      System.out.println("\nNº Pedido: " + fila[i].id);
      System.out.println("Cliente: " + fila[i].cliente.nome);
      for (int j = 0; j < 15; j++) {
        if (fila[i].itens[j] != null) {
          System.out.println("Item: " + fila[i].itens[j].nome);
        } else {
          j = 15;
        }
      }      
      System.out.println("Total: R$ " + fila[i].totalPedido);
    }
    System.out.println();
  }

  /*
   static int buscarPedido(Pedido[] fila, int ultimo) {
   System.out.println("\n------ Buscar Pedido ------\n");
   System.out.print("Nome: ");
   Cliente clienteBuscar = Cliente.buscarClienteNome();
   for (int i = 0; i < ultimo; i++) {
   if (fila[i].cliente == clienteBuscar) {
   return i;
   }
   }
   return -1;
   }
  
   static void alterarPedido(Pedido[] fila, int ultimo, int pos) {
   System.out.println("\n------ Alteração de Pedido ------\n");
   System.out.println("Pedido: " + fila[pos].nome + "\nPreço: " + fila[pos].preco);
   System.out.print("Novo Nome: ");
   fila[pos].nome = leia.nextLine();
   System.out.print("Novo Preco: ");
   fila[pos].preco = leia.nextLine();
   }
   */
  static void removerPedido(Pedido[] fila, int ultimo, int pos) {
    for (int i = pos + 1; i < ultimo; i++) {
      fila[i - 1] = fila[i];
    }
    fila[ultimo - 1] = null;
  }

  static void salvarPedidos(Pedido[] pedido) {
    XStream xstream = new XStream();
    String novoPedido;
    novoPedido = xstream.toXML(pedido);
    gravarXML(novoPedido);
  }

  public static void gravarXML(String xml) {
    try {
      FileWriter w = new FileWriter("FilaPedidos.xml");
      w.write(xml);
      w.close();
    } catch (Exception e) {
      System.out.println("Erro ao gravar o xml. \n" + e);
    }
  }

  public static String lerXML() {
    try {
      Scanner in = new Scanner(new File("FilaPedidos.xml"));
      StringBuilder sb = new StringBuilder();
      while (in.hasNext()) {
        sb.append(in.next() + " ");
      }
      in.close();
      return sb.toString();
    } catch (Exception e) {
      System.out.println("Erro: " + e);
    }
    return "";
  }

  public static Pedido[] deserializarXML(String xml) {
    XStream xstream = new XStream();
    // Deserializando objeto 
    Pedido[] carregarLista = (Pedido[]) xstream.fromXML(xml);
    return carregarLista;
  }

  public static int verificarArray(Pedido[] it) {
    int contador = 0;
    for (int i = 0; i < it.length; i++) {
      if (it[i] == null) {
        break;
      }
      contador++;
    }
    return contador;
  }

  public static Scanner leia = new Scanner(System.in);

}

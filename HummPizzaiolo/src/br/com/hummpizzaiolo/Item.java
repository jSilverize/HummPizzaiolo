package br.com.hummpizzaiolo;

import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

/*
 * @author jsilverize & markaotribe
 */
public class Item {
  
  int id;
  String nome;
  float preco;
  String descricao;

  static String xml = lerXML();

  static Item[] prateleira = deserializarXML(xml);

  static int ultimo = verificarArray(prateleira);

  public static void menu() {

    int listaOpcoes;

    do {
      System.out.println("\n-------- HUMM PIZZAIOLO --------");
      System.out.println("\n\t       ITENS\n");

      System.out.println("1 - CADASTRAR\n2 - ALTERAR\n3 - EXCLUIR\n4 - LISTA DE ITENS\n\n0 - MENU PRINCIPAL");
      System.out.print("\nDigite uma das opções: ");
      listaOpcoes = HummPizzaiolo.leia.nextInt();

      int pos;

      switch (listaOpcoes) {
        case 1:
          // adicionar item
          Item it = lerItem();
          adicionarItem(prateleira, ultimo, it);
          ultimo++;
          break;
        case 2:
          //altera os dados de um item
          // busca o item a ser alterado
          pos = buscarItem();
          if (pos > -1) {
            alterarItem(prateleira, ultimo, pos);
            System.out.println("Item Alterado!");
          } else {
            System.out.println("Item Inexistente!");
          }
          break;
        case 3:
          // remove um item
          // busca o item a ser removido
          pos = buscarItem();
          if (pos > -1) {
            removerItem(prateleira, ultimo, pos);
            ultimo--;
            System.out.println("Item Removido!");
          } else {
            System.out.println("Item Inexistente!");
          }
          break;
        case 4:
          //lista items
          listarItens(prateleira, ultimo);
          break;
        default:
          System.out.println("Opcao Invalida!");
        case 0:
          // salva um arquivo XML com todos os itens registrados
          salvarItens(prateleira);
          break;
      }

    } while (listaOpcoes > 0);

  }

  // FUNÇÕES de ITEM
  static Item lerItem() {
    Item item = new Item();
    System.out.println("\n------ Novo Item ------");
    System.out.print("Nome: ");
    item.nome = leia.nextLine().trim();
    System.out.print("Preco: ");
    item.preco = leia.nextFloat();
    return item;
  }

  static void adicionarItem(Item[] prateleira, int pos, Item it) {
    prateleira[pos] = it;
  }

  static void listarItens(Item[] prateleira, int ultimo) {
    System.out.println("\n------ Lista de Items ------\n");
    for (int i = 0; i < ultimo; i++) {
      System.out.println("ID: " + i + "\nItem: " + prateleira[i].nome + "\nPreço: " + prateleira[i].preco);
    }
    System.out.println();
  }

  static int buscarItem() {
    System.out.println("\n------ Buscar Item ------\n");
    System.out.print("Nome: ");
    String nome = leia.nextLine().trim();
    for (int i = 0; i < ultimo; i++) {
      if (prateleira[i].nome.equalsIgnoreCase(nome)) {
        return i;
      }
    }
    return -1;
  }

  static void alterarItem(Item[] prateleira, int ultimo, int pos) {
    System.out.println("\n------ Alteração de Item ------\n");
    System.out.println("Item: " + prateleira[pos].nome + "\nPreço: " + prateleira[pos].preco);
    System.out.print("Novo Nome: ");
    prateleira[pos].nome = leia.nextLine().trim();
    System.out.print("Novo Preço: ");
    prateleira[pos].preco = leia.nextFloat();
  }

  static void removerItem(Item[] prateleira, int ultimo, int pos) {
    for (int i = pos + 1; i < ultimo; i++) {
      prateleira[i - 1] = prateleira[i];
    }
    prateleira[ultimo - 1] = null;
  }

  static void salvarItens(Item[] it) {
    XStream xstream = new XStream();
    String novoItem;
    novoItem = xstream.toXML(it);
    gravarXML(novoItem);
  }

  public static void gravarXML(String xml) {
    try {
      FileWriter w = new FileWriter("ItensPrateleira.xml");
      w.write(xml);
      w.close();
    } catch (Exception e) {
      System.out.println("Erro ao gravar o xml. \n" + e);
    }
  }

  public static String lerXML() {
    try {
      Scanner in = new Scanner(new File("ItensPrateleira.xml"));
      StringBuilder sb = new StringBuilder();
      while (in.hasNext()) {
        sb.append(in.next() + " ");
      }
      in.close();
      return sb.toString();
    } catch (FileNotFoundException e) {
      System.out.println("Erro: " + e);
    }
    return "";
  }

  public static Item[] deserializarXML(String xml) {
    XStream xstream = new XStream();
    // Deserializando objeto 
    Item[] carregarLista = (Item[]) xstream.fromXML(xml);
    return carregarLista;
  }

  public static int verificarArray(Item[] it) {
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

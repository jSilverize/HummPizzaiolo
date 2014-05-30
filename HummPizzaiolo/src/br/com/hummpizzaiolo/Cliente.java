package br.com.hummpizzaiolo;

import com.thoughtworks.xstream.XStream;
import br.com.hummpizzaiolo.HummPizzaiolo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

/*
 * @author jsilverize & markaotribe
 */
public class Cliente {

  String nome;
  String telefone;
  String endereco;

  public static void menu() {

    Cliente[] lista = new Cliente[50];

    String xml = lerXML();

    lista = deserializarXML(xml);

    int listaOpcoes;
    int ultimo = verificarArray(lista);

    do {
      System.out.println("\n-------- HUMM PIZZAIOLO --------");
      System.out.println("\n\t       CLIENTES\n");

      System.out.println("1 - CADASTRAR\n2 - ALTERAR\n3 - EXCLUIR\n4 - LISTA DE CLIENTES\n\n0 - MENU PRINCIPAL");
      System.out.print("\nDigite uma das opções: ");
      listaOpcoes = HummPizzaiolo.leia.nextInt();

      int pos;

      switch (listaOpcoes) {
        case 1:
          // adicionar cliente
          Cliente cli = lerCliente();
          adicionarCliente(lista, ultimo, cli);
          ultimo++;
          break;
        case 2:
          //altera os dados de um cliente
          // busca o cliente a ser alterado
          pos = buscarCliente(lista, ultimo);
          if (pos > -1) {
            alterarCliente(lista, ultimo, pos);
            System.out.println("Cliente Alterado!");
          } else {
            System.out.println("Cliente Inexistente!");
          }
          break;
        case 3:
          // remove um cliente
          // busca o cliente a ser removido
          pos = buscarCliente(lista, ultimo);
          if (pos > -1) {
            removerCliente(lista, ultimo, pos);
            ultimo--;
            System.out.println("Cliente Removido!");
          } else {
            System.out.println("Cliente Inexistente!");
          }
          break;
        case 4:
          //lista clientes
          listarItens(lista, ultimo);
          break;
        default:
          System.out.println("Opcao Invalida!");
        case 0:
          // salva um arquivo XML com todos os cliens registrados
          salvarItens(lista);
          break;
      }

    } while (listaOpcoes > 0);

  }

  // FUNÇÕES de ITEM
  static Cliente lerCliente() {
    Cliente cliente = new Cliente();
    System.out.println("\n------ Novo Cliente ------");
    System.out.print("Nome: ");
    cliente.nome = leia.nextLine();
    System.out.print("Telefone: ");
    cliente.telefone = leia.nextLine();
    System.out.print("Endereco: ");
    cliente.endereco = leia.nextLine();
    return cliente;
  }

  static void adicionarCliente(Cliente[] lista, int pos, Cliente cli) {
    lista[pos] = cli;
  }

  static void listarItens(Cliente[] lista, int ultimo) {
    System.out.println("\n------ Lista de Clientes ------\n");
    for (int i = 0; i < ultimo; i++) {
      System.out.println("Cliente: " + lista[i].nome + "\nTelefone: " + lista[i].telefone + "\nEndereco: " + lista[i].endereco);
    }
    System.out.println();
  }

  static int buscarCliente(Cliente[] lista, int ultimo) {
    System.out.println("\n------ Buscar Cliente ------\n");
    System.out.print("Nome: ");
    String nome = leia.nextLine();
    for (int i = 0; i < ultimo; i++) {
      if (lista[i].nome.equals(nome)) {
        return i;
      }
    }
    return -1;
  }

  static void alterarCliente(Cliente[] lista, int ultimo, int pos) {
    System.out.println("\n------ Alteração de Cliente ------\n");
    System.out.println("Cliente: " + lista[pos].nome + "\nTelefone: " + lista[pos].telefone + "\nEndereco: " + lista[pos].endereco);
    System.out.print("Novo Nome: ");
    lista[pos].nome = leia.nextLine();
    System.out.print("Novo Telefone: ");
    lista[pos].telefone = leia.nextLine();    
    System.out.print("Novo Endereco: ");
    lista[pos].endereco = leia.nextLine();
  }

  static void removerCliente(Cliente[] lista, int ultimo, int pos) {
    for (int i = pos + 1; i < ultimo; i++) {
      lista[i - 1] = lista[i];
    }
    lista[ultimo - 1] = null;
  }

  static void salvarItens(Cliente[] cli) {
    XStream xstream = new XStream();
    String novoCliente;
    novoCliente = xstream.toXML(cli);
    gravarXML(novoCliente);
  }

  public static void gravarXML(String xml) {
    try {
      FileWriter w = new FileWriter("ClientesCadastrados.xml");
      w.write(xml);
      w.close();
    } catch (Exception e) {
      System.out.println("Erro ao gravar o xml. \n" + e);
    }
  }

  public static String lerXML() {
    try {
      Scanner in = new Scanner(new File("ClientesCadastrados.xml"));
      StringBuilder sb = new StringBuilder();
      while (in.hasNext()) {
        sb.append(in.next() + "\n");
      }
      in.close();
      return sb.toString();
    } catch (Exception e) {
      System.out.println("Erro: " + e);
    }
    return "";
  }

  public static Cliente[] deserializarXML(String xml) {
    XStream xstream = new XStream();
    // Deserializando objeto 
    Cliente[] carregarLista = (Cliente[]) xstream.fromXML(xml);
    return carregarLista;
  }

  public static int verificarArray(Cliente[] cli) {
    int contador = 0;
    for (int i = 0; i < cli.length; i++) {
      if (cli[i] == null) {
        break;
      }
      contador++;
    }
    return contador;
  }

  public static Scanner leia = new Scanner(System.in);

}

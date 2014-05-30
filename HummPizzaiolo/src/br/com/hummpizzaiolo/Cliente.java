package br.com.hummpizzaiolo;

import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * @author jsilverize & markaotribe
 */
public class Cliente {
  
  int id;
  String nome;
  String telefone;
  String endereco;
  
  static String xml = lerXML();
  
  static Cliente[] lista = deserializarXML(xml);
  
  static int ultimo = verificarArray(lista);

  public static void menu() {

    int listaOpcoes;

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
          Cliente cli = lerCliente(ultimo);
          adicionarCliente(lista, ultimo, cli);
          ultimo++;
          break;
        case 2:
          //altera os dados de um cliente
          // busca o cliente a ser alterado
          pos = buscarCliente();
          if (pos > -1) {
            alterarCliente(lista, ultimo, pos);
            System.out.println("CLIENTE ALTERADO.");
          } else {
            System.out.println("CLIENTE INEXISTENTE.");
          }
          break;
        case 3:
          // remove um cliente
          // busca o cliente a ser removido
          pos = buscarCliente();
          if (pos > -1) {
            removerCliente(lista, ultimo, pos);
            ultimo--;
            System.out.println("CLIENTE REMOVIDO.");
          } else {
            System.out.println("CLIENTE INEXISTENTE.");
          }
          break;
        case 4:
          //lista clientes
          listarClientes(lista, ultimo);
          break;
        default:
          System.out.println("Opção inválida.");
        case 0:
          // salva um arquivo XML com todos os cliens registrados
          salvarClientes(lista);
          break;
      }

    } while (listaOpcoes > 0);

  }

  // FUNÇÕES de ITEM
  static Cliente lerCliente(int ultimo) {
    Cliente cliente = new Cliente();
    System.out.println("\n------ Novo Cliente ------");
    cliente.id = ultimo;
    System.out.print("Nome: ");
    cliente.nome = leia.nextLine().trim();
    System.out.print("Telefone: ");
    cliente.telefone = leia.nextLine().trim();
    System.out.print("Endereco: ");
    cliente.endereco = leia.nextLine().trim();
    return cliente;
  }

  static void adicionarCliente(Cliente[] lista, int pos, Cliente cli) {
    lista[pos] = cli;
  }

  static void listarClientes(Cliente[] lista, int ultimo) {
    System.out.println("\n------ Lista de Clientes ------");
    for (int i = 0; i < ultimo; i++) {
      System.out.println("\nID de Cliente: " + lista[i].id + "\nNome: " + lista[i].nome);
      System.out.println("Telefone: " + lista[i].telefone + "\nEndereco: " + lista[i].endereco);
    }
    System.out.println("\n");
  }

  static int buscarCliente() {
    System.out.println("\n------ Buscar Cliente ------\n");
    System.out.print("Telefone: ");
    String telefone = leia.nextLine().trim();
    for (int i = 0; i < ultimo; i++) {
      if (lista[i].telefone.equalsIgnoreCase(telefone)) {
        return i;
      }
    }
    return -1;
  }

  static void alterarCliente(Cliente[] lista, int ultimo, int pos) {
    System.out.println("\n------ Alteração de Cliente ------\n");
    System.out.println("ID de Cliente: " + lista[pos].id + "\nCliente: " + lista[pos].nome + "\nTelefone: " + lista[pos].telefone + "\nEndereco: " + lista[pos].endereco);
    System.out.print("Novo Nome: ");
    lista[pos].nome = leia.nextLine();
    System.out.print("Novo Telefone: ");
    lista[pos].telefone = leia.nextLine().trim();    
    System.out.print("Novo Endereco: ");
    lista[pos].endereco = leia.nextLine().trim();
  }

  static void removerCliente(Cliente[] lista, int ultimo, int pos) {
    for (int i = pos + 1; i < ultimo; i++) {
      lista[i - 1] = lista[i];
    }
    lista[ultimo - 1] = null;
  }

  static void salvarClientes(Cliente[] cli) {
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
    } catch (IOException e) {
      System.out.println("Erro ao gravar o xml. \n" + e);
    }
  }

  public static String lerXML() {
    try {
      Scanner in = new Scanner(new File("ClientesCadastrados.xml"));
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

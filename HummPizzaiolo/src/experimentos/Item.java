package experimentos;

/*
 *  @author jsilverize
 */
public class Item {

  static String nome;
  static String preco;
  static String descricao;

  // FUNÇÕES
  static Item lerDados() {
    Item item = new Item();

    System.out.println("\n -------- HUMM PIZZAIOLO -------- ");
    System.out.println("\n\t  DADOS DO ITEM\n");

    System.out.print("Nome: ");
    item.nome = HummPizzaiolo.leia.next();
    System.out.print("Preco: ");
    item.preco = HummPizzaiolo.leia.next();
    System.out.print("Descricao: ");
    item.descricao = HummPizzaiolo.leia.next();

    return item;
  }

  static void cadastrar(Item[] listaItens, Item it) {
    for (int i = 0; i < listaItens.length; i++) {
      if (listaItens[i] == null) {
        listaItens[i] = it;
      }
    }
  }

  static void listar(Item[] listaItens, int ultimo) {
    System.out.println("\n -------- HUMM PIZZAIOLO -------- ");
    System.out.println("\n\t  LISTA DE ITENS\n");

    for (int i = 0; i < ultimo; i++) {
      System.out.println(listaItens[i].nome + " | " + listaItens[i].preco);
    }
    System.out.println();
  }

  static int buscar(Item[] listaItens) {
    System.out.println("\n -------- HUMM PIZZAIOLO -------- ");
    System.out.println("\n\t       BUSCAR ITEM\n");
    System.out.print("Nome, preco ou descricao: ");
    String valorBusca = HummPizzaiolo.leia.next();
    for (int i = 0; i < 50; i++) {
      System.out.println("\n\t       RESULTADO");
      if (listaItens[i].nome.equalsIgnoreCase(valorBusca) || listaItens[i].preco.equalsIgnoreCase(valorBusca) || listaItens[i].descricao.equalsIgnoreCase(valorBusca)) {
        System.out.println("ID: " + i);
        System.out.println("Nome: " + listaItens[i].nome);
        System.out.println("Preco: " + listaItens[i].preco);
        System.out.println("Descricao: " + listaItens[i].descricao + "\n");
        return i;
      }
    }
    return -1;
  }

  static void alterar(Item[] listaItens, int ultimo, int pos) {
    System.out.println("\n -------- HUMM PIZZAIOLO -------- ");
    System.out.println("\n\t  ALTERAR ITEM\n");
    System.out.println(listaItens[pos].nome + " | " + listaItens[pos].preco);
    System.out.print("Novo nome: ");
    listaItens[pos].nome = HummPizzaiolo.leia.next();
    System.out.print("Novo Preco: ");
    listaItens[pos].preco = HummPizzaiolo.leia.next();
    System.out.print("Nova Descricao: ");
    listaItens[pos].descricao = HummPizzaiolo.leia.next();
  }

  static void excluir(Item[] listaItens, int ultimo, int pos) {
    for (int i = pos + 1; i < ultimo; i++) {
      listaItens[i - 1] = listaItens[i];
    }
    listaItens[ultimo - 1] = null;
  }

}

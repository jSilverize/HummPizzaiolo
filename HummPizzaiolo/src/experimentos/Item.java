package experimentos;

import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

/*
 *  @author jsilverize
 */
public class Item {

    String nome;
    String preco;
    String descricao;

    static Item[] menu(Item[] listaItens) {

        int listaOpcoes;
        int ultimo = 0;
        int pos = 0;

        do {
            System.out.println("\n -------- HUMM PIZZAIOLO -------- ");
            System.out.println("\n\t       ITENS\n");

            System.out.println("1 - CADASTRAR\n2 - ALTERAR\n3 - EXCLUIR\n4 - LISTA DE TODOS OS ITENS\n\n0 - MENU PRINCIPAL");
            System.out.print("\nDigite uma das opções: ");
            listaOpcoes = HummPizzaiolo.leia.nextInt();

            switch (listaOpcoes) {
                case 0:
                    // VOLTAR para o MENU PRINCIPAL
                    break;
                case 1:
                    Item it = itemLerDados();
                    itemCadastrar(it);
                    ultimo++;
                    break;
                case 2:
                    pos = itemBuscar(listaItens, ultimo);
                    itemAlterar(listaItens, ultimo, pos);
                    break;
                case 3:
                    pos = itemBuscar(listaItens, ultimo);
                    if (pos > -1) {
                        System.out.println("Item Excluido.");
                        itemExcluir(listaItens, ultimo, pos);
                        ultimo--;
                    } else {
                        System.out.println("Nao foi possivel encontrar este item.");
                    }

                    break;
                case 4:
                    itemListar(listaItens, ultimo);
                    break;
                default:
                    System.out.println("Favor digitar uma opcao valida.\n");
                    break;
            }
        } while (listaOpcoes > 0);

        return listaItens;

    }

    // FUNÇÕES de ITEM
    static Item itemLerDados() {
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

    static void itemCadastrar(Item it) {
        // listaItens[pos] = it;
        XStream xstream = new XStream();
        String novoItem;
        novoItem = xstream.toXML(it);
        gravarXML(novoItem, it.nome);
    }

    static void itemListar(Item[] listaItens, int ultimo) {
        System.out.println("\n -------- HUMM PIZZAIOLO -------- ");
        System.out.println("\n\t  LISTA DE ITENS\n");
        for (int i = 0; i < ultimo; i++) {
            System.out.println("Item ID: " + i);
            System.out.println("Nome: " + listaItens[i].nome);
            System.out.println("Preço: " + listaItens[i].preco);
            System.out.println();
        }
        System.out.println();
    }

    static int itemBuscar(Item[] listaItens, int ultimo) {
        System.out.println("\n -------- HUMM PIZZAIOLO -------- ");
        System.out.println("\n\t  BUSCA DE ITEM\n");
        System.out.print("Nome: ");
        String nome = HummPizzaiolo.leia.nextLine();
        for (int i = 0; i < ultimo; i++) {
            if (listaItens[i].nome.equalsIgnoreCase(nome)) {
                System.out.println("Item ID: " + i);
                System.out.println("Nome: " + listaItens[i].nome);
                System.out.println("Preco: " + listaItens[i].preco);
                System.out.println("Descricao: " + listaItens[i].descricao);
                System.out.println();
                return i;
            }
        }
        return -1;
    }

    static void itemAlterar(Item[] listaItens, int ultimo, int pos) {
        System.out.println("\n -------- HUMM PIZZAIOLO -------- ");
        System.out.println("\n\t  ALTERAR ITEM\n");
        System.out.println("Item ID: " + pos);
        System.out.println("Nome: " + listaItens[pos].nome);
        System.out.println("Preco: " + listaItens[pos].preco);
        System.out.println("Descricao: " + listaItens[pos].descricao);
        System.out.println();

        System.out.print("Novo Nome: ");
        listaItens[pos].nome = HummPizzaiolo.leia.next();
        System.out.print("Novo Preco: ");
        listaItens[pos].preco = HummPizzaiolo.leia.next();
        System.out.print("Nova Descricao: ");
        listaItens[pos].descricao = HummPizzaiolo.leia.next();
    }

    static void itemExcluir(Item[] listaItens, int ultimo, int pos) {
        for (int i = pos + 1; i < ultimo; i++) {
            listaItens[i - 1] = listaItens[i];
        }
        listaItens[ultimo - 1] = null;
    }

    public static void gravarXML(String xml, String nome) {
        try {
            FileWriter w = new FileWriter("item" + nome + ".xml");
            w.write(xml);
            w.close();
        } catch (Exception e) {
            System.out.println("Erro ao gravar o xml. \n" + e);
        }
    }

}

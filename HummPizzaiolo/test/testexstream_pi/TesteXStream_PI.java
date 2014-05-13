package testexstream_pi;

import com.senac.pi.Pessoa;
import com.senac.pi.Telefone;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class TesteXStream_PI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        serializarXML();
        deserializarXML();
    }
    
    public static void serializarXML() {
        /*
         * A biblioteca XStream foi criada visando facilitar a 
         * manipulação de XML em Java, através da serialização/deserialização de 
         * objetos usando representação em XML. 
         * Veremos nesse exemplo como trabalhar com essa biblioteca.
         * 
         */
        XStream xstream = new XStream();
        
        Telefone telefone = new Telefone();
        telefone.codigo=11;
        telefone.numero="5555-9990";

        Pessoa pessoa = new Pessoa();
        pessoa.nome="Alessandra Lima";
        pessoa.email="alessandra.laguiar@sp.senac.br";
        pessoa.telefone=telefone;
  
        /* o XStream gera uma String em formato de XML, 
        // e não o arquivo XML propriamente dito, mas este é gerado com a ajuda 
        * do FileOutputStream do Java.
        */
        String xml = xstream.toXML(pessoa);
        
        System.out.println(xml); 
        
        // Deserializando objeto 
        Pessoa novaPessoa = (Pessoa)xstream.fromXML(xml); 
        
        System.out.println("Nome = " + novaPessoa.nome); 
        System.out.println("e-mail = " + novaPessoa.email);    
        
        // Gerar o arquivo fisicamente
        gravarXML(xml);
    }
    
    
    public static void deserializarXML(){
        XStream xstream = new XStream();

        Pessoa pessoa = new Pessoa();
        pessoa.nome="MAria";
        pessoa.email="xpto";
        xstream.alias("Pessoa", Pessoa.class);       
        String xml = xstream.toXML(pessoa);
        
        // Deserializando objeto 
        Pessoa novaPessoa = (Pessoa)xstream.fromXML(xml); 
        
        System.out.println("Nome = " + novaPessoa.nome); 
        System.out.println("e-mail = " + novaPessoa.email); 
        
        System.out.println("*****************");
        System.out.println("Ler o arquivo " + lerXML());
    }
    
    public static void gravarXML(String xml) {
        try{
            FileWriter w = new FileWriter("teste.xml");
            w.write(xml);
            w.close();
        }catch (Exception e) {
            System.out.println("Erro ao gravar o xml " + e);
        }
    }
    
    public static String lerXML(){
        try{
            Scanner in = new Scanner(new File("teste.xml"));
            StringBuilder sb = new StringBuilder();
            while (in.hasNext()) {
                sb.append(in.next());
            }
            in.close();
            return sb.toString();
        }catch (Exception e) {
            System.out.println("Erro ao gravar o xml " + e);
        }
        return "";
    }

}

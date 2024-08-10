package br.com.syonet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class App extends Utils {
    public static void main( String[] args ){
        
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1,"Maria"));
        clientes.add(new Cliente(2,"Joao"));
        clientes.add(new Cliente(3,"Marcio"));
        clientes.add(new Cliente(4,"Janaina"));
        clientes.add(new Cliente(5,"Bruno"));

        Campanha campanha = new Campanha(clientes);
        campanha.executar();

        /*//Buscar pelo ID
        Map<Integer,String> itens = new HashMap<>();
        
        itens.put(1,"Maria");
        itens.put(2,"Joao");
        itens.put(3,"Carlos");

        String maria = itens.get(1);
        Utils.print(maria);
        
        itens.values().stream()
            .map(Pessoa::new)
            .map(Pessoa::apresentacao)
            .forEach(apresentacao ->{
                String auxiliar = apresentacao + " - Felicidade";
                Utils.print(auxiliar);
            });*/
    }
}
/*
class Pessoa {
    String nome;

    //Construtor
    Pessoa(String nome){
        this.nome = nome;
    }

    public String apresentacao(){
        return """
        Ola!
        Eu meu chamo %s!      
        """.formatted(this.nome);
    } 
}
*/

class Cliente {
    Integer id;
    String nome;

    //Construtor
    Cliente(int id,String nome){
        this.id = id;
        this.nome = nome;
    }

    /*public String apresentacao(){
        return """
        Ola!
        Eu meu chamo %s!      
        """.formatted(this.nome);
    }*/ 

    public String toString(){
        return this.nome;
    }
}

class Campanha {
    Map<Character, List<Cliente>> map = new HashMap<>();

    Campanha(List<Cliente> clientes){
        clientes.forEach(c -> map.compute(c.nome.charAt(0),(k,v) ->{
            if (v != null){
                v.add(c);
                return v;
            }
            List<Cliente> nV = new ArrayList<>();
            nV.add(c);
            return nV;
        }));
    }

    void executar() {
        this.map.get('M').stream().forEach(c -> Utils.print("Tem email manda email - "+c));
        this.map.get('J').stream().forEach(c -> Utils.print("Sem email mas com telefone manda sms - "+c));
    }
}
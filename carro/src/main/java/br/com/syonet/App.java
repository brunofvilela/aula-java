package br.com.syonet;
import java.util.List;

public class App 
{
    public static void main( String[] args ){
        String[][] matriz = {
            {"Nome","Telefone","email"},
            {"Maria","5199999999","maria@gmail.com"},
            {"Maria","5199999999","maria@gmail.com"},
            {"Maria","5199999999","maria@gmail.com"},
            {"Maria","5199999999","maria@gmail.com"},
        };

        for (int linha = 0; linha < matriz.length; linha++){
            for (int coluna = 0; coluna < matriz[linha].length; coluna++){
                System.out.print(matriz[linha][coluna]);
                if (coluna != matriz[linha].length -1){
                    System.out.print("||");
                }
            }
            Utils.print("");
        }

        Utils.print("-----------------");

        List<List<String>> tabela = List.of(
            List.of("Nome","Telefone","email"),
            List.of("Maria","5199999999","maria@gmail.com")
        );
        /*for (int linha = 0; linha < tabela.size(); linha++){
            for (int coluna = 0; coluna < tabela.get(linha).size(); coluna++){
                System.out.print(tabela.get(linha).get(coluna));
                if (coluna != tabela.get(linha).size() -1){
                    System.out.print("||");
                }
            }
            Utils.print("");
        }*/
        tabela.forEach(row -> {
            System.out.println();
            row.forEach(celula ->{
                System.out.print(celula + "||");
            });
        }
        );
    }
}

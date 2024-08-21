package br.com.syonet;

import java.io.IOException;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        try {
            String caminhoArquivoCSV = "arquivo_fornecido.csv";
            List<Filial> filiais = NIOFileReader.lerArquivoCSV(caminhoArquivoCSV);

            Filial filialComMaiorMedia = null;
            double maiorMedia = 0.0;

            for (Filial filial : filiais) {
                double media = filial.calcularMediaMensal();
                if (media > maiorMedia) {
                    maiorMedia = media;
                    filialComMaiorMedia = filial;
                }
            }

            if (filialComMaiorMedia != null) {
                System.out.println("A filial com a maior média de visitas é: " + filialComMaiorMedia.getNome());
                System.out.println("Média de visitas: " + maiorMedia);
            } else {
                System.out.println("Nenhuma filial encontrada.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

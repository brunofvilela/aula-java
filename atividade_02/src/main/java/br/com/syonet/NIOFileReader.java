package br.com.syonet;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class NIOFileReader {
    public static List<Filial> lerArquivoCSV(String caminhoArquivo) throws IOException {
        List<Filial> filiais = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(caminhoArquivo);
             FileChannel fileChannel = fis.getChannel()) {

            ByteBuffer buffer = ByteBuffer.allocate(1024);  
            StringBuilder linhaAtual = new StringBuilder();
            boolean isFirstLine = true;

            while (fileChannel.read(buffer) > 0) {
                buffer.flip();  // Prepara o buffer para leitura

                while (buffer.hasRemaining()) {
                    char ch = (char) buffer.get();

                    if (ch == '\n') {
                        if (isFirstLine) {
                            isFirstLine = false;  // Ignora a primeira linha (cabeçalho)
                        } else {
                            processarLinha(linhaAtual.toString(), filiais);
                        }
                        linhaAtual.setLength(0); 
                    } else {
                        linhaAtual.append(ch);
                    }
                }

                buffer.clear();  // Limpa o buffer para a próxima leitura
            }

            if (linhaAtual.length() > 0 && !isFirstLine) {
                processarLinha(linhaAtual.toString(), filiais);
            }
        }

        return filiais;
    }

    private static void processarLinha(String linha, List<Filial> filiais) {
        String[] dados = linha.split(",");

        if (dados.length >= 18) {  
            String nome = dados[0];
            String endereco = dados[1];
            String cidade = dados[2];
            String codigoPostal = dados[3];
            List<Integer> visitasMensais = new ArrayList<>();
            for (int i = 4; i <= 15; i++) {
                visitasMensais.add(Integer.parseInt(dados[i]));
            }
            int visitasAnuais = Integer.parseInt(dados[16]);
            String geolocalizacao = dados[17];

            Filial filial = new Filial(nome, endereco, cidade, codigoPostal, visitasMensais, visitasAnuais, geolocalizacao);
            filiais.add(filial);
        }
    }
}
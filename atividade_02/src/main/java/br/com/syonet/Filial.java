package br.com.syonet;

import java.util.List;

public class Filial {
    String nome;
    String endereco;
    String cidade;
    String codigoPostal;
    List<Integer> visitasMensais;
    int visitasAnuais;
    String geolocalizacao;

    // Construtor
    public Filial(String nome, String endereco, String cidade, String codigoPostal,
                  List<Integer> visitasMensais, int visitasAnuais, String geolocalizacao) {
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.codigoPostal = codigoPostal;
        this.visitasMensais = visitasMensais;
        this.visitasAnuais = visitasAnuais;
        this.geolocalizacao = geolocalizacao;
    }

    public String getNome() {
        return nome;
    }

    // Calcular a média mensal de visitas
    public double calcularMediaMensal() {
        return visitasAnuais / 12.0;
    }
}

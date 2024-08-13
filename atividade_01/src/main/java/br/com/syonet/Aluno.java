package br.com.syonet;

import java.util.List;

public class Aluno {

    String nome;
    String matricula;
    double nota;

    // Construtor
    public Aluno(String nome, String matricula, double nota) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota = nota;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return """
            {
            "nome": "%s",
            "matricula": "%s",
            "nota": %.2f
            }
            """.formatted(this.nome,this.matricula,this.nota);
    }

    //  2 - Crie a interface Gerenciamento:
    public interface Gerenciamento {    
    void adicionarAluno(Aluno aluno);
    void removerAluno(String matricula);
    List<Aluno> listarAlunos();
    double calcularMedia();}
}


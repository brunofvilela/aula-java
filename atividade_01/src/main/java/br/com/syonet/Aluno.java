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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aluno other = (Aluno) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (matricula == null) {
            if (other.matricula != null)
                return false;
        } else if (!matricula.equals(other.matricula))
            return false;
        if (Double.doubleToLongBits(nota) != Double.doubleToLongBits(other.nota))
            return false;
        return true;
    }

    //  2 - Crie a interface Gerenciamento:
    public interface Gerenciamento {    
    void adicionarAluno(Aluno aluno);
    void removerAluno(String matricula);
    List<Aluno> listarAlunos();
    double calcularMedia();}
}


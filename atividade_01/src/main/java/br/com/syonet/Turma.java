package br.com.syonet;

import java.util.ArrayList;
import java.util.List;
import br.com.syonet.Aluno.Gerenciamento;

public class Turma implements Gerenciamento {
    // Use uma ArrayList<Aluno> para armazenar os alunos
    ArrayList<Aluno> alunos = new ArrayList<>();

    //Implemente os métodos da interface Gerenciamento
    @Override
    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    @Override
    public void removerAluno(String matricula) {
        alunos.removeIf(aluno -> aluno.getMatricula().equals(matricula));
    }

    @Override
    public List<Aluno> listarAlunos() {
        return new ArrayList<>(alunos);
    }

    //Calculo da Média
    @Override
    public double calcularMedia() {
        if (alunos.isEmpty()) return 0.0;
        double somaNotas = 0.0;
        for (Aluno aluno : alunos) {
            somaNotas += aluno.getNota();
        }
        return somaNotas / alunos.size();
    }
}


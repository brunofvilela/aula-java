package br.com.syonet;

import br.com.syonet.Aluno.Gerenciamento;

public class App 
{
    public static void main( String[] args ){

        //4 - Crie a classe Principal (Main) para testar o sistema
        // Instância da classe Turma
        Gerenciamento gerenciamento = new Turma();

        gerenciamento.adicionarAluno(new Aluno("Cassio", "001", 9.5));
        gerenciamento.adicionarAluno(new Aluno("Joao", "002", 6.8));
        gerenciamento.adicionarAluno(new Aluno("Maria", "003", 8.4));
        gerenciamento.adicionarAluno(new Aluno("Bruno", "004", 8.5));
        
        // Liste todos os alunos
        System.out.print("Lista de Alunos:");
        for (Aluno aluno : gerenciamento.listarAlunos()) {
            System.out.print(aluno);
        }
        
        // Media de todos alunos
        double media = gerenciamento.calcularMedia();
        System.out.println("Média das Notas: " + String.format("%.2f", media));

        System.out.println("-------------------------------------------------");

        // Remova um aluno com uma matrícula específica e listamos os alunos restantes
        gerenciamento.removerAluno("003");
        System.out.println("Lista de alunos após remoção:");
        for (Aluno aluno : gerenciamento.listarAlunos()) {
            System.out.print(aluno);
        }

        // Media dos alunos após remoção
        double media2 = gerenciamento.calcularMedia();
        System.out.println("Média das Notas após remoção: " + String.format("%.2f", media2));
    }
}
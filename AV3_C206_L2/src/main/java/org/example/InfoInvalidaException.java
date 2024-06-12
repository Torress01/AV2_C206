package org.example;

public class InfoInvalidaException extends Exception{
    public InfoInvalidaException() {
        System.out.println("\n===============");
        System.out.println("""
                Nenhum aluno pode ter:\s
                - Matricula menor ou igual a 0
                - Curso diferente de Computação Software ou Telecomunicações
                """);
    }
}

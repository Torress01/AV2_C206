package org.example;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        Arquivo arq = new Arquivo();
        boolean running = true;
        ArrayList<Aluno> alunos;

        while (running) {
            alunos = arq.ler();

            if(alunos.isEmpty()){
                System.out.println("Lista vazia.");
            }

            // Menu
            System.out.println("""
                    Seleciona uma opcao:\s
                    1. Cadastrar aluno
                    2. Listar alunos 
                    3. Ordenar alunos por media crescente 
                    4. Quantidade de cada aluno em cada curso
                    """);
            System.out.print("-> ");
            int userInput = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (userInput) {
                case 1 -> {
                    Aluno aluno = new Aluno();

                    try {
                        System.out.print("Nome: ");
                        aluno.setNome(sc.nextLine());

                        System.out.print("Curso: (software, computacao ou telecomunicaocoes):");
                        String curso = sc.nextLine();
                        if(!curso.equalsIgnoreCase("computacao") && !curso.equalsIgnoreCase("software") && !curso.equalsIgnoreCase("telecomunicacoes")){
                            throw new InfoInvalidaException();
                        }
                        aluno.setCurso(curso);

                        System.out.print("Matricula: ");
                        int matricula = sc.nextInt();
                        if (matricula < 0d){
                            throw new InfoInvalidaException();
                        }
                        aluno.setMatricula(matricula);

                        System.out.print("| Insira a media com vírgula!!! | Media: ");
                        float media = sc.nextFloat();
                        aluno.setMedia(media);


                        System.out.println();
                    } catch (InfoInvalidaException e) {
                        System.out.println(e);
                        System.out.println("====================\n");
                        break;
                    }
                    arq.escrever(aluno);
                }
                case 2 -> {
                    System.out.println("Lista de alunos:");
                    System.out.println("| --------------------");
                    for (Aluno a : alunos) {
                        a.mostrarInfos();
                    }
                    System.out.println();
                }
                case 3 -> {
                    Collections.sort(alunos);

                    if(alunos.isEmpty()){
                        System.out.println("| Vazio");
                        break;
                    }

                    System.out.println("Em ordem crescente:");
                    System.out.println("| --------------------");
                    for (Aluno a : alunos) {
                        a.mostrarInfos();
                    }
                    System.out.println();
                }
                case 4 -> {
                    System.out.println("Quantidade de alunos de cada curso disponíveis: ");
                    System.out.println("| --------------------");

                    int soft = 0;
                    int comp = 0;
                    int telec = 0;

                    for (Aluno a : alunos) {
                        if(a.getCurso().equalsIgnoreCase("software")) {
                            soft += 1;
                        }
                        else if(a.getCurso().equalsIgnoreCase("computacao")) {
                            comp += 1;
                        }
                        else if(a.getCurso().equalsIgnoreCase("telecomunicacoes")) {
                            telec += 1;
                        }
                    }

                    System.out.println("| Software: " + soft);
                    System.out.println("| Computação: " + comp);
                    System.out.println("| Telecomunicações: " + telec);
                    System.out.println("| --------------------");
                    System.out.println();
                }
                default -> {
                    System.out.println("Até logo\n");
                    running = false;
                }
            }
        }
        sc.close();
    }
}
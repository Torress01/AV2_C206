package org.example;

import java.util.concurrent.ConcurrentMap;

public class Aluno implements Comparable<Aluno> {
    private String Nome;
    private int Matricula;
    private String Curso;
    private float Media;

    public void mostrarInfos(){
        System.out.println("| Nome: " + this.Nome);
        System.out.println("| Matricula: " + this.Matricula);
        System.out.println("| Cursp: " + this.Curso);
        System.out.println("| Media: " + this.Media);
        System.out.println("| --------------------");
    }

    @Override
    public int compareTo(Aluno a) {
        return Double.compare(this.Media, a.getMedia());
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public int getMatricula() {
        return Matricula;
    }

    public void setMatricula(int matricula) {
        Matricula = matricula;
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String curso) {
        Curso = curso;
    }

    public float getMedia() {
        return Media;
    }

    public void setMedia(float media) {
        Media = media;
    }
}

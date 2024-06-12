package org.example;
import java.io.*;
import java.util.ArrayList;


public class Arquivo {
    public void escrever(Aluno aluno){
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        String line;

        try{
            os = new FileOutputStream("alunos.txt", true);
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);

            // Flags
            bw.write("++ Aluno ++\n");
            bw.write(aluno.getNome() + "\n");
            bw.write(aluno.getMatricula() + "\n");
            bw.write(aluno.getCurso() + "\n");
            bw.write(aluno.getMedia() + "\n");
        }
        catch(Exception e){
            System.out.println("ERRO: " + e);
        }
        finally{
            try{
                bw.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }



    public ArrayList<Aluno> ler() {
        // ArrayList auxiliar para salvar aluno encontrados no arquivo
        ArrayList<Aluno> encontreiOAluno = new ArrayList<>();

        // Classes que permitem leitura de dados do arquivo
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        // Variável auxiliar que servirá de flag para o while
        String lineReader;

        try {
            is = new FileInputStream("alunos.txt");
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            // Colocando o cursor no inicio do arquivo
            lineReader = br.readLine();

            while (lineReader != null) {
                // Comparando se o que está em lineReader é igual a minha flag
                if(lineReader.contains("++ Aluno ++")){
                    // Variável auxiliar de aluno
                    Aluno alunoaux = new Aluno();

                    // Criando um filme com as variáveis auxiliares
                    alunoaux.setNome(br.readLine());
                    alunoaux.setMatricula(Integer.parseInt(br.readLine()));
                    alunoaux.setCurso(br.readLine());
                    alunoaux.setMedia(Float.parseFloat(br.readLine()));


                    // Adicionando o filme no arrayList de Filme
                    encontreiOAluno.add(alunoaux);
                }
                lineReader = br.readLine();
            }
        }
        catch (Exception e) {
            System.out.println("ERRO: " + e);
        }
        finally {
            try {
                br.close();
            }
            catch (Exception e) {
                System.out.println("ERRO: " + e);
            }
        }
        return encontreiOAluno;
    }
}

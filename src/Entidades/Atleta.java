package Entidades;

import java.util.Scanner;

public class Atleta{

    Scanner entrada = new Scanner(System.in);

    public int numeroAtletas = entrada.nextInt();

    //ATRIBUINDO O TAMANHO DO ARRAY CONFORME O USUARIO DESEJAR
    public String[] nomes = new String[numeroAtletas];
    String[] pais = new String[numeroAtletas];
    char[] sexos = new char[numeroAtletas];
    float[] temposClassif = new float[numeroAtletas];
    float[] temposFinal = new float[numeroAtletas];

    public String lerPais() {
        Scanner input = new Scanner(System.in);
        String pais;
        do {
            System.out.print("Digite o país (México, Canadá ou USA): ");
            pais = input.nextLine().toUpperCase();
        } while (!pais.equals("MEXICO") && !pais.equals("CANADA") && !pais.equals("USA"));
        return pais;
    }

    public char lerSexo() {
        Scanner input = new Scanner(System.in);
        char sexo;

        do {
            System.out.println("Digite o sexo (M/F): ");
            sexo = input.next().toUpperCase().charAt(0);
        } while (sexo != 'M' && sexo != 'F');

        return sexo;
    }

    public float lerTempoClassif() {
        Scanner input = new Scanner(System.in);

        do {
            System.out.print("Digite o tempo de classificação do atleta: ");
            float tempoClassificacao = input.nextFloat();

            if (tempoClassificacao >= 8.0 && tempoClassificacao <= 25.5 ) {
                return tempoClassificacao;
            } else {
                System.out.println("Tempo inválido. O tempo deve estar entre 8.0 e 25.5 segundos.");
            }
        } while (true);

    }

    public float lerTempoFinal() {
        Scanner input = new Scanner(System.in);

        do {
            System.out.print("Digite o tempo final do atleta: ");
            float tempoFinal = input.nextFloat();
            if (tempoFinal >= 8.0 && tempoFinal <= 25.5 ) {
                return tempoFinal;
            } else {
                System.out.println("Tempo inválido. O tempo deve estar entre 8.0 e 25.5 segundos.");
            }
        } while (true);

    }

    public static void verificarPais(String nomes[], String pais[], String paisConsulta){
        boolean encontrado = false; // Flag para indicar se algum atleta foi encontrado

        for (int i = 0; i < nomes.length; i++) { // Percorre todos os atletas
            if (pais[i].equals(paisConsulta)) {
                System.out.println(nomes[i]); // Imprime o nome do atleta
                encontrado = true;
            }
        }
    }



}
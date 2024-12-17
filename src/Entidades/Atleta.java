package Entidades;

import java.util.Scanner;

public class Atleta{

    String nomesMexicoo="";
    String nomesCanada="";
    String nomesUSA= "";
    String nomeMelhorTempo = "";

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


    public String verificarPais(){
        Scanner entrada = new Scanner(System.in);

        String nomesPaises;
        String nomesMexico="";
        String nomesCanada="";
        String nomesUSA= "";

        System.out.println("Qual pais você deseja saber os nomes dos atletas? (México, Canadá ou USA:)");
        nomesPaises = entrada.next().toUpperCase();

        switch (nomesPaises) {

            case "MEXICO":
                if (nomesMexico == "") {
                    System.out.println("Não existe jogadores neste pais!");
                }else {
                    System.out.println("Atletas do México: ");
                    System.out.println(nomesMexico);
                }
                break;

            case "CANADA":
                if (nomesCanada == "") {
                    System.out.println("Não existe jogadores neste pais!");
                }else {
                    System.out.println("Atletas do Canada: ");
                    System.out.println(nomesCanada);
                }
                break;

            case "USA":
                if (nomesUSA == "") {
                    System.out.println("Não existe jogadores neste pais!");
                }else {
                    System.out.println("Atletas do USA: ");
                    System.out.println(nomesUSA);
                }
                break;

            default:
                System.out.println("País inválido!");
                break;

        }

        return nomesPaises;

    }
}
package Entidades;

import java.util.Scanner;

public class Atleta {

    private int numeroAtletas;
    private String[] nomes;
    private String[] pais;
    private char[] sexos;
    private float[] temposClassif;
    private float[] temposFinal;

    private Scanner entrada = new Scanner(System.in);

    // Metodo para iniciar a coleta de dados
    public void inicializarDados() {
        System.out.print("Digite o número de atletas para inserir no sistema: ");
        numeroAtletas = entrada.nextInt();
        entrada.nextLine();

        // Inicializando arrays
        nomes = new String[numeroAtletas];
        pais = new String[numeroAtletas];
        sexos = new char[numeroAtletas];
        temposClassif = new float[numeroAtletas];
        temposFinal = new float[numeroAtletas];

        // Coletando dados dos atletas
        for (int i = 0; i < numeroAtletas; i++) {
            System.out.println("Atleta " + (i + 1) + ":");
            System.out.print("Digite o nome do atleta: ");
            nomes[i] = entrada.nextLine();

            pais[i] = lerPais();
            sexos[i] = lerSexo();
            temposClassif[i] = lerTempoClassif();
            temposFinal[i] = lerTempoFinal();
        }
    }

    private String lerPais() {
        String paisInput;
        do {
            System.out.print("Digite o país (México, Canadá ou USA): ");
            paisInput = entrada.nextLine().toUpperCase();
            if (!paisInput.equals("MEXICO") && !paisInput.equals("CANADA") && !paisInput.equals("USA")) {
                System.out.println("País inválido. Escolha entre México, Canadá ou USA.");
            }
        } while (!paisInput.equals("MEXICO") && !paisInput.equals("CANADA") && !paisInput.equals("USA"));
        return paisInput;
    }

    private char lerSexo() {
        char sexoInput;
        do {
            System.out.print("Digite o sexo (M/F): ");
            sexoInput = entrada.next().toUpperCase().charAt(0);
            entrada.nextLine();
            if (sexoInput != 'M' && sexoInput != 'F') {
                System.out.println("Sexo inválido. Digite 'M' para masculino ou 'F' para feminino.");
            }
        } while (sexoInput != 'M' && sexoInput != 'F');
        return sexoInput;
    }

    private float lerTempoClassif() {
        float tempo;
        do {
            System.out.print("Digite o tempo de classificação entre (8.0 a 25.5 segundos): ");
            tempo = entrada.nextFloat();
            if (tempo < 8.0 || tempo > 25.5) {
                System.out.println("Tempo inválido. O tempo deve estar entre 8.0 e 25.5 segundos.");
            }
        } while (tempo < 8.0 || tempo > 25.5);
        entrada.nextLine();
        return tempo;
    }

    private float lerTempoFinal() {
        float tempo;
        do {
            System.out.print("Digite o tempo final entre (8.0 a 25.5 segundos): ");
            tempo = entrada.nextFloat();
            if (tempo < 8.0 || tempo > 25.5) {
                System.out.println("Tempo inválido. O tempo deve estar entre 8.0 e 25.5 segundos.");
            }
        } while (tempo < 8.0 || tempo > 25.5);
        entrada.nextLine();
        return tempo;
    }

    public void verificarPais() {
        System.out.print("Digite o país para consultar os atletas (México, Canadá ou USA): ");
        String paisConsulta = entrada.nextLine().toUpperCase();

        boolean encontrado = false;

        System.out.println("Atletas do país " + paisConsulta + ":");
        for (int i = 0; i < numeroAtletas; i++) {
            if (pais[i].equals(paisConsulta)) {
                System.out.println("- " + nomes[i] + " (" + (sexos[i] == 'M' ? "Masculino" : "Feminino") + ")");
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum atleta encontrado do país informado.");
        }
    }

    public void mediaTempos(){

        int caculatemposFinalM =0,caculatemposFinalF =0;
        float mediaM = 0, mediaF = 0;
        float calculamediaM=0, calculamediaF=0;

        float melhorTempoClassificatoria = Float.MAX_VALUE;
        String nomeMelhorTempoClassificatoria = "";
        char sexoMelhorTempoClassificatoria = ' ';

        for (int i = 0; i < numeroAtletas; i++) {

            //VERIFICANDO SE O SEXO É M, SE FOR ADICIONA O TEMPO FINAL AO VALOR DA VARIAVEL CALCULAMEDIA
            // E CONTA +1 NO TEMPOSFINALm
            if(sexos[i] == 'M'){
                calculamediaM += temposFinal[i] ;
                caculatemposFinalM++;

            }
            //VERIFICANDO SE O SEXO É F, SE FOR ADICIONA O TEMPO FINAL AO VALOR DA VARIAVEL CALCULAMEDIA
            // E CONTA +1 NO TEMPOSFINALf
            else if(sexos[i] == 'F'){
                calculamediaF += temposFinal[i] ;
                caculatemposFinalF++;
            }

            //Visualizar os dados do atleta pode ser um homem ou uma mulher com melhor tempo na etapa classificatória
            if(temposClassif[i] < melhorTempoClassificatoria){
                melhorTempoClassificatoria = temposClassif[i];
                nomeMelhorTempoClassificatoria = nomes[i];
                sexoMelhorTempoClassificatoria = sexos[i];
            }

        }
        if (caculatemposFinalM >0){
            mediaM = calculamediaM/caculatemposFinalM;
        }
        if (calculamediaF > 0){
            mediaF = calculamediaF/caculatemposFinalF;
        }

        //EXIBINDO OS RESULTADOS
        System.out.println("Média dos tempos finais dos homens: " + (calculamediaM > 0 ? mediaM : "Nenhum homem registrado."));
        System.out.println("Média dos tempos finais das mulheres: " + (caculatemposFinalF > 0 ? mediaF : "Nenhuma mulher registrada."));

        System.out.println("Atleta com o melhor tempo na etapa classificatória:");
        if (!nomeMelhorTempoClassificatoria.isEmpty()) {
            System.out.println("- Nome: " + nomeMelhorTempoClassificatoria);
            System.out.println("- Sexo: " + (sexoMelhorTempoClassificatoria == 'M' ? "Masculino" : "Feminino"));
            System.out.println("- Tempos: " + melhorTempoClassificatoria + " segundos");
        } else {
            System.out.println("Nenhum atleta registrado.");
        }



    }

}

package Entidades;

import java.util.Scanner;

public class Atleta {

    private int numeroAtletas;
    private String[] nomes;
    private String[] pais;
    private char[] sexos;
    private float[] temposClassificacao;
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
        temposClassificacao = new float[numeroAtletas];
        temposFinal = new float[numeroAtletas];

        // Coletando dados dos atletas
        for (int i = 0; i < numeroAtletas; i++) {
            System.out.println((i + 1) + "º" + " Atleta " + ":");
            System.out.print("Digite o nome do atleta: ");
            nomes[i] = entrada.nextLine();

            pais[i] = lerPais();
            sexos[i] = lerSexo();
            temposClassificacao[i] = lerTempoClassificacao();
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

    private float lerTempoClassificacao() {
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

    public void mediaTempos() {

        int caculatemposFinalM = 0, caculatemposFinalF = 0;
        float mediaM = 0, mediaF = 0;
        float calculamediaM = 0, calculamediaF = 0;

        float melhorTempoClassificatoria = Float.MAX_VALUE;
        String nomeMelhorTempoClassificatoria = "";
        char sexoMelhorTempoClassificatoria = ' ';

        for (int i = 0; i < numeroAtletas; i++) {

            //VERIFICANDO SE O SEXO É M, SE FOR ADICIONA O TEMPO FINAL AO VALOR DA VARIAVEL CALCULAMEDIA
            // E CONTA +1 NO TEMPOSFINALm
            if (sexos[i] == 'M') {
                calculamediaM += temposFinal[i];
                caculatemposFinalM++;

            }
            //VERIFICANDO SE O SEXO É F, SE FOR ADICIONA O TEMPO FINAL AO VALOR DA VARIAVEL CALCULAMEDIA
            // E CONTA +1 NO TEMPOSFINALf
            else if (sexos[i] == 'F') {
                calculamediaF += temposFinal[i];
                caculatemposFinalF++;
            }

            //Visualizar os dados do atleta pode ser um homem ou uma mulher com melhor tempo na etapa classificatória
            if (temposClassificacao[i] < melhorTempoClassificatoria) {
                melhorTempoClassificatoria = temposClassificacao[i];
                nomeMelhorTempoClassificatoria = nomes[i];
                sexoMelhorTempoClassificatoria = sexos[i];
            }

        }
        if (caculatemposFinalM > 0) {
            mediaM = calculamediaM / caculatemposFinalM;
        }
        if (calculamediaF > 0) {
            mediaF = calculamediaF / caculatemposFinalF;
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

    public void melhorTempo() {
        float tempoMelhor = Float.MAX_VALUE;
        String nomeMelhorTempo = "";
        char sexoMelhorTempo = ' ';
        String paisMelhorTempo = "";

        for (int i = 0; i < numeroAtletas; i++) {

            //Função Math.min é usada para determinar o menor valor entre temposFinal[i] e temposClassificacao[i]
            float menorTempo = Math.min(temposFinal[i], temposClassificacao[i]);
            if (menorTempo < tempoMelhor) {
                tempoMelhor = menorTempo;
                nomeMelhorTempo = nomes[i];
                sexoMelhorTempo = sexos[i];
                paisMelhorTempo = pais[i];
            }
        }

        System.out.println("Melhor tempo é de: " + tempoMelhor + "s");
        System.out.println("- Nome: " + nomeMelhorTempo);
        System.out.println("- Sexo: " + (sexoMelhorTempo == 'M' ? "Masculino" : "Feminino"));
        System.out.println("- País: " + paisMelhorTempo);
    }

    public void melhorTemposHomens() {
        float tempoHomensFinalM = 0, tempoHomensFinalC = 0, tempoHomensFinalU = 0;
        int contagemHomensM = 0, contagemHomensC = 0, contagemHomensU = 0;

        for (int i = 0; i < numeroAtletas; i++) {
            if (sexos[i] == 'M') {
                switch (pais[i].toUpperCase()) {
                    case "MEXICO":
                        tempoHomensFinalM += temposFinal[i];
                        contagemHomensM++;
                        break;
                    case "CANADA":
                        tempoHomensFinalC += temposFinal[i];
                        contagemHomensC++;
                        break;
                    default:
                        tempoHomensFinalU += temposFinal[i];
                        contagemHomensU++;
                        break;
                }
            }
        }

        System.out.println("Qual país você deseja saber a média dos homens?");
        String paisConsulta = entrada.nextLine().toUpperCase();

        float mediaFinalHomens;
        switch (paisConsulta) {
            case "MEXICO":
                mediaFinalHomens = contagemHomensM > 0 ? tempoHomensFinalM / contagemHomensM : 0;
                break;
            case "CANADA":
                mediaFinalHomens = contagemHomensC > 0 ? tempoHomensFinalC / contagemHomensC : 0;
                break;
            default:
                mediaFinalHomens = contagemHomensU > 0 ? tempoHomensFinalU / contagemHomensU : 0;
                break;
        }
        System.out.println("Média final dos homens do país " + paisConsulta + ": " + mediaFinalHomens);
    }

    public void mostrarAtletasPorSexo() {
        String atletasSelecionados = "";

        System.out.println("Digite o sexo dos atletas que você deseja ver (M/F): ");
        char sexoConsulta = entrada.next().toUpperCase().charAt(0);

        for (int i = 0; i < numeroAtletas; i++) {
            if ((sexoConsulta == 'M' && sexos[i] == 'M') || (sexoConsulta == 'F' && sexos[i] == 'F')) {
                atletasSelecionados += nomes[i] + ", ";
            }
        }
        if (!atletasSelecionados.isEmpty()) {
            System.out.println("Atletas selecionados: " + atletasSelecionados.substring(0, atletasSelecionados.length() - 2));
        } else {
            System.out.println("Nenhum atleta encontrado para o sexo escolhido.");
        }
    }

}


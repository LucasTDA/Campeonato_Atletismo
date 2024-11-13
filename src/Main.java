//Observe que o país só poderá ser México, Canadá ou USA,
// o sexo só poderá ser F ou M
// o tempo obtido pelo atleta deverá ser um valor entre 8.0 e 25.5 segundos (terá que ser maior ou
//igual que 8.0 e menor ou igual que 25.5 segundos)...

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        Scanner entrada = new Scanner(System.in);

        int numeroAtletas,caculatemposFinalM =0,caculatemposFinalF =0;
        float mediaM = 0, mediaF = 0, calculamediaM=0, calculamediaF=0;
        float melhortempo = Float.MAX_VALUE;

        String nomesMexico="";
        String nomesCanada="";
        String nomesUSA= "";
        String nomeMelhorTempo = "";

        // DEFININDO O TAMNHO DO ARRAY CONFORME O USUARIO QUER;
        System.out.println("Digite a quantidade de atletas");
        numeroAtletas = entrada.nextInt();

        //ATRIBUINDO O TAMANHO DO ARRAY CONFORME O USUARIO DESEJAR
        String[] nomes = new String[numeroAtletas];
        String[] pais = new String[numeroAtletas];
        char[] sexos = new char[numeroAtletas];
        float[] temposClassif = new float[numeroAtletas];
        float[] temposFinal = new float[numeroAtletas];

        //ADICIONANDO ITENS AOS ARRAY, ATRAVÉS DAS FUNÇÕES
        for (int i = 0; i < numeroAtletas; i++) {
            System.out.println((i + 1) +"º" +"Atleta ");

            System.out.println("NOME: ");
            nomes[i] = entrada.next();

            //ATRIBUANDO A POSIÇÃO DO VETOR A PARTIR DE 0 COM AS FUNÇÕES
            pais[i] = lerPais();
            sexos[i] = lerSexo();
            temposClassif[i] = lerTempoClassif();
            temposFinal[i] = lerTempoFinal();

            //VERIFICANDO SE O SEXO É M, SE FOR ADICIONA O TEMPO FINAL AO VALOR DA VARIAVEL CALCULAMEDIA
            // E CONTA +1 NO TEMPOSFINALm
            if(sexos[i] == 'M'){
                calculamediaM += temposFinal[i] ;
                caculatemposFinalM++;
                mediaM = calculamediaM/caculatemposFinalM;

            //VERIFICANDO SE O SEXO É F, SE FOR ADICIONA O TEMPO FINAL AO VALOR DA VARIAVEL CALCULAMEDIA
            // E CONTA +1 NO TEMPOSFINALf
            }
            else if(sexos[i] == 'F'){
                calculamediaF += temposFinal[i] ;
                caculatemposFinalF++;
                mediaF = calculamediaF/caculatemposFinalF;
            }

            //Visualizar os dados do atleta (pode ser um homem ou uma mulher) com melhor tempo
            //na etapa classificatória.
            if(temposClassif[i] < melhortempo){
            melhortempo = temposClassif[i];
            nomeMelhorTempo = nomes[i];
            }

            //ALOCANDO OS NOMES DOS ATLETAS EM VARIAVEIS PARA CADA PAIS E CONCATENANDO OS NOMES;
            switch (pais[i]){

                case "MEXICO":
                    nomesMexico += nomes[i] + ", ";
                    break;
                case "CANADA":
                    nomesCanada += nomes[i] + ", ";
                    break;
                case "USA":
                    nomesUSA += nomes[i] + ", ";
                    break;
                default:
                    return;
            }


        }

        //EXERCICIO 1
      // System.out.println("A Média final dos homens é:" + mediaM);
      // System.out.println("A Média final das mulheres é:" + mediaF);

        //EXERCICIO 2
      // System.out.println("Melhor tempo é " + melhortempo +"s" + " do(a) atleta: " + nomeMelhorTempo);

        //EXERCICIO 3
        System.out.println("Qual pais você deseja saber os nomes dos atletas?");

        if (nomesMexico == ""){
            System.out.println("Não existe jogadores neste pais!");
        }else {
            System.out.println(nomesMexico);
        }

    }

    //      ******************COMEÇO DAS FUNÇÕES******************      //

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


}


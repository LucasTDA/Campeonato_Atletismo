package Entidades;//Observe que o país só poderá ser México, Canadá ou USA,
// o sexo só poderá ser F ou M
// o tempo obtido pelo atleta deverá ser um valor entre 8.0 e 25.5 segundos (terá que ser maior ou
//igual que 8.0 e menor ou igual que 25.5 segundos)...

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        Atleta atleta = new Atleta();
        Scanner entrada = new Scanner(System.in);

        int caculatemposFinalM =0,caculatemposFinalF =0;
        float mediaM = 0, mediaF = 0, calculamediaM=0, calculamediaF=0;
        float melhortempo = Float.MAX_VALUE;


        // DEFININDO O TAMNHO DO ARRAY CONFORME O USUARIO QUER;
        System.out.println("Digite a quantidade de atletas");

        //ATRIBUINDO O TAMANHO DO ARRAY CONFORME O USUARIO DESEJAR
        String[] nomes = atleta.nomes;
        String[] pais = atleta.pais;
        char[] sexos = atleta.sexos;
        float[] temposClassif = atleta.temposClassif;
        float[] temposFinal = atleta.temposFinal;

        //ADICIONANDO ITENS AOS ARRAY, ATRAVÉS DAS FUNÇÕES
        for (int i = 0; i < atleta.numeroAtletas; i++) {
            System.out.println((i + 1) +"º" +"Atleta ");

            System.out.println("NOME: ");
            nomes[i] = entrada.next();

            //ATRIBUANDO A POSIÇÃO DO VETOR A PARTIR DE 0 COM AS FUNÇÕES
            pais[i] = atleta.lerPais();
            sexos[i] = atleta.lerSexo();
            temposClassif[i] = atleta.lerTempoClassif();
            temposFinal[i] = atleta.lerTempoFinal();

            //VERIFICANDO SE O SEXO É M, SE FOR ADICIONA O TEMPO FINAL AO VALOR DA VARIAVEL CALCULAMEDIA
            // E CONTA +1 NO TEMPOSFINALm
            if(sexos[i] == 'M'){
                calculamediaM += temposFinal[i] ;
                caculatemposFinalM++;
                mediaM = calculamediaM/caculatemposFinalM;
            }
            //VERIFICANDO SE O SEXO É F, SE FOR ADICIONA O TEMPO FINAL AO VALOR DA VARIAVEL CALCULAMEDIA
            // E CONTA +1 NO TEMPOSFINALf
            else if(sexos[i] == 'F'){
                calculamediaF += temposFinal[i] ;
                caculatemposFinalF++;
                mediaF = calculamediaF/caculatemposFinalF;
            }

            //Visualizar os dados do atleta (pode ser um homem ou uma mulher) com melhor tempo
            //na etapa classificatória.
            if(temposClassif[i] < melhortempo){
            melhortempo = temposClassif[i];
            String nomeMelhorTempo = nomes[i];
            }

            /*ALOCANDO OS NOMES DOS ATLETAS EM VARIAVEIS PARA CADA PAIS E CONCATENANDO OS NOMES;
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
            */

        }

        //EXERCICIO 1
      // System.out.println("A Média final dos homens é:" + mediaM);
      // System.out.println("A Média final das mulheres é:" + mediaF);

        //EXERCICIO 2
      // System.out.println("Melhor tempo é " + melhortempo +"s" + " do(a) atleta: " + nomeMelhorTempo);

        //EXERCICIO 3
        //System.out.println(verificarPais());

    }

}


package Entidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {
    public static void main(String[] args) {

        Atleta atletas = new Atleta();
        atletas.inicializarDados();
        int numeroAtletas = atletas.recuperarQtdadeAtletas();

        final String usuario = "postgres";
        final String senha = "aluno123";
        final String url = "jdbc:postgresql://localhost:5432/postgres";
        final String instrucao_insert = "INSERT INTO ATLETISMO(nome,pais,sexo,tempoclassificacao,tempofinal) VALUES(?,?,?,?,?)";
        final String driverBanco="org.postgresql.Driver";

        try{
            Class.forName(driverBanco);
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println(numeroAtletas);

            for (int i =0; i<numeroAtletas;i++){
                PreparedStatement pS = conexao.prepareStatement(instrucao_insert);

                pS.setString(1, atletas.recuperarNomeAleta(i));
                pS.setString(2, atletas.recuperarPaisAleta(i));
                pS.setString(3, String.valueOf(atletas.recuperarSexoAleta(i)));
                pS.setFloat(4,  atletas.recuperarTempoClassificacaoAleta(i));
                pS.setFloat(5,  atletas.recuperarTempoFinalAleta(i));


                pS.executeUpdate();
                System.out.println("INCLUSAO ACEITA NO BANCO DE DADOS");

            }


        }catch (Exception exception){
            System.out.println(exception);
        }

    }

        //EXERCICIO 1 e EXERCICIO 2
        //atletas.mediaTempos();

        //EXERCICIO 3
        //atletas.verificarPais();

        //EXERCICIO 4
        //atletas.melhorTempo();

        // Exercicio 5
        //atletas.melhorTemposHomens();

        //Exercicio 6
        //atletas.mostrarAtletasPorSexo();

}


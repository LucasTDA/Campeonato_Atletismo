package Entidades;
//Observe que o país só poderá ser México, Canadá ou USA,
// o sexo só poderá ser F ou M
// o tempo obtido pelo atleta deverá ser um valor entre 8.0 e 25.5 segundos (terá que ser maior ou
//igual que 8.0 e menor ou igual que 25.5 segundos)...

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {

        Atleta atletas = new Atleta();
        atletas.inicializarDados();

        //EXERCICIO 1 e EXERCICIO 2
        //atletas.mediaTempos();

        //EXERCICIO 3
        //atletas.verificarPais();

        //EXERCICIO 4
        //atletas.melhorTempo();

        // Exerciico 5
        atletas.melhorTemposHomens();
    }

}


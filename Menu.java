package Jogo;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        ArrayList<Arma> armasGuerreiro = new ArrayList<>();
        armasGuerreiro.add(new Arma("Espada", 90, 70, "Caos"));
        armasGuerreiro.add(new Arma("Machado", 80, 60, "Perfurante"));

        ArrayList<Arma> armasMago = new ArrayList<>();
        armasMago.add(new Arma("Cajado de gelo", 40, 30, "Congelamento"));
        armasMago.add(new Arma("Cedro de fogo", 45, 40, "Queimadura"));

        ArrayList<Arma> armasNinja = new ArrayList<>();
        armasNinja.add(new Arma("Punhal", 85, 40, "Sangramento"));
        armasNinja.add(new Arma("Katana", 95, 60, "Perfuração"));

        ArrayList<Arma> armasArqueiro = new ArrayList<>();
        armasArqueiro.add(new Arma("Flecha Explosiva", 90, 65, "Explosão"));
        armasArqueiro.add(new Arma("Besta Venenosa", 90, 50, "Envenenamento"));

        Scanner entrada = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menu Jogo ---");
            System.out.println("1. Deseja iniciar a Batalha?");
            System.out.println("2. Sair do jogo");
            System.out.print("Escolha uma opção: ");
            int escolha = entrada.nextInt();
            entrada.nextLine();

            switch (escolha) {
                case 1:
                    menuDePersonagens(entrada, armasGuerreiro, armasMago, armasNinja, armasArqueiro);
                    break;
                case 2:
                    System.out.println("Até logo.");
                    entrada.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    public static void menuDePersonagens(Scanner entrada, ArrayList<Arma> armasGuerreiro, ArrayList<Arma> armasMago,
            ArrayList<Arma> armasNinja, ArrayList<Arma> armasArqueiro) {
        while (true) {
            System.out.println("\n--- Personagens disponíveis ---");
            System.out.println("1. Guerreiro");
            System.out.println("2. Mago");
            System.out.println("3. Ninja");
            System.out.println("4. Arqueiro");

            Personagem jogador1 = escolherPersonagem(entrada, "Jogador 1", armasGuerreiro, armasMago, armasNinja, armasArqueiro);
            Personagem jogador2 = escolherPersonagem(entrada, "Jogador 2", armasGuerreiro, armasMago, armasNinja, armasArqueiro);

            System.out.println("Jogador 1 escolheu: " + jogador1.tipoPersonagem());
            System.out.println("Jogador 2 escolheu: " + jogador2.tipoPersonagem());

            Batalha batalha = new Batalha(jogador1, jogador2);
            batalha.iniciarBatalha();

            System.out.println("\nDeseja jogar novamente? (1. Sim / 2. Não): ");
            int jogarNovamente = entrada.nextInt();
            entrada.nextLine();
            if (jogarNovamente != 1) {
                System.out.println("Até logo.");
                entrada.close();
                System.exit(0);
            }
        }
    }

    public static Personagem escolherPersonagem(Scanner entrada, String jogadorNome, ArrayList<Arma> armasGuerreiro,
            ArrayList<Arma> armasMago, ArrayList<Arma> armasNinja, ArrayList<Arma> armasArqueiro) {
        while (true) {
            System.out.println(jogadorNome + ", escolha um personagem:");
            System.out.println("1. Guerreiro");
            System.out.println("2. Mago");
            System.out.println("3. Ninja");
            System.out.println("4. Arqueiro");

            int escolhaPersonagem;
            System.out.print("Escolha um personagem: ");
            escolhaPersonagem = entrada.nextInt();
            entrada.nextLine(); // Limpar o buffer do scanner

            switch (escolhaPersonagem) {
                case 1:
                    return criarGuerreiro(jogadorNome, armasGuerreiro);
                case 2:
                    return criarMago(jogadorNome, armasMago);
                case 3:
                    return criarNinja(jogadorNome, armasNinja);
                case 4:
                    return criarArqueiro(jogadorNome, armasArqueiro);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static Guerreiro criarGuerreiro(String jogadorNome, ArrayList<Arma> armasGuerreiro) {
        return new Guerreiro(jogadorNome, 100, armasGuerreiro);
    }

    private static Mago criarMago(String jogadorNome, ArrayList<Arma> armasMago) {
        return new Mago(jogadorNome, 100, armasMago);
    }

    private static Ninja criarNinja(String jogadorNome, ArrayList<Arma> armasNinja) {
        return new Ninja(jogadorNome, 100, armasNinja);
    }

    private static Arqueiro criarArqueiro(String jogadorNome, ArrayList<Arma> armasArqueiro) {
        return new Arqueiro(jogadorNome, 100, armasArqueiro);
    }
}
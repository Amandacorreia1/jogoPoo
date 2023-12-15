package Jogo;

import java.util.Scanner;

public class Batalha {
    private Personagem jogador1;
    private Personagem jogador2;

    public Batalha(Personagem jogador1, Personagem jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
    }

    public void iniciarBatalha() {
        System.out.println("Batalha iniciada: " + jogador1.tipoPersonagem() + " vs " + jogador2.tipoPersonagem());
        
        while (jogador1.getVida() > 0 && jogador2.getVida() > 0) {
            realizarTurno(jogador1, jogador2);
            if (jogador2.getVida() <= 0) {
                System.out.println(jogador1.tipoPersonagem()  + " é o vencedor!");
                break;
            }

            realizarTurno(jogador2, jogador1);
            if (jogador1.getVida() <= 0) {
                System.out.println(jogador2.tipoPersonagem() + " é o vencedor!");
                break;
            }
        }

        exibirResultado();
    }

    public void realizarTurno(Personagem atacante, Personagem defensor) {
        System.out.println("\nTurno de " + atacante.getNome());
        
        // Aqui você pode adicionar lógica para que o jogador escolha a arma antes de atacar
        int indiceArmaAtacante = escolherArma(atacante);
        int indiceArmaDefensor = escolherArma(defensor);
        Arma armaAtacante = atacante.getArmas().get(indiceArmaAtacante);
        Arma armaDefensor = defensor.getArmas().get(indiceArmaDefensor);

        // Determinar o vencedor do turno com base na força e precisão das armas
        double chanceAcertoAtacante = (armaAtacante.getPrecisao() * 0.6) + (armaAtacante.getForca() * 0.4);
        double chanceAcertoDefensor = (armaDefensor.getPrecisao() * 0.6) + (armaDefensor.getForca() * 0.4);

        if (chanceAcertoAtacante > chanceAcertoDefensor) {
            System.out.println("O ataque com " + armaAtacante.getNome() + " é bem-sucedido! " + atacante.getNome() + " ganha a jogada!");
            defensor.receberDano(armaAtacante.getForca());
        } else if (chanceAcertoAtacante < chanceAcertoDefensor) {
            System.out.println("O ataque com " + armaDefensor.getNome() + " é bem-sucedido! " + defensor.getNome() + " ganha a jogada!");
            atacante.receberDano(armaDefensor.getForca());
        } else {
            System.out.println("Ambos os ataques falharam!");
        }

        // Exibindo informações de vida após o ataque
        System.out.println("Vida restante de " + defensor.getNome() + ": " + defensor.getVida());
    }

    public int escolherArma(Personagem jogador) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Escolha uma arma:");
        for (int i = 0; i < jogador.getArmas().size(); i++) {
            System.out.println((i + 1) + ". " + jogador.getArmas().get(i).getNome());
        }
        int escolha = ler.nextInt();
        while (escolha < 1 || escolha > jogador.getArmas().size()) {
            System.out.println("Escolha inválida. Por favor, escolha uma arma:");
            escolha = ler.nextInt();
        }
        // Não feche o scanner aqui
        return escolha - 1; // Subtrai 1 porque os índices do array começam em 0   
}
    

    public void exibirResultado() {
        System.out.println("\n--- Resultado da Batalha ---");
        System.out.println(jogador1.getNome() + " - Vida restante: " + jogador1.getVida());
        System.out.println(jogador2.getNome() + " - Vida restante: " + jogador2.getVida());
    }
}
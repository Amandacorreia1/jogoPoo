package Jogo;
import java.util.ArrayList;

public class Personagem{
    private String nome;
    private int vida;
    private ArrayList<Arma> armas;

    public Personagem(String nome, int vida, ArrayList<Arma> armas){
        this.nome = nome;
        this.vida = vida;
        this.armas = armas;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setVida(int vida){
        this.vida = vida;
    }

    public int getVida(){
        return this.vida;
    }
    
    public ArrayList<Arma> getArmas() {
        return this.armas;
    }

    public void setArmas(ArrayList<Arma> armas) {
        this.armas = armas;
    }
    
    public void atacar(Personagem alvo, int indiceArma) {
        Arma arma = this.armas.get(indiceArma);
        int dano = arma.getForca();
        alvo.receberDano(dano);
    }

    public void receberDano(int dano) {
        vida -= dano;
        System.out.println(nome + " recebeu " + dano + " de dano!");
        System.out.println("Vida restante de " + nome + ": " + vida);
        if(vida <= 0) {
            System.out.println(nome + " foi derrotado!");
        }
    }
    public void adicionarArma(Arma arma) {
        this.armas.add(arma);
    }
       
    public String tipoPersonagem(){
        return "Personagens";
    }
}
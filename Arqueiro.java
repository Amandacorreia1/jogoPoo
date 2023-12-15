package Jogo;

import java.util.ArrayList;

public class Arqueiro extends Personagem {
    public Arqueiro(String nome, int vida, ArrayList<Arma> armas){
        super(nome, vida, armas);
    }
        
    @Override
    public String tipoPersonagem(){
        return "Arqueiro";
    }
}

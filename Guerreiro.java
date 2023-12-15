package Jogo;

import java.util.ArrayList;

public class Guerreiro extends Personagem {

    public Guerreiro(String nome, int vida, ArrayList<Arma> armas){
        super(nome, vida, armas);
    }
    
    @Override
    public String tipoPersonagem(){
        return "Guerreiro";
    }
}

    
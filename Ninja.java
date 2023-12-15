package Jogo;

import java.util.ArrayList;

public class Ninja extends Personagem {
    public Ninja(String nome, int vida, ArrayList<Arma> armas){
        super(nome, vida, armas);
    }
    
    @Override
    public String tipoPersonagem(){
        return "Ninja";
    }
}

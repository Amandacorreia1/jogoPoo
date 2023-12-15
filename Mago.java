package Jogo;

import java.util.ArrayList;

public class Mago extends Personagem {
    public Mago(String nome, int vida, ArrayList<Arma> armas){
        super(nome, vida, armas);
    }
      
    
    @Override
    public String tipoPersonagem() {
        return "Mago";
    }
}
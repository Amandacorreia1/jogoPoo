package Jogo;

public class Arma {
    private String nome;
    private int forca;
    private int precisao;
    private String efeitoEspecial;

    public Arma(String nome, int forca, int precisao, String efeitoEspecial){
        this.nome = nome;
        this.forca = forca;
        this.precisao = precisao;
        this.efeitoEspecial = efeitoEspecial;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getPrecisao() {
        return precisao;
    }

    public void setPrecisao(int precisao) {
        this.precisao = precisao;
    }

    public String getEfeitoEspecial() {
        return efeitoEspecial;
    }

    public void setEfeitoEspecial(String efeitoEspecial) {
        this.efeitoEspecial = efeitoEspecial;
    }
    
    public void exibirDetalhesArma() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Força: " + this.forca);
        System.out.println("Precisão: " + this.precisao);
        System.out.println("Efeito Especial: " + this.efeitoEspecial);
    }
    
    public int calcularDano() {
    	int dano = (this.forca / 2) + (this.precisao / 2);
    	//considera que a força e a precisao equivalam a mesma importancia. 50% cada.
        return dano;
    }
    
    public String efeitoEspecial() {
    	return this.efeitoEspecial;
    }
        

}

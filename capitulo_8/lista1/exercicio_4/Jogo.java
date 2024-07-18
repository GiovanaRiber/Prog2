package capitulo_8.lista1.exercicio_4;

public class Jogo {
    
    Ponto p1, p2;
    
    public boolean colidiu(Ponto p1, Ponto p2){
       
       if(p1 == p2){
           
           return true;
       } else {
           
           return false;
       }
   }
    
    public static void main(String[] args){
        
        Heroi heroi = new Heroi();
        Inimigo inimigo = new Inimigo();
        Jogo jogo = new Jogo();
        
        Ponto p1 = heroi.getPosicao();
        Ponto p2 = inimigo.getPosicao();
        
        System.out.println(jogo.colidiu(p1, p2));
        
    }
    
}

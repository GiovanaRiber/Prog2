package Capitulo_6;

public class Robo {
    
   private String nome;
   private int x, y;
   
   private static int quantidadeObjetos = 0;
   
   Robo(){
       
       nome = "";
       x = 0;
       y = 0;
       quantidadeObjetos++;
   }
   
   Robo(String nome, int x, int y){
       
       this.nome = nome;
       this.x = x;
       this.y = y;  
       quantidadeObjetos++;
   }
   
   public int getQuantidade(){
       
       return quantidadeObjetos;
   }
   
   public void setNome(String nome){
       
       this.nome = nome;
   }
   
   public void setX(int x){
        
        this.x = x;
    }
    
    public void setY(int y){
        
        this.y = y;
    }
    
   
   public void setCoordenada(int x, int y){
       
       this.x = x;
       this.y = y; 
   }
   
   public void setAndarDireita(){
       
       x = x + 1; 
   }
   
   public void setAndarEsquerda(){
       
       x = x - 1;
   }
   
   public void setAndarCima(){
       
       y = y + 1;
   }
   
   public void setAndarBaixo(){
       
       y = y - 1;
   }
   
   public int getX(){
       
       return x;
       
   }
   
   public int getY(){
       
       return y; 
   }
   
   public String getNome(){
       
       return nome;
   }
   
   public boolean colidiu(){
       
       if(x == 2 && y == 3){
           
           return true;
       } else {
           
           return false;
       }
   }
   
   public static void main(String[] args) {

    Robo ponto = new Robo();
    
    ponto.setX(2);
    ponto.setY(0);
    
    ponto.setNome("Abacate");
    
    System.out.println(ponto.colidiu());

    System.out.println("Coordenadas atuais de " + ponto.getNome() + " " + ponto.getX() + " " + ponto.getY());
    
    ponto.setAndarCima();
    ponto.setAndarDireita();
    
    System.out.println("Coordenadas atuais de " + ponto.getNome() + " " + ponto.getX() + " " + ponto.getY());
    
    System.out.println("Quantidade de objetos " + ponto.getQuantidade());
   } 
}

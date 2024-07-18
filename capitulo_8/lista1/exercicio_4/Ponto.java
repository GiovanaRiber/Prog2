package capitulo_8.lista1.exercicio_4;

public class Ponto {
    
    private int x, y;
    
    Ponto(int x, int y){
        
        this.x = x;
        this.y = y;
    }
    
    Ponto(){
        
        this.x = 0;
        this.y = 0;
    }
    
    public void setX(int x){
        
        this.x = x;
    }
    
    public void setY(int y){
        
        this.y = y;
    }
    
    public int getX(){
        
        return x;   
    }
    
    public int getY(){
        
        return y;
    }
    
}

package capitulo_7.Lista2;

public abstract class Robo {
    
    private int codigo;
    private String nome;
    private int x;
    private int y;
    
    public Robo() {
        codigo = 0;
        nome = "";
        x = 0;
        y = 0;
    }
    
    public Robo(int codigo, String nome, int x, int y) {
        this.codigo = codigo;
        this.nome = nome;
        this.x = x;
        this.y = y;
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
    
    public void setAndarFrente(int x){
        x = x + 1;
    }
    
    public void setAndarTras(int x){
        x = x - 1;
    }
    
    public void setAndarCima(int y) {
        y = y + 1;
    }
    
    public void setAndarBaixo(int y) {
        y = y - 1;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
}

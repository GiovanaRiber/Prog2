package capitulo_7.Lista2;

public class Plutoniano extends Robo{
    
    private int balas;
    
    public Plutoniano(){
        setX(0);
        setY(0);
        setNome("RoboPlutoniano");
        this.balas = balas;
    }
    
    public void teletransporte(int x, int y){
        setX(x);
        setY(y);
    }
    
    public void toString(String tipo){
        System.out.println("Sou um robo do tipo " + tipo);
    }
    
    public void recarregar(int quantidade){
        balas = quantidade;
    }
    
    public void atirar(){
        if(balas > 0)
            balas = balas - 1;
    } 
}

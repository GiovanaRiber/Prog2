package capitulo_7.Lista2;

public class Marciano extends Robo{
    
    public Marciano(){
        setX(0);
        setY(0);
        setNome("RoboMarciano");
    }
    
    public void teletransporte(int x, int y){
        setX(x);
        setY(y);
    }
    
    public void toString(String tipo){
        System.out.println("Sou um robo do tipo " + tipo);
    }
 
}

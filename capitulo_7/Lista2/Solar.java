package capitulo_7.Lista2;

public class Solar extends Robo{
    
    private boolean raio;
    
    public Solar(){
        setX(0);
        setY(0);
        setNome("RoboSolar");
    }
    
    public void setRaio(boolean raio){
        this.raio = raio;
    }
    
    public boolean getRaio(){
        return raio;
    }
    
    public void toString(String tipo){
        System.out.println("Sou um robo do tipo " + tipo);
    }
}

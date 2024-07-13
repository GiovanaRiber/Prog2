package capitulo_7.Lista1;

public class Cilindro extends Circulo{
    
    private Double altura;
    private Double area;
    
    Cilindro(Double raio, Double area, Double altura){
        
        super(raio, area);
        this.altura = altura;
    }
    
    public void setCalculaArea(Double raio){
        area = (2 * (3.14 * (raio*raio))) + (2 * (3.14 * raio * altura));
    }
    
    public Double getArea(){
        return area;
    }
    
    public static void main(String[] args){
        
        Cilindro cilindro = new Cilindro(5.0, 8.0, 3.0);
        
        cilindro.setCalculaArea(5.0);
        
        System.out.println(cilindro.getArea());
        
    }
}

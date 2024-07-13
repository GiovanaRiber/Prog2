package capitulo_7.Lista1;

public class Circulo {
    
    private Double raio;
    private Double area;
    
    Circulo(){
        raio = 0.0;
        area = 0.0;
    }
    
    public Circulo(Double raio, Double area){
        this.raio = raio;
        this.area = area;
    }
    
    public void setCalculaArea(Double raio){
        area = 3.14 * (raio*raio);
    }
    
    public Double getArea(){
        return area;
    }
    
}

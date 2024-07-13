package capitulo_7.Teste;

public class Motocicleta extends Veiculo{
    
    private Integer cilindradas;
    private static Double IPVA;
    
    public Motocicleta(String marca, Integer ano, Double valor, Integer cilindradas){
        
        super(marca, ano, valor);
        this.cilindradas = cilindradas;
    }
    
    public Double calculaIPVA(Integer ano, Double valor){
        
        if(ano > 2014){
            
            IPVA = valor * 0.02;
            return IPVA;
        }
        
        IPVA = 0.0;
        return IPVA;
    }
    
    /*public static void main(String[] args){
        
        Motocicleta moto = new Motocicleta("Banana", 2021, 12000.00, 452);
        
        System.out.println(moto.calculaIPVA(2021, 12000.00));
        
    }*/
}

package capitulo_7.Teste;

import capitulo_7.Teste.Motocicleta;

public class Veiculo {
    
    private String marca;
    private Integer ano;
    private Double valor;
    
    public Veiculo(String marca, Integer ano, Double valor){
        
        this.marca = marca;
        this.ano = ano;
        this.valor = valor;
    }
    
    public String getMarca(){
        return marca;
    }
    
    public Integer getAno(){
        return ano;
    }
    
    public Double getVelor(){
        return valor;
    }
    
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    public void SetAno(Integer ano){
        this.ano = ano;
    }
    
    public void SetValor(Double valor){
        this.valor =  valor;
    }
    
    public static void main(String[] args){
        
        Veiculo veiculo = new Veiculo("Banana", 2021, 12000.00);
        
        Motocicleta motocicleta = new Motocicleta("Banana", 2021, 12000.00, 452);
        
        motocicleta.calculaIPVA(2021, 12000.00);
        
        Caminhao caminhao = new Caminhao("Abacate", 2017, 400000.00);
        
        CaminhaoBiTrem caminhaoBiTrem = new CaminhaoBiTrem("Abacate", 2017, 400000.00);
        
        System.out.println(motocicleta.calculaIPVA(2021, 12000.00));
        System.out.println(caminhao.calculaIPVA(2018, 400000.00));
        System.out.println(caminhaoBiTrem.calculaIPVA(2017, 700000.00));
        
    }
}